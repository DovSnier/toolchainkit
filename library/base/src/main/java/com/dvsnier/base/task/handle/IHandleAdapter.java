package com.dvsnier.base.task.handle;

import android.support.annotation.NonNull;

import com.dvsnier.base.task.IRunnable;

/**
 * the stash thread is executed in the main thread when the current view is visible.
 * Created by lizw on 2016/4/8.
 */
public interface IHandleAdapter extends IBaseAdapter {

    /**
     * the stash thread to the appropriate time to execute
     *
     * @param runnable {@see IRunnable}
     */
    void stashOnRun(@NonNull IRunnable runnable);

    /**
     * the stash thread to the appropriate time to execute
     *
     * @param runnable    {@see IRunnable}
     * @param delayMillis the time stamp
     */
    void stashOnRun(@NonNull IRunnable runnable, long delayMillis);
}
