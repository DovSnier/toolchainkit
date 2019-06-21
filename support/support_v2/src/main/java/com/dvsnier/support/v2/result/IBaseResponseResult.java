package com.dvsnier.support.v2.result;

import android.support.annotation.NonNull;

/**
 * IBaseResponseResult
 * Created by dovsnier on 2016/04/31.
 *
 * @deprecated
 */
public interface IBaseResponseResult<T> extends IResult {

    void onResponse(@NonNull T bean);
}
