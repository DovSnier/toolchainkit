package com.dvsnier.base.task.handle;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import com.dvsnier.base.task.IBaseTask;
import com.dvsnier.base.task.ICycle;
import com.dvsnier.base.task.ILifeCycle;
import com.dvsnier.base.task.IRunnable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lizw on 2016/4/10.
 */
public abstract class AbstractHandleAdapter implements ICycle, ILifeCycle, IBaseTask {

    @SuppressWarnings({"unchecked", "WeakerAccess", "SpellCheckingInspection"})
    protected final List<IRunnable> quequPool = new LinkedList();
    @Nullable
    protected Context context;
    @SuppressWarnings("WeakerAccess")
    protected Handler handler;
    protected int accessibility;

    public AbstractHandleAdapter() {
        handler = new Handler(Looper.getMainLooper());
    }

    public AbstractHandleAdapter(Context context) {
        this.context = context;
        handler = new Handler(Looper.getMainLooper());
    }

    @CallSuper
    @Override
    public void onStart() {
        accessibility = LIFE_START_FLAG & CYCLE_MASK;
    }

    @CallSuper
    @Override
    public void onResume() {
        accessibility = LIFE_RESUME_FLAG & CYCLE_MASK;
    }

    @CallSuper
    @Override
    public void onPause() {
        accessibility = LIFE_PAUSE_FLAG & CYCLE_MASK;
    }

    @CallSuper
    @Override
    public void onStop() {
        accessibility = LIFE_STOP_FLAG & CYCLE_MASK;
    }

    @CallSuper
    @Override
    public void onDestroy() {
        accessibility = CYCLE_DESTROY_FLAG;
        if (null != context) {
            context = null;
        }
        //noinspection ConstantConditions
        if (null != quequPool && !quequPool.isEmpty()) {
            quequPool.clear();
        }
        if (null != handler) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Nullable
    public Context getContext() {
        return context;
    }

    public void setContext(@Nullable Context context) {
        this.context = context;
    }
}
