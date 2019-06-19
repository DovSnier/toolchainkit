package com.dvsnier.support.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvsnier.base.presenter.AbstractBasePresenter;
import com.dvsnier.support.view.SupportActivity;

/**
 * support compatible presenter
 * <p>
 * Created by lizw on 2016/6/19.
 */
public class SupportPresenter<T extends SupportActivity> extends AbstractBasePresenter<T> {

    public SupportPresenter() {
    }

    public SupportPresenter(@NonNull Context context) {
        super(context);
    }

    public SupportPresenter(@NonNull T view) {
        super(view);
    }

    /**
     * {@link SupportPresenter#getView()}
     *
     * @deprecated
     */
    @Nullable
    public T getActivity() {
        return view;
    }

    /**
     * {@link SupportPresenter#setView(Object)}}
     *
     * @deprecated
     */
    public void setActivity(@Nullable T view) {
        this.view = view;
    }
}
