package com.etc.delightstouring.utils;

import org.junit.Test;

/**
 * @ClassName VerifyUtilTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 21:57
 * @Version 1.0
 **/
public class VerifyUtilTest {
    @Test
    public void test(){
        System.out.println("VerifyUtil.verifyPhone(\"1760899285\") = " + VerifyUtil.verifyPhone("17608994857"));
        System.out.println("VerifyUtil.verifyPhone(\"123\") = " + VerifyUtil.verifyPhone("123"));
    }
}
