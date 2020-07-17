package com.dvsnier.support.v2.result;

/**
 * IFailureResult
 * Created by dovsnier on 2016/05/20.
 */
public interface IFailureResult extends IAbstractFailureResult<Exception> {

    void onFailure(Exception e);
}
