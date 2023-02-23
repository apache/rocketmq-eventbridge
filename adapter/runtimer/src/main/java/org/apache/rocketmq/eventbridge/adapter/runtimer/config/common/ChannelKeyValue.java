package org.apache.rocketmq.eventbridge.adapter.runtimer.config.common;

import java.io.Serializable;
import java.util.Set;

import io.openmessaging.KeyValue;

public class ChannelKeyValue implements KeyValue, Serializable, Cloneable{

    @Override
    public KeyValue put(String key, int value) {
        return null;
    }

    @Override
    public KeyValue put(String key, long value) {
        return null;
    }

    @Override
    public KeyValue put(String key, double value) {
        return null;
    }

    @Override
    public KeyValue put(String key, String value) {
        return null;
    }

    @Override
    public int getInt(String key) {
        return 0;
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return 0;
    }

    @Override
    public long getLong(String key) {
        return 0;
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return 0;
    }

    @Override
    public double getDouble(String key) {
        return 0;
    }

    @Override
    public double getDouble(String key, double defaultValue) {
        return 0;
    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public String getString(String key, String defaultValue) {
        return null;
    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }
}
