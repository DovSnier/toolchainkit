package com.dvsnier.base.task;

/**
 * Created by lizw on 2016/6/15.
 */
public interface ICycle {

    /**
     * the status identification of the onDestroy() method
     */
    int CYCLE_DESTROY_FLAG = 0x00000030;

    void onDestroy();
}
