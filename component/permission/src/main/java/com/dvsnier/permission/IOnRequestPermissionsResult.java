package com.dvsnier.permission;

import android.support.annotation.NonNull;

/**
 * IOnRequestPermissionsResult
 * Created by dovsnier on 2020/8/7.
 */
public interface IOnRequestPermissionsResult {

    void onRequestPermissionsResult(@NonNull String[] permissions, @NonNull boolean[] grantResult,
                                    boolean[] shouldShowRequestPermissionRationale);
}
