package com.calypso.library.utils;

import java.util.Collection;

/**
 * 集合操作工具类
 *
 */
public class CollectionUtil {

    /**
     * 判断集合是否为null或者0个元素
     *
     * @param c
     * @return
     */
    public static boolean isNullOrEmpty(Collection c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }
}
