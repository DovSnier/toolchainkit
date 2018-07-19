package com.dvsnier.base.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvsnier.base.presenter.AbstractCycleBasePresenter;
import com.dvsnier.base.task.IRunnable;
import com.dvsnier.base.task.ITaskStrategy;
import com.dvsnier.base.task.handle.HandleAdapter;
import com.dvsnier.base.task.handle.IHandle;

/**
 * Created by lizw on 2016/6/15.
 */
public abstract class AbstractCycleBaseView<T> extends AbstractBaseView<T> implements IHandle, ITaskStrategy {

    @SuppressWarnings("WeakerAccess")
    @Nullable
    protected IHandle handleAdapter;

    public AbstractCycleBaseView() {
        handleAdapter = new HandleAdapter();
    }

    public AbstractCycleBaseView(@Nullable Context context) {
        super(context);
        handleAdapter = new HandleAdapter(context);
    }

    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).onStart();
        }
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).onResume();
        }
    }

    @CallSuper
    @Override
    public void onPause() {
        super.onPause();
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).onPause();
        }
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).onStop();
        }
    }

    @Override
    public Handler getMainHandler() {
        if (handleAdapter != null) {
            return handleAdapter.getMainHandler();
        }
        return null;
    }

    @Override
    public void post(@NonNull IRunnable runnable) {
        if (null != handleAdapter) {
            handleAdapter.post(runnable);
        }
    }

    @Override
    public void postDelayed(@NonNull IRunnable runnable, long delayMillis) {
        if (null != handleAdapter) {
            handleAdapter.postDelayed(runnable, delayMillis);
        }
    }

    @CallSuper
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).onDestroy();
            handleAdapter = null;
        }
    }

    @Override
    public void setTaskStrategy(@TaskStrategy int flag) {
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).setTaskStrategy(flag);
        }
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).setContext(context);
        }
    }

    @Override
    public void setPresenter(T presenter) {
        super.setPresenter(presenter);
        if (null != presenter) {
            if (presenter instanceof AbstractCycleBasePresenter) {
                if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
                    ((AbstractCycleBasePresenter) presenter).setHandleAdapter((HandleAdapter) handleAdapter);
                }
            }
        }
    }
}
