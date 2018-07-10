package com.dvsnier.base.task;

import android.os.Looper;

/**
 * Created by lizw on 2016/6/4.
 */
public interface IRunnable extends Runnable {

    /**
     * Return the Looper for the main thread of the current process.  This is
     * the thread used to dispatch calls to application components (activities,
     * services, etc).
     * <p>
     * By definition, this method returns the same result as would be obtained
     * by calling {@link Looper#getMainLooper() Looper.getMainLooper()}.
     * </p>
     *
     * @return The main looper.
     */
    Looper getMainLooper();

    long getDelayMillis();

    void setDelayMillis(long delayMillis);
}
