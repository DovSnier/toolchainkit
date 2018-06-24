package com.dvsnier.utils; /**
 * Filename:    StringUtils.java
 * Copyright:   Copyright (c)2014
 * Company:     DovSnier
 * <p>
 * Create at:   2014-12-10 下午3:11:07
 * <p>
 * Description:
 * <p>
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date        Author      Version     Description
 * <p>
 * -----------------------------------------------------------------
 * <p>
 * 2014-12-10     lzw      1.0.2      1.0.2 Version
 */

import java.util.Collection;
import java.util.Map;

/**
 * whether custom common object types for the empty class <br>
 * 2014-12-10 下午3:11:07
 *
 * @author lizw
 */
public class StringUtils {

    /**
     * <p>
     * to judge whether an object is empty <br>
     * 2014-10-23 下午2:41:59
     *
     * @param obj object to be tested
     * @return true: no empty false: empty
     */
    public static boolean isNotEmpty(Object obj) {
        return null != obj ? true : false;
    }

    /**
     * <p>
     * checks if a string is empty <br>
     * 2014-10-23 下午2:46:18
     *
     * @param element the string to be tested
     * @return true: no empty false: empty
     */
    public static boolean isNotEmpty(String element) {
        return null != element && !"".equals(element.trim()) ? true : false;
    }

    /**
     * <p>
     * to judge whether a collection object is empty <br>
     * 2014-11-18 下午4:53:59
     *
     * @param list the collection object
     * @return true: no empty false: empty
     */
    public static boolean isNotEmpty(Collection<?> list) {
        return null != list && list.size() > 0 ? true : false;
    }

    /**
     * <p>
     * judge a map < k, v > set whether the object is empty <br>
     * 2014-11-18 下午4:53:59
     *
     * @param map the collection object
     * @return true: no empty false: empty
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return null != map && map.size() > 0 ? true : false;
    }
}
