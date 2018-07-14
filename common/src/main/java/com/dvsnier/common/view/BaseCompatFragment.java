package com.dvsnier.common.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.dvsnier.base.task.IRunnable;
import com.dvsnier.base.task.handle.IHandle;
import com.dvsnier.base.view.ViewWrapper;
import com.dvsnier.common.presenter.BaseCompatPresenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * basic compatible view of Fragment
 * Created by lizw on 2016/6/16.
 */
public abstract class BaseCompatFragment<T extends BaseCompatPresenter> extends Fragment implements IHandle {

    protected String TAG = this.getClass().getSimpleName();
    @Nullable
    protected T presenter;
    private ViewWrapper<T> viewWrapper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newInstances();
        viewWrapper = new ViewWrapper<>(getContext());
        viewWrapper.setPresenter(presenter);
    }

    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        if (null != viewWrapper) {
            viewWrapper.onStart();
        }
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
        if (null != viewWrapper) {
            viewWrapper.onResume();
        }
    }

    @CallSuper
    @Override
    public void onPause() {
        super.onPause();
        if (null != viewWrapper) {
            viewWrapper.onPause();
        }
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();
        if (null != viewWrapper) {
            viewWrapper.onStop();
        }
    }

    @CallSuper
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != viewWrapper) {
            viewWrapper.onDestroy();
        }
    }

    @Override
    public Handler getMainHandler() {
        if (null != viewWrapper) {
            return viewWrapper.getMainHandler();
        }
        return null;
    }

    @Override
    public void post(@NonNull IRunnable runnable) {
        if (null != viewWrapper) {
            viewWrapper.post(runnable);
        }
    }

    @Override
    public void postDelayed(@NonNull IRunnable runnable, long delayMillis) {
        if (null != viewWrapper) {
            viewWrapper.postDelayed(runnable, delayMillis);
        }
    }

    protected final void newInstances() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (null != genericSuperclass) {
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) genericSuperclass;
                //noinspection unchecked
                Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
                if (null != clazz) {
                    try {
                        presenter = clazz.newInstance();
                        if (null != presenter) {
                            //noinspection ConstantConditions
                            if (presenter instanceof BaseCompatPresenter) {
                                //noinspection unchecked
                                presenter.setView(this);
                                presenter.setContext(getContext());
                            } else {
                                // nothing to do
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (java.lang.InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // nothing to do
            }
        }
    }

    @Nullable
    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(@Nullable T presenter) {
        this.presenter = presenter;
    }
}
