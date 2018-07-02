package com.dvsnier.common.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvsnier.base.presenter.AbstractBasePresenter;
import com.dvsnier.common.view.BaseCompatFragment;


/**
 * basic compatible fragment presenter
 * Created by lizw on 2016/6/19.
 */
public class BaseFragmentPresenter<T extends BaseCompatFragment> extends AbstractBasePresenter<T> {

    @Nullable
    protected T fragment;

    public BaseFragmentPresenter() {
    }

    public BaseFragmentPresenter(@NonNull T fragment) {
        //noinspection ConstantConditions
        super(null != fragment ? fragment.getActivity() : null);
        this.fragment = fragment;
    }

    @Nullable
    public T getFragment() {
        return fragment;
    }

    public void setFragment(@Nullable T fragment) {
        this.fragment = fragment;
    }
}
