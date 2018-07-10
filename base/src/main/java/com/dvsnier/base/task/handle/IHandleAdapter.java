package com.dvsnier.base.task.handle;

import com.dvsnier.base.task.IRunnable;

/**
 * the stash thread is executed in the main thread when the current view is visible.
 * Created by lizw on 2016/4/8.
 */
public interface IHandleAdapter {

    void stashOnRun(IRunnable runnable);

    void stashOnRun(IRunnable runnable, long delayMillis);
}
