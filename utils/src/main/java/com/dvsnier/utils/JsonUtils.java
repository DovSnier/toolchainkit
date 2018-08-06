package com.dvsnier.utils;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizw on 2017/7/5.
 */

public class JsonUtils {

    public static final int DEFAULT_VALUE = -1;
    private static Gson gson;

    static {
        gson = new GsonBuilder().disableHtmlEscaping().create();
    }

    public static <T> String object2Json(T t) {
        return gson.toJson(t);
    }

    public static <T> T json2Object(@NonNull String json, Class<T> clazz) {
        try {
            return gson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getString(@NonNull JSONObject jsonObject, @NonNull String key) {
        String value = "";
        try {
            value = jsonObject.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int getInt(@NonNull JSONObject jsonObject, @NonNull String key) {
        int value = DEFAULT_VALUE;
        try {
            value = jsonObject.getInt(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static List<String> json2List(@NonNull String jsonString, @NonNull String key) {
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;
        List<String> list = null;
        //noinspection ConstantConditions
        if (null != jsonString) {
            try {
                jsonObject = new JSONObject(jsonString);
                String newStr = jsonObject.getString(key);
                jsonArray = new JSONArray(newStr);
                list = new ArrayList<String>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.get(i).toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static <T> List<T> json2List(@NonNull String jsonString, Class<T> clazz) {
        JSONArray jsonArray = null;
        List<T> list = null;
        //noinspection ConstantConditions
        if (null != jsonString) {
            try {
                jsonArray = new JSONArray(jsonString);
                list = new ArrayList<T>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(json2Object(jsonArray.get(i).toString(), clazz));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
