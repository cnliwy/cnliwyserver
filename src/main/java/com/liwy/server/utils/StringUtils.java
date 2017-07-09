package com.liwy.server.utils;

/**
 * Created by admin on 2017/7/9.
 */
public class StringUtils {
    public static boolean isNull(String str){
        if (str == null || "".equals(str)){
            return true;
        }
        return false;
    }
}
