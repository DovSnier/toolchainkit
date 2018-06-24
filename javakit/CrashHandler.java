
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.widget.Toast;


/**
 * <pre>
 * CrashHandler
 * </pre>
 * 
 * @author lizw
 * @version 1.0.0
 * @since jdk 1.7
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

	public static final boolean DEBUG = Constants.DEBUG; // the set debug mode
	private final String PATH_EXTERNAL_PREFIX = Constants.PathConstants.PATH_EXTERNAL_PREFIX; // the default app package name
	private static String directory = "";
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
		Thread.setDefaultUncaughtExceptionHandler(this);
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

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
			file.mkdirs();
		}
		File fileDate = new File(file, getPrintToDirectoryTime());
		if (!fileDate.exists()) {
			fileDate.mkdirs();
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
				Thread.sleep(2000);
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
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		ex.printStackTrace(printWriter);
		Throwable cause = ex.getCause();
		cause.printStackTrace(printWriter);
		printWriter.close();
		final String result = writer.toString();
		final String message = ex.getMessage();

		new Thread() {

			@Override
			public void run() {
				Looper.prepare();
				Toast.makeText(context, "程序出错啦!", Toast.LENGTH_LONG).show();
				String fileName = "crash_" + getPrintToFileTime() + ".log";
				File file = new File(directory, fileName);
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e) {
					}
				}

				try {
					FileOutputStream fos = new FileOutputStream(file, true);
					fos.write(("=>" + "date = " + DateUtils.getCurrrentTime() + "\n" + "=>msgs = " + message).getBytes());
					fos.write(result.getBytes());
					fos.flush();
					fos.close();
				} catch (Exception e) {
				}
				Looper.loop();
			}

		}.start();
		return true;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMdd_hhmm");
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
