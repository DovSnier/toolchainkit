package com.dvsnier.base.task.handle;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvsnier.base.task.IBaseTask;
import com.dvsnier.base.task.ICycle;
import com.dvsnier.base.task.ILifeCycle;
import com.dvsnier.base.task.IRunnable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lizw on 2016/4/10.
 */
public final class HandleAdapter implements IHandle, IHandleAdapter, ICycle, ILifeCycle, IBaseTask {

    @Nullable
    protected Context context;
    @SuppressWarnings({"unchecked", "WeakerAccess", "SpellCheckingInspection"})
    protected final List<IRunnable> quequPool = new LinkedList();
    @SuppressWarnings("WeakerAccess")
    protected Handler handler;
    private int accessibility;

    public HandleAdapter() {
        handler = new Handler(Looper.getMainLooper());
    }

    public HandleAdapter(@Nullable Context context) {
        this.context = context;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onStart() {
        accessibility = LIFE_START_FLAG & CYCLE_MASK;
    }

    @Override
    public void onResume() {
        accessibility = LIFE_RESUME_FLAG & CYCLE_MASK;
        onDispatchRunnableEvents();
    }

    @Override
    public void onPause() {
        accessibility = LIFE_PAUSE_FLAG & CYCLE_MASK;
        onInterceptRunnableEvents();
    }

    @CallSuper
    @Override
    public void onStop() {
        accessibility = LIFE_STOP_FLAG & CYCLE_MASK;
    }

    @Override
    public Handler getMainHandler() {
        return handler;
    }

    @Override
    public void post(@NonNull IRunnable runnable) {
        dispatchPendingRunnableEvent(runnable, DEFAULT_TIME_STAMP);
    }

    @Override
    public void postDelayed(@NonNull IRunnable runnable, long delayMillis) {
        dispatchPendingRunnableEvent(runnable, delayMillis);
    }

    @Override
    public void stashOnRun(@NonNull IRunnable runnable) {
        dispatchPendingRunnableEvent(runnable, DEFAULT_TIME_STAMP);
    }

    @Override
    public void stashOnRun(@NonNull IRunnable runnable, long delayMillis) {
        dispatchPendingRunnableEvent(runnable, delayMillis);
    }

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

    /**
     * processing the thread task in v, p
     * <pre>
     * Notice Priority: expired > force >  delayMillis
     * </pre>
     *
     * @param runnable    the runnable that will be executed.
     * @param delayMillis the delay (in milliseconds) until the runnable will be executed.
     */
    protected final void dispatchPendingRunnableEvent(@Nullable IRunnable runnable, long delayMillis) {
        if (null != getMainHandler()) {
            //noinspection ConstantConditions
            if (null != runnable) {
                switch (accessibility & CYCLE_MASK) {
                    case LIFE_RESUME_FLAG:
                        if (!runnable.isExpired()) {
                            if (runnable.isForce()) {
                                runnable.setDelayMillis(DEFAULT_TIME_STAMP);
                                getMainHandler().post(runnable);
                            } else {
                                if (delayMillis <= 0) {
                                    runnable.setDelayMillis(DEFAULT_TIME_STAMP);
                                    getMainHandler().post(runnable);
                                } else {
                                    getMainHandler().postDelayed(runnable, delayMillis);
                                }

                            }
                            runnable.setExpired(true);
                        }
                        break;
                    case LIFE_PAUSE_FLAG:
                        if (!runnable.isExpired()) {
                            if (runnable.isForce()) {
                                runnable.setDelayMillis(DEFAULT_TIME_STAMP);
                                getMainHandler().post(runnable);
                                runnable.setExpired(true);
                            } else {
                                if (!quequPool.contains(runnable)) {
                                    runnable.setDelay();
                                    quequPool.add(runnable);
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    private void onDispatchRunnableEvents() {
        if (!quequPool.isEmpty()) {
            onDispatchAndConsumedExpiredQueue();
            Iterator<IRunnable> iterator = quequPool.iterator();
            while (iterator.hasNext()) {
                IRunnable runnable = iterator.next();
                if (runnable.isForce()) {
                    runnable.setDelayMillis(DEFAULT_TIME_STAMP);
                    getMainHandler().post(runnable);
                } else {
                    if (runnable.getDelayMillis() <= 0) {
                        runnable.setDelayMillis(DEFAULT_TIME_STAMP);
                        getMainHandler().post(runnable);
                    } else {
                        getMainHandler().postDelayed(runnable, runnable.getDelayMillis());
                    }
                }
                runnable.setExpired(true);
                iterator.remove();
            }
        }
    }

    private void onInterceptRunnableEvents() {
        if (!quequPool.isEmpty()) {
            onDispatchAndConsumedExpiredQueue();
            Iterator<IRunnable> iterator = quequPool.iterator();
            while (iterator.hasNext()) {
                IRunnable runnable = iterator.next();
                if (runnable.isForce()) {
                    runnable.setDelayMillis(DEFAULT_TIME_STAMP);
                    getMainHandler().post(runnable);
                    runnable.setExpired(true);
                    iterator.remove();
                } else {
                    runnable.setDelay();
                }
            }
        }
    }

    private void onDispatchAndConsumedExpiredQueue() {
        Iterator<IRunnable> iterator = quequPool.iterator();
        while (iterator.hasNext()) {
            IRunnable runnable = iterator.next();
            if (runnable.isExpired()) {
                iterator.remove();
            }
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
