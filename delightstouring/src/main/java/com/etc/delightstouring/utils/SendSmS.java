package com.etc.delightstouring.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Random;

/**
 * @ClassName SendSmS
 * @Description TODO 发送短信验证码
 * @Author Administrator
 * @Date 20/10/26 19:39
 * @Version 1.0
 **/
public class SendSmS{
    /**
     * 发送短信
     * @param randomCode 6 位随机数
     * @param phone 手机号码
     */
    public static void sendCode(String randomCode, String phone){
        // accessKeyId 和 accessSecret 在 AccessKey 在阿里云个人中心中可以查看
        String accessKeyId = "LTAI4GC9hsexGZkmsn9fw3dJ";
        String accessSecret = "XF11fWngOYstlMI7iPHbQzyARqNI4F";

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);// 接受验证法的手机号码
        request.putQueryParameter("SignName", "荧惑");
        request.putQueryParameter("TemplateCode", "SMS_205136374");
        request.putQueryParameter("TemplateParam", "{'code':"+ randomCode +"}");// 发送的验证码
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成随机六位数的验证码
     * @return
     */
    public static String getRandomCode(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 构造方法私有化
     */
    private SendSmS(){}
}
