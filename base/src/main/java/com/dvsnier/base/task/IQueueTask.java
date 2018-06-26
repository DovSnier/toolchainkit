package com.dvsnier.base.task;

/**
 * Created by lizw on 2016/5/18.
 */
public interface IQueueTask extends IBaseTask {

    void execute(Object... args);
}
