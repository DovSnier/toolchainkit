package com.dvsnier.base.task;

import android.support.annotation.NonNull;

/**
 * Created by lizw on 2016/3/5.
 */
public interface IStashRunnable<T> extends IRunnable {

    void run(@NonNull T view);
}
