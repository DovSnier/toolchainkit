package com.dvsnier.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * ui thread tool class
 * Created by lizw on 2016/7/25.
 */
public class UiThreadUtil implements IUiThread {

    private static final UiThreadUtil INSTANCE = new UiThreadUtil();

    public static UiThreadUtil getInstance() {
        return INSTANCE;
    }

    private UiThreadUtil() {
    }

    @Override
    public boolean isUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    @Override
    public void runUiThread(@NonNull Context context, Runnable runnable) {
        //noinspection ConstantConditions
        if (null == context || null == runnable) {
            return;
        }
        if (context instanceof AppCompatActivity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (!((AppCompatActivity) context).isDestroyed()) {
                    if (isUIThread()) {
                        runnable.run();
                    } else {
                        ((AppCompatActivity) context).runOnUiThread(runnable);
                    }
                }
            } else {
                if (isUIThread()) {
                    runnable.run();
                } else {
                    ((AppCompatActivity) context).runOnUiThread(runnable);
                }
            }
        }
    }

    @Override
    public void runUiThread(@NonNull Context context, Runnable runnable, long delayMillis) {
        //noinspection ConstantConditions
        if (null == context || null == runnable || delayMillis < 0) {
            return;
        }
        if (context instanceof AppCompatActivity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (!((AppCompatActivity) context).isDestroyed()) {
                    ((AppCompatActivity) context).getWindow().getDecorView().postDelayed(runnable, delayMillis);
                }
            } else {
                ((AppCompatActivity) context).getWindow().getDecorView().postDelayed(runnable, delayMillis);
            }
        }
    }
}
