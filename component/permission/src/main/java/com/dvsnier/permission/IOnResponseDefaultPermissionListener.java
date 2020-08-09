package com.dvsnier.permission;

import android.content.Context;

/**
 * IOnResponseDefaultPermissionListener
 * Created by dovsnier on 2020/8/9.
 */
interface IOnResponseDefaultPermissionListener extends IOnResponsePermissionListener {

    void onPermissionCallback(Context context, boolean isGrant, Permission permission);
}
