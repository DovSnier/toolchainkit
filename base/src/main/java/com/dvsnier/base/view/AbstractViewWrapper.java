package com.dvsnier.base.view;

import android.content.Context;
import android.support.annotation.Nullable;

/**
 * Created by lizw on 2016/6/16.
 */
public class AbstractViewWrapper<T> extends AbstractBaseView<T> {

    public AbstractViewWrapper() {
    }

    public AbstractViewWrapper(@Nullable Context context) {
        super(context);
    }
}
