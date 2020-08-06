package com.dvsnier.cfg;

import android.content.Context;

/**
 * IConfigApi
 * Created by dovsnier on 2020/8/3.
 */
public interface IConfigApi extends IApi {

    /**
     * the write device sdk information
     *
     * @param context {@see Context}
     */
    void onSdkCallback(Context context);
}
