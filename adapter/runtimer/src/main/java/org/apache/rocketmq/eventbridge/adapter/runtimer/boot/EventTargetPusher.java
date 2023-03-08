package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import com.google.common.collect.Lists;
import io.netty.util.internal.ConcurrentSet;
import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.commons.collections.MapUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.pusher.PusherTaskContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.PluginClassLoader;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimeConfigDefine;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

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

    private List<SinkTask> pusherTasks = new CopyOnWriteArrayList<>();

    public EventTargetPusher(Plugin plugin, ListenerFactory listenerFactory){
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
    }

    /**
     * init running tasks
     * @param taskConfig
     */
    public void initOrUpdatePusherTask(Map<String, List<TargetKeyValue>> taskConfig){
        Set<TargetKeyValue> taskProperty = new HashSet<>();
        for(String connectName : taskConfig.keySet()){
            List<TargetKeyValue> targetKeyValues = taskConfig.get(connectName);
            taskProperty.addAll(new HashSet<>(targetKeyValues));
        }
        for(TargetKeyValue targetKeyValue : taskProperty){
            try{
                String taskClass = targetKeyValue.getString(RuntimeConfigDefine.TASK_CLASS);
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
                sinkTask.init(targetKeyValue);
                PusherTaskContext sinkTaskContext = new PusherTaskContext(targetKeyValue);
                sinkTask.start(sinkTaskContext);
                pusherTasks.add(sinkTask);
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
            Map<TargetKeyValue, ConnectRecord> taskPusher = listenerFactory.takeTargetMap();
            if(MapUtils.isEmpty(taskPusher)){
                continue;
            }
            TargetKeyValue targetKeyValue = taskPusher.keySet().iterator().next();
            // task-id for unique-key at ConnectKeyValue
            // ConnectKeyValue -> new class for name
            // also add in ConnectRecord class system property
            String taskPushName = targetKeyValue.getString(RuntimeConfigDefine.TASK_CLASS);
            // add thread pool
            for(SinkTask sinkTask : pusherTasks){
                if(sinkTask.getClass().getName().equals(taskPushName)){
                    sinkTask.put(Lists.newArrayList(taskPusher.get(targetKeyValue)));
                }
            }
        }
    }

    @Override
    public String getServiceName() {
        return EventTargetPusher.class.getSimpleName();
    }
}
