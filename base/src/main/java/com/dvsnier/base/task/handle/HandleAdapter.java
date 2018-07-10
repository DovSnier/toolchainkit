package com.dvsnier.base.task.handle;

import android.content.Context;
import android.support.annotation.Nullable;

import com.dvsnier.base.task.ICycle;
import com.dvsnier.base.task.ILifeCycle;
import com.dvsnier.base.task.IRunnable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lizw on 2016/4/10.
 */
public class HandleAdapter implements IHandle, IHandleAdapter, ICycle, ILifeCycle {

    @Nullable
    protected Context context;
    @SuppressWarnings({"unchecked", "WeakerAccess", "SpellCheckingInspection"})
    protected final List<IRunnable> quequPool = new LinkedList();

    public HandleAdapter() {
    }

    public HandleAdapter(@Nullable Context context) {
        this.context = context;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void post(IRunnable runnable) {
    }

    @Override
    public void postDelayed(IRunnable runnable, long delayMillis) {

    }

    @Override
    public void stashOnRun(IRunnable runnable) {
        if (null != runnable) {
            if (!quequPool.contains(runnable)) {
                quequPool.add(runnable);
            }
        }
    }

    @Override
    public void stashOnRun(IRunnable runnable, long delayMillis) {
        if (null != runnable) {
            if (delayMillis > 0) {
                runnable.setDelayMillis(delayMillis);
            } else {
                runnable.setDelayMillis(0);
            }
            if (!quequPool.contains(runnable)) {
                quequPool.add(runnable);
            }
        }
    }

    @Override
    public void onDestroy() {
        if (null != context) {
            context = null;
        }
        //noinspection ConstantConditions
        if (null != quequPool && !quequPool.isEmpty()) {
            quequPool.clear();
        }
    }

    @Nullable
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
