package com.dvsnier.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;


/**
 * PermissionWrapper
 * Created by dovsnier on 2020/7/28.
 */
public class PermissionWrapper implements IOnRequestPermissionListener, ITag {

    protected Context context;
    protected PermissionCompat permissionCompat;

    public PermissionWrapper() {
    }

    public PermissionWrapper(Context context) {
        setContext(context);
    }

    public static PermissionWrapper newInstance(Context context) {
        return new PermissionWrapper(context);
    }

    @Override
    public void requestPermission(String permission, IOnResponsePermissionListener onResponsePermissionListener) {
        if (TextUtils.isEmpty(permission)) {
            Log.w(TAG, String.format("%s", "the current permission request is empty."));
        } else {
            if (null != permissionCompat) {
                permissionCompat.requestPermission(permission, onResponsePermissionListener);
            }
        }
    }

    @Override
    public void requestPermission(String[] permissions, IOnResponsePermissionListener onResponsePermissionListener) {
        if (permissions.length <= 0) {
            Log.w(TAG, String.format("%s", "the current permission list request is empty."));
        } else {
            if (null != permissionCompat) {
                permissionCompat.requestPermission(permissions, onResponsePermissionListener);
            }
        }
    }

    public void requestSettingDetail() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getContext().getPackageName()));
        getContext().startActivity(intent);
    }

    public void requestSettingDetail(String packageName) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + packageName));
        getContext().startActivity(intent);
    }

    public void onDestroy() {
        if (null != permissionCompat) {
            permissionCompat.onDestroy();
            permissionCompat = null;
        }
        if (null != context) {
            context = null;
        }
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
        if (null == permissionCompat) {
            permissionCompat = new PermissionCompat(context);
        }
        permissionCompat.setContext(context);
    }
}
