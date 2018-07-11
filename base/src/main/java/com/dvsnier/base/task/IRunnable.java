package com.dvsnier.base.task;

/**
 * Created by lizw on 2016/6/4.
 */
public interface IRunnable extends Runnable {

    /**
     * whether the thread is out of date
     */
    boolean isExpired();

    /**
     * whether or not the thread is expired
     *
     * @param expired true is expired whether no
     */
    void setExpired(boolean expired);

    /**
     * getting the delayed execution timestamp
     */
    long getDelayMillis();

    /**
     * setting the delay execution time stamp
     *
     * @param delayMillis the delay time stamp
     */
    void setDelayMillis(long delayMillis);

    /**
     * marking delay
     */
    void setDelay();

    /**
     * whether or not a thread is forced to execute
     */
    boolean isForce();

    /**
     * Set a thread to enforce
     *
     * @param force true is force whether no
     */
    void setForce(boolean force);
}
