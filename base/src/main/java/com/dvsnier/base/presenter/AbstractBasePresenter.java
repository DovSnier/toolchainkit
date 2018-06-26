package com.dvsnier.base.presenter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

/**
 * Created by lizw on 2016/5/20.
 */
public abstract class AbstractBasePresenter<T> implements IBasePresenter {

    protected String TAG = this.getClass().getSimpleName();
    protected Context context;

    public AbstractBasePresenter() {
    }

    public AbstractBasePresenter(@NonNull Context context) {
        this.context = context;
    }

    @Override
    @CallSuper
    public void onDestroy() {
    }
}
