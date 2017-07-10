package com.liwy.server.utils;

/**
 * Created by admin on 2017/7/9.
 */
public class StringUtils {
    /**
     * return true,if string is null or ""
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        if (str == null || "".equals(str)){
            return true;
        }
        return false;
    }
}
