package com.dvsnier.base.task;

import android.support.annotation.NonNull;

/**
 * Created by lizw on 2016/5/19.
 */
public interface IBaseResult<T> extends IOnErrorListener {

    void onResponse(@NonNull T bean);
}
