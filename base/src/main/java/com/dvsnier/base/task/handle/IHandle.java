package com.dvsnier.base.task.handle;

import com.dvsnier.base.task.IRunnable;

/**
 * Created by lizw on 2016/4/6.
 */
public interface IHandle {

    /**
     * @param runnable The Runnable that will be executed.
     */
    void post(IRunnable runnable);

    /**
     * @param runnable    The Runnable that will be executed.
     * @param delayMillis The delay (in milliseconds) until the Runnable
     *                    will be executed.
     */
    void postDelayed(IRunnable runnable, long delayMillis);
}
