/**
 * Filename:    JudgeUtils.java   
 * Copyright:   Copyright (c)2014  
 * Company:     DovSnier
 *
 * Create at:   2014-12-10 下午3:11:07   
 * 
 * Description:  
 * 
 *  
 * 
 * Modification History:   
 * 
 *       Date        Author      Version     Description   
 * 
 * ----------------------------------------------------------------- 
 * 
 *     2014-12-10     lzw      1.0.1      1.0.1 Version   
 * 
 */
import java.util.Collection;
import java.util.Map;

/**
 * whether custom common object types for the empty class <br>
 * 2014-12-10 下午3:11:07
 * 
 * @author lizw
 */
public class JudgeUtils {
	/**
	 * <p>
	 * 判断一个对象是否为空 <br>
	 * 2014-10-23 下午2:41:59
	 * 
	 * @param obj
	 *            要被测试的对象
	 * @return true: 不为空 false: 为空
	 */
	public static boolean isNotEmpty(Object obj) {
		return null != obj ? true : false;
	}

	/**
	 * <p>
	 * 判断一个字符串是否为空 <br>
	 * 2014-10-23 下午2:46:18
	 * 
	 * @param element
	 *            要被测试的字符串
	 * @return true: 不为空 false: 为空
	 */
	public static boolean isNotEmpty(String element) {
		return null != element && !"".equals(element) ? true : false;
	}

	/**
	 * <p>
	 * 判断一个集合对象是否为空 <br>
	 * 2014-11-18 下午4:53:59
	 * 
	 * @param list
	 *            集合对象
	 * @return true: 不为空 false: 为空
	 */
	public static boolean isNotEmpty(Collection<?> list) {
		return null != list && list.size() > 0 ? true : false;
	}

	/**
	 * <p>
	 * 判断一个Map<K,V>集合对象是否为空 <br>
	 * 2014-11-18 下午4:53:59
	 * 
	 * @param map
	 *            集合对象
	 * @return true: 不为空 false: 为空
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return null != map && map.size() > 0 ? true : false;
	}

}
