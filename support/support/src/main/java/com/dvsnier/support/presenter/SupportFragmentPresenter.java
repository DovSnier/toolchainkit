package com.dvsnier.support.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvsnier.base.presenter.AbstractBasePresenter;
import com.dvsnier.support.view.SupportFragment;


/**
 * support compatible fragment presenter
 * Created by lizw on 2016/6/19.
 */
public class SupportFragmentPresenter<T extends SupportFragment> extends AbstractBasePresenter<T> {

    public SupportFragmentPresenter() {
    }

    public SupportFragmentPresenter(@NonNull Context context) {
        super(context);
    }

    public SupportFragmentPresenter(@NonNull T view) {
        super(view);
    }

    /**
     * {@link SupportFragmentPresenter#getView()}
     *
     * @deprecated
     */
    @Nullable
    public T getFragment() {
        return view;
    }

    /**
     * {@link SupportFragmentPresenter#setView(Object)}}
     *
     * @deprecated
     */
    public void setFragment(@Nullable T fragment) {
        this.view = fragment;
    }
}
