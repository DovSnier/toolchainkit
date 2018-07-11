package com.dvsnier.base.task;

/**
 * Created by lizw on 2016/3/5.
 */
public abstract class UIRunnable implements IStashRunnable {

    private boolean expired;
    private long delayMillis;
    private long lastTimeMillis;
    private boolean force;

    @Override
    public boolean isExpired() {
        return expired;
    }

    @Override
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @Override
    public long getDelayMillis() {
        return delayMillis;
    }

    @Override
    public void setDelayMillis(long delayMillis) {
        this.delayMillis = delayMillis;
        lastTimeMillis = System.currentTimeMillis();
    }

    @Override
    public void setDelay() {
        // TODO: 延期算法
    }

    @Override
    public boolean isForce() {
        return force;
    }

    @Override
    public void setForce(boolean force) {
        this.force = force;
    }
}
