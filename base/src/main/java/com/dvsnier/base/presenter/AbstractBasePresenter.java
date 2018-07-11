package com.dvsnier.base.presenter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * abstract base presenter
 * Created by lizw on 2016/5/20.
 */
public abstract class AbstractBasePresenter<T> implements IBasePresenter, ICyclePresenter {

    protected String TAG = this.getClass().getSimpleName();
    protected Context context;
    protected T view;
    @SuppressWarnings("WeakerAccess")
    protected int accessibility;

    public AbstractBasePresenter() {
    }

    public AbstractBasePresenter(@NonNull Context context) {
        this.context = context;
    }

    @CallSuper
    @Override
    public void onStart() {
        accessibility = LIFE_START_FLAG;
    }

    @CallSuper
    @Override
    public void onResume() {
        accessibility = LIFE_RESUME_FLAG;
    }

    @CallSuper
    @Override
    public void onPause() {
        accessibility = LIFE_PAUSE_FLAG;
    }

    @CallSuper
    @Override
    public void onStop() {
        accessibility = LIFE_STOP_FLAG;
    }

    @CallSuper
    @Override
    public void onDestroy() {
        accessibility = CYCLE_DESTROY_FLAG;
        if (null != context) {
            context = null;
        }
        if (null != view) {
            view = null;
        }
    }

    @Nullable
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Nullable
    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }
}
