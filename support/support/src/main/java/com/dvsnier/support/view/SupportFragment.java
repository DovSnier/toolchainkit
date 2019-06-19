package com.dvsnier.support.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.dvsnier.support.presenter.SupportFragmentPresenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * support compatible view
 * Created by lizw on 2016/6/16.
 */
public abstract class SupportFragment<T extends SupportFragmentPresenter> extends Fragment {

    protected String TAG = this.getClass().getSimpleName();
    @Nullable
    protected T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newInstances();
    }

    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        if (null != presenter) {
            presenter.onStart();
        }
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
        if (null != presenter) {
            presenter.onResume();
        }
    }

    @CallSuper
    @Override
    public void onPause() {
        super.onPause();
        if (null != presenter) {
            presenter.onPause();
        }
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();
        if (null != presenter) {
            presenter.onStop();
        }
    }

    @CallSuper
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != presenter) {
            presenter.onDestroy();
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
                            if (presenter instanceof SupportFragmentPresenter) {
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
