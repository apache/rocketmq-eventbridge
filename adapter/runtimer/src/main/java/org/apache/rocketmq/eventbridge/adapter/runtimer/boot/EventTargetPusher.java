package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import com.google.common.collect.Lists;
import io.netty.util.internal.ConcurrentSet;
import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.commons.collections.MapUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.pusher.PusherTaskContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ConnectKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.PluginClassLoader;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimeConfigDefine;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * for event target push to sink task
 * @author artisan
 */
public class EventTargetPusher extends ServiceThread {

    private Set<Runnable> runningTasks = new ConcurrentSet<>();

    private Set<Runnable> errorTasks = new ConcurrentSet<>();

    private Set<Runnable> stoppedTasks = new ConcurrentSet<>();

    private Plugin plugin;

    private ListenerFactory listenerFactory;

    private List<SinkTask> runTasks = Lists.newArrayList();

    public EventTargetPusher(Plugin plugin, ListenerFactory listenerFactory){
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
    }

    /**
     * init running tasks
     * @param taskConfig
     */
    public void init(Map<String, List<ConnectKeyValue>> taskConfig){
        Set<ConnectKeyValue> taskProperty = new HashSet<>();
        for(String connectName : taskConfig.keySet()){
            List<ConnectKeyValue> connectKeyValues = taskConfig.get(connectName);
            taskProperty.addAll(new HashSet<>(connectKeyValues));
        }
        for(ConnectKeyValue connectKeyValue : taskProperty){
            try{
                String taskClass = connectKeyValue.getString(RuntimeConfigDefine.TASK_CLASS);
                ClassLoader loader = plugin.getPluginClassLoader(taskClass);
                Class taskClazz;
                boolean isolationFlag = false;
                if (loader instanceof PluginClassLoader) {
                    taskClazz = ((PluginClassLoader) loader).loadClass(taskClass, false);
                    isolationFlag = true;
                } else {
                    taskClazz = Class.forName(taskClass);
                }
                SinkTask sinkTask = (SinkTask) taskClazz.getDeclaredConstructor().newInstance();
                sinkTask.init(connectKeyValue);
                PusherTaskContext sinkTaskContext = new PusherTaskContext(connectKeyValue);
                sinkTask.start(sinkTaskContext);
                runTasks.add(sinkTask);
                if (isolationFlag) {
                    Plugin.compareAndSwapLoaders(loader);
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (!stopped){
            Map<ConnectKeyValue, ConnectRecord> taskPusher = listenerFactory.takeTargetMap();
            if(MapUtils.isEmpty(taskPusher)){
                continue;
            }
            ConnectKeyValue connectKeyValue = taskPusher.keySet().iterator().next();
            String taskPushName = connectKeyValue.getString(RuntimeConfigDefine.TASK_CLASS);
            for(SinkTask sinkTask : runTasks){
                if(sinkTask.getClass().getName().equals(taskPushName)){
                    sinkTask.put(Lists.newArrayList(taskPusher.get(connectKeyValue)));
                }
            }
        }
    }

    @Override
    public String getServiceName() {
        return EventTargetPusher.class.getSimpleName();
    }
}
