package com.dvsnier.common.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.dvsnier.base.presenter.AbstractCycleBasePresenter;
import com.dvsnier.base.task.UIRunnable;

/**
 * basic compatible presenter with life cycle control
 * <p>
 * Created by lizw on 2016/6/19.
 */
public class BaseCompatPresenter<T> extends AbstractCycleBasePresenter<T> {

    public BaseCompatPresenter() {
    }

    public BaseCompatPresenter(@NonNull Context context) {
        super(context);
    }

    public BaseCompatPresenter(@NonNull T view) {
        super(view);
    }

    public abstract class StashRunnable<T> extends UIRunnable<T> {
        @Override
        public void stashRun() {
            //noinspection ConstantConditions,unchecked
            run((T) getView());
        }
    }
}
