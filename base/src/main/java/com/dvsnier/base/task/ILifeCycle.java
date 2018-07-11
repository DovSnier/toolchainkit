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

    /**
     * the original identification code
     */
    int CYCLE_CLEAR = 0x000000C7;
    /**
     * the status identification of the mask code
     */
    int CYCLE_MASK = 0x00000038;
    /**
     * the status identification of the onStart() method
     */
    int LIFE_START_FLAG = 0x00000010;
    /**
     * the status identification of the onResume() method
     */
    int LIFE_RESUME_FLAG = 0x00000018;
    /**
     * the status identification of the onPause() method
     */
    int LIFE_PAUSE_FLAG = 0x00000020;
    /**
     * the status identification of the onStop() method
     */
    int LIFE_STOP_FLAG = 0x00000028;

    void onStart();

    void onResume();

    void onPause();

    void onStop();
}
