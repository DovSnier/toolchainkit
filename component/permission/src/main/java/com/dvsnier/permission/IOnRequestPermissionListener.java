package com.dvsnier.permission;

/**
 * IOnRequestPermissionListener
 * Created by dovsnier on 2020/7/28.
 */
public interface IOnRequestPermissionListener extends IOnPermissionListener {

    /**
     * the request a permission
     *
     * @param permission                   {@link android.Manifest.permission}
     * @param onResponsePermissionListener {@see IOnResponsePermissionListener}
     */
    public void requestPermission(String permission, IOnResponsePermissionListener onResponsePermissionListener);

    /**
     * the request a set of permissions
     *
     * @param permissions                  {@link android.Manifest.permission}
     * @param onResponsePermissionListener {@see IOnResponsePermissionListener}
     */
    public void requestPermission(String[] permissions, IOnResponsePermissionListener onResponsePermissionListener);
}
