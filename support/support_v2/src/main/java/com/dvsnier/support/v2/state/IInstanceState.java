package com.dvsnier.support.v2.state;

/**
 * IInstanceState
 * Created by dovsnier on 2017/2/21.
 */
public interface IInstanceState extends IState {

    void onSaveInstanceState();

    void onRestoreInstanceState();
}
