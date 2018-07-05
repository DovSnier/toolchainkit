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

    public AbstractBasePresenter() {
    }

    public AbstractBasePresenter(@NonNull Context context) {
        this.context = context;
    }

    @CallSuper
    @Override
    public void onStart() {
    }

    @CallSuper
    @Override
    public void onResume() {
    }

    @CallSuper
    @Override
    public void onPause() {
    }

    @CallSuper
    @Override
    public void onStop() {
    }

    @CallSuper
    @Override
    public void onDestroy() {
        if (null != context)
            context = null;
        if (null != view)
            view = null;
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
