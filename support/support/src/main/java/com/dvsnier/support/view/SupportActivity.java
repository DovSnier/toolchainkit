package com.dvsnier.support.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dvsnier.support.presenter.SupportPresenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * support compatible view
 * Created by lizw on 2016/6/15.
 */
public abstract class SupportActivity<T extends SupportPresenter> extends AppCompatActivity {

    protected String TAG = this.getClass().getSimpleName();
    @Nullable
    protected T presenter;

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newInstances();
    }

    @CallSuper
    @Override
    protected void onStart() {
        super.onStart();
        if (null != presenter) {
            presenter.onStart();
        }
    }

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        if (null != presenter) {
            presenter.onResume();
        }
    }

    @CallSuper
    @Override
    protected void onPause() {
        super.onPause();
        if (null != presenter) {
            presenter.onPause();
        }
    }

    @CallSuper
    @Override
    protected void onStop() {
        super.onStop();
        if (null != presenter) {
            presenter.onStop();
        }
    }

    @CallSuper
    @Override
    protected void onDestroy() {
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
                            if (presenter instanceof SupportPresenter) {
                                //noinspection unchecked
                                presenter.setView(this);
                                presenter.setContext(this);
                            } else {
                                // nothing to do
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
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
