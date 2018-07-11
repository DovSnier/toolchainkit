package com.dvsnier.base.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.dvsnier.base.task.IRunnable;
import com.dvsnier.base.task.handle.HandleAdapter;
import com.dvsnier.base.task.handle.IHandle;

/**
 * Created by lizw on 2016/6/15.
 */
public abstract class AbstractCycleBaseView extends AbstractBaseView implements IHandle {

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

    @Override
    public void onStart() {
        super.onStart();
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null != handleAdapter && handleAdapter instanceof HandleAdapter) {
            ((HandleAdapter) handleAdapter).onPause();
        }
    }

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
    public void post(IRunnable runnable) {
        if (null != handleAdapter) {
            handleAdapter.post(runnable);
        }
    }

    @Override
    public void postDelayed(IRunnable runnable, long delayMillis) {
        if (null != handleAdapter) {
            handleAdapter.postDelayed(runnable, delayMillis);
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
