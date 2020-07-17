package com.dvsnier.base.task;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by lizw on 2016/6/5.
 */
public interface ITaskStrategy {

    /**
     * in general, the default thread mode is executed directly in the life cycle after the thread has timed out.
     */
    int TRADITIONAL_STRATEGY = 0;

    /**
     * after the thread has timed out, the task is discarded directly and no longer executes in the life cycle.
     */
    int TIMEOUT_STRATEGY = 1;

    /**
     * set the default task thread execution policy mode, which is globally valid in the current lifecycle.
     *
     * @param flag {@link ITaskStrategy#TRADITIONAL_STRATEGY} or {@link ITaskStrategy#TIMEOUT_STRATEGY}
     */
    void setTaskStrategy(@TaskStrategy int flag);

    @IntDef({TRADITIONAL_STRATEGY, TIMEOUT_STRATEGY})
    @Retention(SOURCE)
    public @interface TaskStrategy {
    }
}
