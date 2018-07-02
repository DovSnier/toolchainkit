package com.dvsnier.common.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.dvsnier.common.presenter.BaseFragmentPresenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * basic compatible view
 * Created by lizw on 2016/6/16.
 */
public abstract class BaseCompatFragment<T extends BaseFragmentPresenter> extends Fragment {

    protected String TAG = this.getClass().getSimpleName();
    @Nullable
    protected T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newInstances();
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
                            if (presenter instanceof BaseFragmentPresenter) {
                                //noinspection unchecked
                                presenter.setFragment(this);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != presenter) {
            presenter.onDestroy();
        }
    }
}
