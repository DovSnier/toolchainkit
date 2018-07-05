package com.dvsnier.base.view;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import com.dvsnier.base.task.ICycle;
import com.dvsnier.base.task.ILifeCycle;

/**
 * Created by lizw on 2016/6/15.
 */
public abstract class AbstractBaseView<T> implements IBaseView, ICycleView {

    protected String TAG = this.getClass().getSimpleName();
    protected Context context;
    protected T presenter;

    public AbstractBaseView() {
    }

    public AbstractBaseView(@Nullable Context context) {
        this.context = context;
    }

    @CallSuper
    @Override
    public void onStart() {
        if (null != getPresenter() && getPresenter() instanceof ILifeCycle) {
            ((ILifeCycle) getPresenter()).onStart();
        }
    }

    @CallSuper
    @Override
    public void onResume() {
        if (null != getPresenter() && getPresenter() instanceof ILifeCycle) {
            ((ILifeCycle) getPresenter()).onResume();
        }
    }

    @CallSuper
    @Override
    public void onPause() {
        if (null != getPresenter() && getPresenter() instanceof ILifeCycle) {
            ((ILifeCycle) getPresenter()).onPause();
        }
    }

    @CallSuper
    @Override
    public void onStop() {
        if (null != getPresenter() && getPresenter() instanceof ILifeCycle) {
            ((ILifeCycle) getPresenter()).onStop();
        }
    }

    @CallSuper
    @Override
    public void onDestroy() {
        if (null != getPresenter() && getPresenter() instanceof ICycle) {
            ((ICycle) getPresenter()).onDestroy();
        }
        if (null != context) {
            context = null;
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
    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
