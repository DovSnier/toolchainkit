package com.dvsnier.base.task.handle;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.dvsnier.base.task.IRunnable;

/**
 * view operation thread  interface
 * Created by lizw on 2016/4/6.
 */
public interface IHandle extends IBaseAdapter {

    /**
     * Return the Looper for the main thread of the current process.  This is
     * the thread used to dispatch calls to application components (activities,
     * services, etc).
     *
     * @return The main handle.
     */
    Handler getMainHandler();

    /**
     * @param runnable The Runnable that will be executed.
     */
    void post(@NonNull IRunnable runnable);

    /**
     * @param runnable    The Runnable that will be executed.
     * @param delayMillis The delay (in milliseconds) until the Runnable
     *                    will be executed.
     */
    void postDelayed(@NonNull IRunnable runnable, long delayMillis);
}
