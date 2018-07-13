package com.dvsnier.base.task;

import android.support.annotation.NonNull;

/**
 * Created by lizw on 2016/3/5.
 */
public interface IStashRunnable<T> extends IRunnable {

    /**
     * the stash task
     */
    void stashRun();

    /**
     * the currently executed tasks
     *
     * @param view the current view
     */
    void run(@NonNull T view);
}
