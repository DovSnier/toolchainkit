package com.dvsnier.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Created by Administrator on 2016/11/7.
 */
public class D {

    public static final String DEFAULT_SUFFIX = ".json";

    public static String hook(@NonNull Context context, @NonNull String name) {
        return MockServer.getInstance().obtainDefaultMock(context, name);
    }


    public static String hook(@NonNull Context context, @NonNull String path, @NonNull String fileName) {
        return MockServer.getInstance().obtainMockFile(context, path, fileName);
    }

    public static String hookOfCompat(@NonNull Context context, @NonNull String name) {
        if (TextUtils.isEmpty(name)) {
            return name;
        } else {
            if (!name.contains(DEFAULT_SUFFIX)) {
                name += DEFAULT_SUFFIX;
            }
        }
        return hook(context, name);
    }

    public static String hookOfCompat(@NonNull Context context, @NonNull String path, @NonNull String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return fileName;
        } else {
            if (!fileName.contains(DEFAULT_SUFFIX)) {
                fileName += DEFAULT_SUFFIX;
            }
        }
        return MockServer.getInstance().obtainMockFile(context, path, fileName);
    }
}
