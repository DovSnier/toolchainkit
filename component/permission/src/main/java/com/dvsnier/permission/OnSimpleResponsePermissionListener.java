package com.dvsnier.permission;

import android.content.Context;

/**
 * OnSimpleResponsePermissionListener
 * Created by dovsnier on 2020/8/9.
 */
public abstract class OnSimpleResponsePermissionListener implements IOnResponseDefaultPermissionListener, IOnResponseComplexPermissionListener {

    @Override
    public void onPermissionCallback(Context context, boolean isGrant, Permission permission) {

    }

    @Override
    public void onPermissionCallback(Context context, boolean isGrant, Permission[] permissions) {

    }
}
