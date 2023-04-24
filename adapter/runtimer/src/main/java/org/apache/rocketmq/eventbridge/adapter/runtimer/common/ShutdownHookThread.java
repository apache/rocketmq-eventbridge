package org.apache.rocketmq.eventbridge.adapter.runtimer.common;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;

public class ShutdownHookThread extends Thread {
    private volatile boolean hasShutdown = false;
    private AtomicInteger shutdownTimes = new AtomicInteger(0);
    private final Logger log;
    private final Callable callback;
    //需要顺序执行关闭的线程集合
    private ConcurrentHashMap<Thread, ExecutorService> poolExecuteConcurrentHashMap;
    public ShutdownHookThread(Logger log, Callable callback, ConcurrentHashMap<Thread, ExecutorService> poolExecuteConcurrentHashMap) {
        super("ShutdownHook");
        this.log = log;
        this.callback = callback;
        this.poolExecuteConcurrentHashMap = poolExecuteConcurrentHashMap;
    }

    public ShutdownHookThread(Logger log, Callable callback) {
        this.log = log;
        this.callback = callback;

    }


    @Override
    public void run() {
        synchronized (this) {
            log.info("shutdown hook was invoked, " + this.shutdownTimes.incrementAndGet() + " times.");
            if (!this.hasShutdown) {
                this.hasShutdown = true;
                long beginTime = System.currentTimeMillis();
                try {
                    register();
                } catch (Exception e) {
                    unregister();
                    log.error("shutdown hook callback invoked failure. ", e);
                }
                long consumingTimeTotal = System.currentTimeMillis() - beginTime;
                log.info("shutdown hook done, consuming time total(ms): " + consumingTimeTotal);
            }
        }
    }
    private void register(){
        Runtime.getRuntime().addShutdownHook( new ShutdownHookThread(log,() -> {
            poolExecuteConcurrentHashMap.forEach( (k,v) -> {
                if(Optional.ofNullable(v).isPresent())
                    v.execute(k);
            } );
            return null;
        }) );
    }

    public void unregister() {
        Runtime.getRuntime().removeShutdownHook(new ShutdownHookThread(log,() -> {
            poolExecuteConcurrentHashMap.forEach( (k,v) -> {
                if(Optional.ofNullable(v).isPresent())
                    v.shutdown();
            });
            return null;
        }));
    }

}
