package com.dvsnier.base.task.handle;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvsnier.base.task.IRunnable;

import java.util.Iterator;

/**
 * Created by lizw on 2016/4/10.
 */
public final class HandleAdapter extends AbstractHandleAdapter implements IHandle, IHandleAdapter {

    public HandleAdapter() {
        super();
    }

    public HandleAdapter(@Nullable Context context) {
        super(context);
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
        onDispatchRunnableEvents();
    }

    @CallSuper
    @Override
    public void onPause() {
        super.onPause();
        onInterceptRunnableEvents();
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

    /**
     * processing the thread task in v, p
     * <pre>
     * Notice Priority: expired > force >  delayMillis
     * </pre>
     *
     * @param runnable    the runnable that will be executed.
     * @param delayMillis the delay (in milliseconds) until the runnable will be executed.
     */
    @SuppressWarnings("WeakerAccess")
    protected final void dispatchPendingRunnableEvent(@Nullable IRunnable runnable, long delayMillis) {
        if (null != getMainHandler()) {
            //noinspection ConstantConditions
            if (null != runnable) {
                switch (accessibility & CYCLE_MASK) {
                    case LIFE_START_FLAG:
                    case LIFE_RESUME_FLAG:
                        if (!runnable.isExpired()) {
                            runnable.setDelayMillis(delayMillis);
                            if (runnable.isForce()) {
                                runnable.setDelayMillis(DEFAULT_TIME_STAMP);
                                getMainHandler().post(runnable);
                            } else {
                                if (!runnable.isDelay()) {
                                    runnable.setDelayMillis(DEFAULT_TIME_STAMP);
                                    getMainHandler().post(runnable);
                                } else {
                                    getMainHandler().postDelayed(runnable, delayMillis);
                                }
                            }
                            runnable.setExpired(true);
                        }
                        break;
                    case LIFE_STOP_FLAG:
                    case LIFE_PAUSE_FLAG:
                    default:
                        if (!runnable.isExpired()) {
                            runnable.setDelayMillis(delayMillis);
                            if (runnable.isForce()) {
                                runnable.setDelayMillis(DEFAULT_TIME_STAMP);
                                getMainHandler().post(runnable);
                                runnable.setExpired(true);
                            } else {
                                if (!quequPool.contains(runnable)) {
                                    runnable.setDelay(TASK_STRATEGY);
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
                    if (!runnable.isDelay()) {
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
                    runnable.setDelay(TASK_STRATEGY);
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
}
