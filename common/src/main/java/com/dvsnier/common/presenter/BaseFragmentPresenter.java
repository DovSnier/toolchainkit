package com.dvsnier.common.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvsnier.base.presenter.AbstractBasePresenter;
import com.dvsnier.common.view.BaseCompatFragment;


/**
 * basic compatible fragment presenter
 * Created by lizw on 2016/6/19.
 *
 * @deprecated
 */
public class BaseFragmentPresenter<T extends BaseCompatFragment> extends AbstractBasePresenter<T> {

    public BaseFragmentPresenter() {
    }

    public BaseFragmentPresenter(@NonNull Context context) {
        super(context);
    }

    public BaseFragmentPresenter(@NonNull T fragment) {
        //noinspection ConstantConditions
        super(null != fragment ? fragment.getActivity() : null);
        this.view = fragment;
    }

    @Nullable
    public T getFragment() {
        return view;
    }

    public void setFragment(@Nullable T fragment) {
        setContext(null != fragment ? fragment.getActivity() : null);
        this.view = fragment;
    }
}
