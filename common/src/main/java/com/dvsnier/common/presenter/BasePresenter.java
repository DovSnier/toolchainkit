package com.dvsnier.common.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvsnier.base.presenter.AbstractBasePresenter;
import com.dvsnier.common.view.BaseCompatActivity;

/**
 * basic compatible presenter
 * <p>
 * Created by lizw on 2016/6/19.
 *
 * @deprecated
 */
public class BasePresenter<T extends BaseCompatActivity> extends AbstractBasePresenter<T> {

    public BasePresenter() {
    }

    public BasePresenter(@NonNull Context context) {
        super(context);
    }

    public BasePresenter(@NonNull T view) {
        super(view);
        this.view = view;
    }

    @Nullable
    public T getActivity() {
        return view;
    }

    public void setActivity(@Nullable T view) {
        setContext(view);
        this.view = view;
    }
}
