package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import io.netty.util.internal.ConcurrentSet;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * for event target push to sink task
 * @author artisan
 */
public class EventTargetPusher {

    private Set<Runnable> runningTasks = new ConcurrentSet<>();

    private Set<Runnable> errorTasks = new ConcurrentSet<>();

    private Set<Runnable> cleanedErrorTasks = new ConcurrentSet<>();

    private Map<Runnable, Long/*timestamp*/> stoppingTasks = new ConcurrentHashMap<>();

    private Set<Runnable> stoppedTasks = new ConcurrentSet<>();

    private Set<Runnable> cleanedStoppedTasks = new ConcurrentSet<>();


}
