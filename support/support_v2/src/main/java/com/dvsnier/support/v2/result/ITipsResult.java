package com.dvsnier.support.v2.result;

import android.support.annotation.NonNull;

/**
 * ITipsResult
 * Created by dovsnier on 2016/05/20.
 */
public interface ITipsResult extends IAbstractTipsResult<String> {

    void onTips(@NonNull String msg);
}
