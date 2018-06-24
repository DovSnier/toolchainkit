
import java.util.Stack;

import android.app.Activity;
import android.content.Context;

/**
 * 
 * <pre>
 * AppManager
 * </pre>
 * 
 * @author lizw
 * @version 1.0.0
 * @since jdk 1.7
 */
public class AppManager {

	private static Stack<Activity> activityStack;
	private static AppManager instance;

	private AppManager() {
	}

	public static AppManager getAppManager() {
		if (instance == null) {
			instance = new AppManager();
		}
		return instance;
	}

	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	public void finishActivity() {
		Activity activity = activityStack.lastElement();
		if (activity != null) {
			activity.finish();
			activity = null;
		}
	}

	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	public void AppExit(Context context) {
		finishAllActivity();

		// try {
		// Intent intent = ((ContextWrapper) context).getBaseContext().getPackageManager().getLaunchIntentForPackage(context.getPackageName());
		// intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// context.startActivity(intent);
		// System.exit(0);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}
}