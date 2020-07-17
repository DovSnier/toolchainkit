package com.dvsnier.base.task;

/**
 * Created by lizw on 2016/3/5.
 */
public abstract class AbstractUIRunnable implements IStashRunnable {

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
    public boolean isDelay() {
        return getDelayMillis() > 0;
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
    public void setDelay(int flag) {
        if (isDelay()) {
            delayMillis -= System.currentTimeMillis() - lastTimeMillis;
            if (delayMillis < 0) {
                delayMillis = 0;
                if (ITaskStrategy.TIMEOUT_STRATEGY == flag) setExpired(true);
            }
        }
        lastTimeMillis = System.currentTimeMillis();
    }

    @Override
    public boolean isForce() {
        return force;
    }

    @Override
    public void setForce(boolean force) {
        this.force = force;
    }

    @Override
    public final void run() {
        stashRun();
    }
}
