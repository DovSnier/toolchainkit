package com.dvsnier.base.view;

import android.content.Context;
import android.support.annotation.Nullable;

/**
 * Created by lizw on 2016/6/16.
 */
public class ViewWrapper<T> extends AbstractCycleBaseView<T> {

    public ViewWrapper() {
    }

    public ViewWrapper(@Nullable Context context) {
        super(context);
    }
}
