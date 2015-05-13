/**
 * 
 */
package com.knighteam.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.widget.Toast;

import com.knighteam.constants.Constants;

/**
 * <pre>
 * CrashHandler
 * </pre>
 * 
 * @author lizw
 * @version 1.0.0
 * @since jdk 1.7
 */
public class CrashHandler implements UncaughtExceptionHandler {

	public static final boolean DEBUG = Constants.DEBUG; // the set debug mode
	private final String PATH_EXTERNAL_PREFIX = Constants.PathConstants.PATH_EXTERNAL_PREFIX; // the default app package name
	private String directory = "";
	private Thread.UncaughtExceptionHandler mDefaultHandler;
	private Context context;
	private static CrashHandler crashHandler;

	private CrashHandler() {
	}

	/**
	 * the single instance mode<br>
	 * 2015-5-13
	 * 
	 * @version 0.0.1
	 * @return
	 */
	public static CrashHandler getInstance() {
		synchronized (CrashHandler.class) {
			if (null == crashHandler) {
				crashHandler = new CrashHandler();
			}
		}
		return crashHandler;
	}

	/**
	 * the init global default uncaught exception handler <br>
	 * 2015-5-13
	 * 
	 * @version 0.0.1
	 */
	public void init(Context context) {
		this.context = context;
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);

		makeFile(); // TODO make file or directory
	}

	/**
	 * make crash directory<br>
	 * 2015-5-13
	 * 
	 * @version 0.0.1
	 */
	private final void makeFile() {
		String appAbsolutePath = "";
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			appAbsolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + PATH_EXTERNAL_PREFIX + File.separator;
		} else {
			appAbsolutePath = context.getFilesDir().getParentFile().getPath() + File.separator;
		}
		File file = new File(appAbsolutePath, "crash");
		if (!file.exists()) {
			file.mkdir();
		}
		File fileDate = new File(file, getPrintToDirectoryTime());
		if (!fileDate.exists()) {
			fileDate.mkdir();
		}
		directory = fileDate.getAbsolutePath();
		LogUtils.i(CrashHandler.class, "the current crash path is " + directory);
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (!handleException(ex) && mDefaultHandler != null) {
			mDefaultHandler.uncaughtException(thread, ex);
		} else {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			android.os.Process.killProcess(android.os.Process.myPid());
			System.exit(10);
		}
	}

	/**
	 * the custom handle exception <br>
	 * 2015-5-13
	 * 
	 * @version 0.0.1
	 * @param ex
	 *            {@link Throwable}
	 * @return true said developers to handle the exception, is responsible for the submission for the system to deal with by default
	 */
	private boolean handleException(final Throwable ex) {
		if (ex == null) {
			return false;
		}
		final StackTraceElement[] stack = ex.getStackTrace();
		final String message = ex.getMessage();
		new Thread() {

			@Override
			public void run() {
				Looper.prepare();
				Toast.makeText(context, "程序出错啦:", Toast.LENGTH_LONG).show();
				String fileName = "crash_" + getPrintToFileTime() + ".log";
				File file = new File(directory, fileName);
				try {
					FileOutputStream fos = new FileOutputStream(file, true);
					fos.write(message.getBytes());
					for (int i = 0; i < stack.length; i++) {
						fos.write(stack.toString().getBytes());
					}
					fos.flush();
					fos.close();
				} catch (Exception e) {
				}
				Looper.loop();
			}

		}.start();
		return false;
	}

	/**
	 * 
	 * get the current system date<br>
	 * 2015-4-28
	 * 
	 * @version 0.0.1
	 * @return the current system date
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getPrintToFileTime() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMdd_hhmm_ss");
		date = sdf.format(System.currentTimeMillis());
		return date;
	}

	/**
	 * 
	 * get the current system date with month and day<br>
	 * 2015-4-28
	 * 
	 * @version 0.0.1
	 * @return the current system date
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getPrintToDirectoryTime() {
		String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		date = sdf.format(System.currentTimeMillis());
		return date;
	}

}
