package com.dvsnier.base.task;

/**
 * the ui runnable used in the view
 * Created by lizw on 2016/6/15.
 */
public abstract class UIRunnable extends AbstractUIRunnable {

    @Override
    public void stashRun() {
        uiRun();
    }

    public abstract void uiRun();
}
