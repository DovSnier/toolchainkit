
/**
 * <pre>
 * RuntimePolicy
 * </pre>
 * 
 * @author lizw
 * @version 1.0.0
 * @since jdk 1.7
 */
public final class RuntimePolicy {

	/**
	 * the current application is run by the debug mode <br>
	 * 2015-5-20
	 * 
	 * @version 0.0.1
	 */
	public static final boolean runDebugMode() {
		Constants.DEBUG = true;
		Constants.CONFIGURATOR = true; // release and issue
		Constants.RUNTIME_MODE = true;
		return true;
	}

	/**
	 * the current application is run by the release mode
	 */
	public static final boolean runReleaseMode() {
		Constants.DEBUG = false;
		Constants.CONFIGURATOR = false; // release and issue
		Constants.RUNTIME_MODE = false;
		return false;
	}
}
