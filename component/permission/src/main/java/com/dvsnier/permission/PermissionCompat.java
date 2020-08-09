package com.dvsnier.permission;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

import com.dvsnier.cfg.Attribute;
import com.dvsnier.cfg.IConfigApi;

import java.util.ArrayList;
import java.util.List;

/**
 * PermissionCompat
 * Created by dovsnier on 2020/7/28.
 */
public class PermissionCompat implements IOnRequestPermissionListener, ITag, IConfigApi {

    protected Context context;
    protected PermissionFragment permissionFragment;

    protected PermissionCompat() {
    }

    public PermissionCompat(Context context) {
        setContext(context);
    }

    @Override
    public void onSdkCallback(Context context) {
        if (null != context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SDK_FILE_NAME, Context.MODE_PRIVATE);
            if (null != sharedPreferences) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (null != edit) {
                    Attribute attribute = new Attribute.Builder("permission")
                            .setBuildType(BuildConfig.BUILD_TYPE)
                            .setFirstTime(String.valueOf(System.currentTimeMillis()))
                            .setRecentlyTime(String.valueOf(System.currentTimeMillis()))
                            .setVersionName(BuildConfig.VERSION_NAME)
                            .create();
                    edit.putString(attribute.getKeyOfBuildType(), attribute.getValueOfBuildType());
                    if (TextUtils.isEmpty(sharedPreferences.getString(attribute.getKeyOfFirstTime(), ""))) {
                        edit.putString(attribute.getKeyOfFirstTime(), attribute.getValueOfFirstTime());
                    }
                    edit.putString(attribute.getKeyOfRecentlyTime(), attribute.getValueOfRecentlyTime());
                    edit.putString(attribute.getKeyOfVersionName(), attribute.getValueOfVersionName());
                    edit.apply();
                }
            }
        }
    }

    @Override
    public void requestPermission(String permission, IOnResponsePermissionListener onResponsePermissionListener) {
        requestPermission(new String[]{permission}, onResponsePermissionListener);
    }

    @Override
    public void requestPermission(String[] permissions, final IOnResponsePermissionListener onResponsePermissionListener) {
        //noinspection unchecked
        final List<Permission> listWithPermission = new ArrayList(permissions.length);
        for (String permission : permissions) {
            if (isGranted(permission)) {
                listWithPermission.add(new Permission(permission, true, shouldShowRequestPermissionRationale(permission)));
            } else if (isRevoked(permission)) {
                listWithPermission.add(new Permission(permission, false, shouldShowRequestPermissionRationale(permission)));
            } else {
                listWithPermission.add(new Permission(permission, false, shouldShowRequestPermissionRationale(permission)));
            }
        }

        List<String> listWithNoPermission = new ArrayList<>();
        for (Permission item : listWithPermission) {
            if (item.isGranted()) {
                // nothing to do
            } else {
                if (!listWithNoPermission.contains(item.getName())) {
                    listWithNoPermission.add(item.getName());
                }
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !listWithNoPermission.isEmpty()) {
            //noinspection ToArrayCallWithZeroLengthArrayArgument
            permissionFragment.requestPermissions(
                    listWithNoPermission.toArray(new String[listWithNoPermission.size()]),
                    new IOnRequestPermissionsResult() {
                        @Override
                        public void onRequestPermissionsResult(@NonNull String[] permissions,
                                                               @NonNull boolean[] grantResult,
                                                               boolean[] shouldShowRequestPermissionRationale) {
                            boolean isGrant = true;
                            for (int i = 0, length = permissions.length; i < length; i++) {
                                for (int j = 0, size = listWithPermission.size(); j < size; j++) {
                                    Permission permission = listWithPermission.get(j);
                                    if (null != permission && permission.getName().equals(permissions[i])) {
                                        isGrant &= grantResult[i];
                                        permission.setGranted(grantResult[i]);
                                        permission.setShouldShowRequestPermissionRationale(shouldShowRequestPermissionRationale[i]);
                                    }
                                }
                            }
                            if (null != onResponsePermissionListener) {
                                if (onResponsePermissionListener instanceof IOnResponseDefaultPermissionListener &&
                                        listWithPermission.size() == 1) {
                                    ((IOnResponseDefaultPermissionListener) onResponsePermissionListener).onPermissionCallback(
                                            getContext(), isGrant, listWithPermission.get(0));
                                } else if (onResponsePermissionListener instanceof IOnResponseComplexPermissionListener) {
                                    //noinspection ToArrayCallWithZeroLengthArrayArgument
                                    ((IOnResponseComplexPermissionListener) onResponsePermissionListener).onPermissionCallback(
                                            getContext(), isGrant,
                                            listWithPermission.toArray(new Permission[listWithPermission.size()]));
                                } else {
                                    // nothing to do
                                }
                            }
                        }
                    });
        } else {
            if (null != onResponsePermissionListener) {
                if (onResponsePermissionListener instanceof IOnResponseDefaultPermissionListener &&
                        listWithPermission.size() == 1) {
                    ((IOnResponseDefaultPermissionListener) onResponsePermissionListener).onPermissionCallback(
                            getContext(), true, listWithPermission.get(0));
                } else if (onResponsePermissionListener instanceof IOnResponseComplexPermissionListener) {
                    //noinspection ToArrayCallWithZeroLengthArrayArgument
                    ((IOnResponseComplexPermissionListener) onResponsePermissionListener).onPermissionCallback(
                            getContext(), true,
                            listWithPermission.toArray(new Permission[listWithPermission.size()]));
                } else {
                    // nothing to do
                }
            }
        }
    }


    /**
     * only after the marshmallow version has the dynamic runtime permission been
     * added to the android system
     */
    public boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public boolean isGranted(String permission) {
        return !isMarshmallow() || permissionFragment.isGranted(permission);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean isRevoked(String permission) {
        return isMarshmallow() && permissionFragment.isRevoked(permission);
    }

    public boolean shouldShowRequestPermissionRationale(String permission) {
        return !isMarshmallow() || permissionFragment.shouldShowRequestPermissionRationale(permission);
    }

    private void obtainSingleFragment(Context context) {
        if (null == permissionFragment) {
            permissionFragment = PermissionFragment.newInstance(context);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
        onSdkCallback(context);
        obtainSingleFragment(context);
    }

    public void onDestroy() {
        if (null != permissionFragment) {
            permissionFragment.setRequestPermissionsResult(null);
        }
        if (null != context) {
            context = null;
        }
    }
}
