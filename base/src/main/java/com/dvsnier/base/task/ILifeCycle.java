package com.dvsnier.base.task;

/**
 * view lifecycle
 * <pre>
 * The life cycle is divided into:
 *  1. visual range area {onStart() -> onStop()};
 *  2. operable range area {onResume() -> onPause()};</pre>
 * Created by lizw on 2016/6/5.
 */
public interface ILifeCycle {

    void onStart();

    void onResume();

    void onPause();

    void onStop();
}
