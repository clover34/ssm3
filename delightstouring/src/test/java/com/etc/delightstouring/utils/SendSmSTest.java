package com.etc.delightstouring.utils;

import org.junit.Test;

/**
 * @ClassName SendSmS
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/26 19:46
 * @Version 1.0
 **/
public class SendSmSTest {
    @Test
    public void testSmS(){
        String randomCode = SendSmS.getRandomCode();
        SendSmS.sendCode(randomCode, "17608994857");
    }
}
