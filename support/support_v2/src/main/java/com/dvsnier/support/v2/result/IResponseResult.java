package com.dvsnier.support.v2.result;

import android.support.annotation.NonNull;

/**
 * IResponseResult
 * Created by dovsnier on 2016/04/31.
 */
public interface IResponseResult<T> extends IResult {

    void onResponse(int type, @NonNull T bean);
}
