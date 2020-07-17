package com.dvsnier.support.v2.result;

/**
 * IAbstractFailureResult
 * Created by dovsnier on 2016/05/20.
 */
public interface IAbstractFailureResult<T> extends IResult {

    void onFailure(T e);
}
