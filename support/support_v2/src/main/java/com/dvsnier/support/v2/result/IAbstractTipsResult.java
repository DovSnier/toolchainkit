package com.dvsnier.support.v2.result;

import android.support.annotation.NonNull;

/**
 * IAbstractTipsResult
 * Created by dovsnier on 2016/05/23.
 */
public interface IAbstractTipsResult<T> extends IResult {

    void onTips(@NonNull T msg);
}
