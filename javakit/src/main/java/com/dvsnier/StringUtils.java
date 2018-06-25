
import java.util.Collection;
import java.util.Map;

/**
 * <pre>
 * string utils tool class
 * </pre>
 * 
 * @author lizw
 * @version 1.0.0
 * @since jdk 1.7
 */
public class StringUtils {

	/**
	 * <p>
	 * to judge whether an object is empty <br>
	 * 2014-10-23 2:41:59
	 * 
	 * @param obj
	 *            object to be tested
	 * @return true: no empty false: empty
	 */
	public static boolean isNotEmpty(Object obj) {
		return null != obj ? true : false;
	}

	/**
	 * <p>
	 * checks if a string is empty <br>
	 * 2014-10-232:46:18
	 * 
	 * @param element
	 *            the string to be tested
	 * @return true: no empty false: empty
	 */
	public static boolean isNotEmpty(String element) {
		return null != element && !"".equals(element) ? true : false;
	}

	/**
	 * <p>
	 * to judge whether a collection object is empty <br>
	 * 2014-11-18 4:53:59
	 * 
	 * @param list
	 *            the collection object
	 * @return true: no empty false: empty
	 */
	public static boolean isNotEmpty(Collection<?> list) {
		return null != list && list.size() > 0 ? true : false;
	}

	/**
	 * <p>
	 * judge a map < k, v > set whether the object is empty <br>
	 * 2014-11-18 4:53:59
	 * 
	 * @param map
	 *            the collection object
	 * @return true: no empty false: empty
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return null != map && map.size() > 0 ? true : false;
	}

}

