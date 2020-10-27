package com.etc.delightstouring.utils;

import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 11:37
 * @Version 1.0
 **/
public class UUIDUtil {
    /**
     * 获取一个 UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
