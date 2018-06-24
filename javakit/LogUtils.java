import android.util.Log;

/**
 * <pre>
 * LogUtils
 * </pre>
 * 
 * @author dovsnier
 * @version 1.0.0
 * @since jdk 1.7
 */
public class LogUtils {

	 private static boolean isDebug = true;

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param tag
	 *            the tag
	 * @param msg
	 *            the message
	 */
	public static void v(String tag, String msg) {
		if (isDebug) {
			Log.v(tag, msg);
		}
	}

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param tag
	 *            the tag
	 * @param msg
	 *            the message
	 */
	public static void i(String tag, String msg) {
		if (isDebug) {
			Log.i(tag, msg);
		}
	}

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param tag
	 *            the tag
	 * @param msg
	 *            the message
	 */
	public static void d(String tag, String msg) {
		if (isDebug) {
			Log.d(tag, msg);
		}
	}

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param tag
	 *            the tag
	 * @param msg
	 *            the message
	 */
	public static void w(String tag, String msg) {
		if (isDebug) {
			Log.w(tag, msg);
		}
	}

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param tag
	 *            the tag
	 * @param msg
	 *            the message
	 */
	public static void e(String tag, String msg) {
		if (isDebug) {
			Log.e(tag, msg);
		}
	}

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param clazz
	 *            {@link Class}
	 * @param msg
	 *            the message
	 */
	public static void v(Class<?> clazz, String msg) {
		if (isDebug) {
			Log.v(clazz.getSimpleName(), msg);
		}
	}

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param clazz
	 *            {@link Class}
	 * @param msg
	 *            the message
	 */
	public static void i(Class<?> clazz, String msg) {
		if (isDebug) {
			Log.i(clazz.getSimpleName(), msg);
		}
	}

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param clazz
	 *            {@link Class}
	 * @param msg
	 *            the message
	 */
	public static void d(Class<?> clazz, String msg) {
		if (isDebug) {
			Log.d(clazz.getSimpleName(), msg);
		}
	}

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param clazz
	 *            {@link Class}
	 * @param msg
	 *            the message
	 */
	public static void w(Class<?> clazz, String msg) {
		if (isDebug) {
			Log.w(clazz.getSimpleName(), msg);
		}
	}

	/**
	 * 
	 * <br>
	 * 2015-4-29
	 * 
	 * @version 0.0.1
	 * @param clazz
	 *            {@link Class}
	 * @param msg
	 *            the message
	 */
	public static void e(Class<?> clazz, String msg) {
		if (isDebug) {
			Log.e(clazz.getSimpleName(), msg);
		}
	}
}
