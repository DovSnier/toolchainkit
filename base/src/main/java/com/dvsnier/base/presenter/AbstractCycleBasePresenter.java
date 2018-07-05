package com.dvsnier.base.presenter;

import com.dvsnier.base.task.IRunnable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lizw on 2016/6/15.
 */
public abstract class AbstractCycleBasePresenter<T> extends AbstractBasePresenter<T> {

    @SuppressWarnings({"unchecked", "WeakerAccess", "SpellCheckingInspection"})
    protected final List<IRunnable> quequPool = new LinkedList();

    @Override
    public void onDestroy() {
        super.onDestroy();
        //noinspection ConstantConditions
        if (null != quequPool && !quequPool.isEmpty())
            quequPool.clear();
    }
}
