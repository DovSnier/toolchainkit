package com.dvsnier.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */
public class CompatD2 {

    public static <T> T hookOfObject(@NonNull Context context, @NonNull String name, Class<T> clazz) {
        String value = D.hook(context, name);
        if (!TextUtils.isEmpty(value)) {
            return JsonUtils.json2Object(value, clazz);
        }
        return null;
    }

    public static <T> T hookOfObject(@NonNull Context context, @NonNull String path, @NonNull String fileName, Class<T> clazz) {
        String value = D.hook(context, path, fileName);
        if (!TextUtils.isEmpty(value)) {
            return JsonUtils.json2Object(value, clazz);
        }
        return null;
    }

    public static <T> List<T> hookOfList(@NonNull Context context, @NonNull String name, Class<T> clazz) {
        String value = D.hook(context, name);
        if (!TextUtils.isEmpty(value)) {
            return JsonUtils.json2List(value, clazz);
        }
        return null;
    }


    public static <T> List<T> hookOfList(@NonNull Context context, @NonNull String path, @NonNull String fileName, Class<T> clazz) {
        String value = D.hook(context, path, fileName);
        if (!TextUtils.isEmpty(value)) {
            return JsonUtils.json2List(value, clazz);
        }
        return null;
    }
}
