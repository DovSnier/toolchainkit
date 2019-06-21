package com.dvsnier.utils.runnable;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * ui thread interface
 * Created by lizw on 2016/7/25.
 */
public interface IUiThread {

    /**
     * whether the current thread is a ui thread
     *
     * @return true ui thread otherwise no
     */
    boolean isUIThread();

    /**
     * run to the ui thread to execute the task
     *
     * @param context  {@see Context}
     * @param runnable {@see Runnable}
     */
    void runUiThread(@NonNull Context context, Runnable runnable);

    /**
     * delay running to the ui thread to execute the task
     *
     * @param context     {@see Context}
     * @param runnable    {@see Runnable}
     * @param delayMillis delay time, in milliseconds
     */
    void runUiThread(@NonNull Context context, Runnable runnable, long delayMillis);
}
