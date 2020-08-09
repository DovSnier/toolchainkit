package com.dvsnier.permission;


import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * PermissionFragment
 * Created by dovsnier on 2020/8/9.
 */
public class PermissionFragment extends Fragment {

    protected static final String TAG = BuildConfig.APPLICATION_ID;
    protected static final int PERMISSIONS_REQUEST_CODE = 2020;
    protected IOnRequestPermissionsResult requestPermissionsResult;

    public static PermissionFragment newInstance(Context context) {
        if (null == context) {
            throw new NullPointerException("the current context is null.");
        }
        PermissionFragment permissionFragment;
        if (!(context instanceof Activity)) {
            throw new ClassCastException("the current context must be a subclass of activity.");
        }

        permissionFragment = (PermissionFragment) ((FragmentActivity) context)
                .getSupportFragmentManager()
                .findFragmentByTag(TAG);
        if (null == permissionFragment) {
            permissionFragment = new PermissionFragment();
            ((FragmentActivity) context).getSupportFragmentManager()
                    .beginTransaction()
                    .add(permissionFragment, TAG)
                    .commitAllowingStateLoss();
            ((FragmentActivity) context).getSupportFragmentManager().executePendingTransactions();
        }
        return permissionFragment;
    }

    public PermissionFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Deprecated
    protected void requestPermissions(@NonNull String[] permissions) {
        requestPermissions(permissions, PERMISSIONS_REQUEST_CODE);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void requestPermissions(@NonNull String[] permissions,
                                      IOnRequestPermissionsResult onRequestPermissionsResult) {
        setRequestPermissionsResult(onRequestPermissionsResult);
        requestPermissions(permissions, PERMISSIONS_REQUEST_CODE);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            boolean[] grantResult = new boolean[permissions.length];
            boolean[] shouldShowRequestPermissionRationale = new boolean[permissions.length];
            for (int i = 0; i < permissions.length; i++) {
                grantResult[i] = grantResults[i] == PackageManager.PERMISSION_GRANTED;
                shouldShowRequestPermissionRationale[i] = shouldShowRequestPermissionRationale(permissions[i]);
            }
            onRequestPermissionsResult(permissions, grantResult, shouldShowRequestPermissionRationale);
        }
    }

    protected void onRequestPermissionsResult(@NonNull String[] permissions, @NonNull boolean[] grantResults,
                                              boolean[] shouldShowRequestPermissionRationale) {
        if (null != getRequestPermissionsResult()) {
            getRequestPermissionsResult().onRequestPermissionsResult(permissions, grantResults,
                    shouldShowRequestPermissionRationale);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean isGranted(String permission) {
        return getActivity().checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean isRevoked(String permission) {
        return getActivity().getPackageManager().isPermissionRevokedByPolicy(permission,
                getActivity().getPackageName());
    }

    public IOnRequestPermissionsResult getRequestPermissionsResult() {
        return requestPermissionsResult;
    }

    public void setRequestPermissionsResult(IOnRequestPermissionsResult requestPermissionsResult) {
        this.requestPermissionsResult = requestPermissionsResult;
    }
}
