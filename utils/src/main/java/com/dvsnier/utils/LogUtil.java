package com.dvsnier.utils;

import android.util.Log;

/**
 * <pre>
 * LogUtil
 * </pre>
 *
 * @author lizw
 * @version 1.0.1
 * @since jdk 1.7
 */
public class LogUtil {

    protected static final String TAG = LogUtil.class.getSimpleName();
    protected static boolean isDebug = true;
    protected final static boolean IS_DEBUG_OF_THREAD = false;

    /**
     * <br>
     * 2015-4-29
     *
     * @param tag the tag
     * @param msg the message
     * @version 0.0.1
     */
    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.v(tag, msg);
        }
    }

    /**
     * <br>
     * 2015-4-29
     *
     * @param tag the tag
     * @param msg the message
     * @version 0.0.1
     */
    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    /**
     * <br>
     * 2015-4-29
     *
     * @param tag the tag
     * @param msg the message
     * @version 0.0.1
     */
    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    /**
     * <br>
     * 2015-4-29
     *
     * @param tag the tag
     * @param msg the message
     * @version 0.0.1
     */
    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, msg);
        }
    }

    /**
     * <br>
     * 2015-4-29
     *
     * @param tag the tag
     * @param msg the message
     * @version 0.0.1
     */
    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

    /**
     * <br>
     * 2015-4-29
     *
     * @param clazz {@link Class}
     * @param msg   the message
     * @version 0.0.1
     */
    public static void v(Class<?> clazz, String msg) {
        if (isDebug) {
            Log.v(clazz.getSimpleName(), msg);
        }
    }

    /**
     * <br>
     * 2015-4-29
     *
     * @param clazz {@link Class}
     * @param msg   the message
     * @version 0.0.1
     */
    public static void i(Class<?> clazz, String msg) {
        if (isDebug) {
            Log.i(clazz.getSimpleName(), msg);
        }
    }

    /**
     * <br>
     * 2015-4-29
     *
     * @param clazz {@link Class}
     * @param msg   the message
     * @version 0.0.1
     */
    public static void d(Class<?> clazz, String msg) {
        if (isDebug) {
            Log.d(clazz.getSimpleName(), msg);
        }
    }

    /**
     * <br>
     * 2015-4-29
     *
     * @param clazz {@link Class}
     * @param msg   the message
     * @version 0.0.1
     */
    public static void w(Class<?> clazz, String msg) {
        if (isDebug) {
            Log.w(clazz.getSimpleName(), msg);
        }
    }

    /**
     * <br>
     * 2015-4-29
     *
     * @param clazz {@link Class}
     * @param msg   the message
     * @version 0.0.1
     */
    public static void e(Class<?> clazz, String msg) {
        if (isDebug) {
            Log.e(clazz.getSimpleName(), msg);
        }
    }

    /**
     * the print thread information <br>
     * 2015-4-29
     *
     * @param clazz {@link Class}
     * @param msg   the message
     * @version 0.0.1
     */
    public static void printThread(Class<?> clazz, String msg) {
        if (IS_DEBUG_OF_THREAD) {
            Log.w(clazz.getSimpleName(), "### " + msg + " -> " + " {name: " + Thread.currentThread().getName() + " , " + "id:" + Thread.currentThread().getId() + "}");
        }
    }

    /**
     * the print thread information <br>
     * 2015-4-29
     *
     * @param tag the tag
     * @param msg the message
     * @version 0.0.1
     */
    public static void printThread(String tag, String msg) {
        if (IS_DEBUG_OF_THREAD) {
            Log.w(tag, "### " + msg + " -> " + "{name: " + Thread.currentThread().getName() + " , " + "id:" + Thread.currentThread().getId() + "}");
        }
    }
}
