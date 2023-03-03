package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import io.netty.util.internal.ConcurrentSet;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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

    public EventTargetPusher(Plugin plugin, ListenerFactory listenerFactory){
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
    }

    @Override
    public String getServiceName() {
        return EventTargetPusher.class.getSimpleName();
    }

    public void init(){

    }

    @Override
    public void run() {

    }
}
