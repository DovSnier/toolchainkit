package com.dvsnier.permission;

import android.content.Context;

/**
 * IOnResponseComplexPermissionListener
 * Created by dovsnier on 2020/8/9.
 */
interface IOnResponseComplexPermissionListener extends IOnResponsePermissionListener {

    void onPermissionCallback(Context context, boolean isGrant, Permission[] permissions);
}
