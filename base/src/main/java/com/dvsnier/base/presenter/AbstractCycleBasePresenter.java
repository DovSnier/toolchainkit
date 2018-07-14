package com.dvsnier.base.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvsnier.base.task.IRunnable;
import com.dvsnier.base.task.handle.HandleAdapter;
import com.dvsnier.base.task.handle.IHandleAdapter;

/**
 * Created by lizw on 2016/6/15.
 */
public abstract class AbstractCycleBasePresenter<T> extends AbstractBasePresenter<T> implements IHandleAdapter {

    @Nullable
    private IHandleAdapter handleAdapter;

    public AbstractCycleBasePresenter() {
        handleAdapter = new HandleAdapter();
    }

    public AbstractCycleBasePresenter(@NonNull Context context) {
        super(context);
        handleAdapter = new HandleAdapter(context);
    }

    public AbstractCycleBasePresenter(T view) {
        super(view);
        handleAdapter = new HandleAdapter(context);
    }

    @Override
    public void stashOnRun(@NonNull IRunnable runnable) {
        if (null != handleAdapter) {
            handleAdapter.stashOnRun(runnable);
        }
    }

    @Override
    public void stashOnRun(@NonNull IRunnable runnable, long delayMillis) {
        if (null != handleAdapter) {
            handleAdapter.stashOnRun(runnable, delayMillis);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).onDestroy();
            handleAdapter = null;
        }
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).setContext(context);
        }
    }
}
