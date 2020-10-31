package com.etc.delightstouring.controller;

import com.etc.delightstouring.domain.Users;
import com.etc.delightstouring.service.UsersService;
import com.etc.delightstouring.utils.SendSmS;
import com.etc.delightstouring.utils.VerifyUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.VoidType;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 20:30
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UsersService usersService;

    /**
     * 用户登录：根据用户名和密码校验用户信息
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public boolean userLogin(String username, String password, HttpSession session){
        System.out.println("\"用户登录\" = " + "用户登录");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        Users user = usersService.findUserByNameAndPwd(username, password);
        System.out.println("user = " + user);
        if (user != null) {
            // 当用户不为空时，将用户信息存储到会话当中
            session.setAttribute("user", user);
            // 响应
            System.out.println("响应true");
            return true;
        }
        System.out.println("相应false");
        return false;
    }


    /**
     * 通过手机号码进行登录
     * @param uPhone
     * @param code
     * @param session
     * @return
     */
    @RequestMapping("/phoneLogin")
    @ResponseBody
    public boolean phoneLogin(String uPhone, String code, HttpSession session){
        String aiCode = (String) session.getAttribute("code");
        Users user = usersService.findUserByPhone(uPhone);
        // 当用户存在并且验证码正确
        if (user != null && aiCode.equals(code)) {
            // 将用户的信息存储到会话当中
            session.setAttribute("user", user);
            return true;
        }
        return false;
    }

    /**
     * 验证手机号码是否正确
     * @param uPhone
     * @return
     */
    @RequestMapping("/verifyPhone")
    @ResponseBody
    public boolean verifyPhone(String uPhone){
        return VerifyUtil.verifyPhone(uPhone);
    }

    /**
     * 校验手机号码是否已存在
     * @param uPhone
     * @return
     */
    @RequestMapping("/phoneExists")
    @ResponseBody
    public boolean phoneExists(String uPhone){
        Users phone = usersService.findUserByPhone(uPhone);
        if (phone != null) {
            return true;
        }
        return false;
    }

    /**
     * 发送短信
     * @param uPhone
     * @param session
     * @return
     */
    @RequestMapping("/sendSmS")
    @ResponseBody
    public boolean getSmS(String uPhone, HttpSession session){
        String randomCode = SendSmS.getRandomCode();
        // System.out.println("存储到会话中的randomCode = " + randomCode);
        session.setAttribute("code", randomCode);
        SendSmS.sendCode(randomCode,uPhone);
        return true;
    }

    /**
     * 校验用户名是否被使用
     * @param username
     * @return
     */
    @RequestMapping("/nameExists")
    @ResponseBody
    public boolean nameExists(String username){
        if (usersService.findUserByName(username) != null) {
            return true;
        }
        return false;
    }

    /**
     * 用户注册
     * @param user
     * @param code
     * @param photo
     * @param session
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public boolean register(Users user, String code, MultipartFile photo, HttpSession session, HttpServletRequest request){
        System.out.println("======================================================");
        System.out.println("接收到的用户信息" + user);
        System.out.println("photo = " + photo);
        System.out.println("接收到的验证码" + code);
        String registerCode = (String) session.getAttribute("code");
        // 验证码正确
        if (registerCode.equals(code)) {
            // 判断文件不为空，大小不为 0
            if (photo != null && photo.getSize() > 0) {
                // 获取文件夹位置
                String realPath = request.getServletContext().getRealPath("/upload");
                // 创建一个 File 对象，用于对文件夹的操作
                File file = new File(realPath);
                // 判断文件夹是否存在，如果不存在创建一个文件夹
                if (!file.exists()) {
                    // 文件夹不存在，创建
                    file.mkdir();
                }
                // 获取上传的图片名称
                String fileName = photo.getOriginalFilename();
                File deskFile = new File(file, fileName);
                try {
                    // 将文件转移到 upload 文件夹中
                    photo.transferTo(deskFile);
                    user.setuPhotopath("/upload/"+fileName);// 将文件路径存储到数据库中
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                user.setuPhotopath("/upload/1.png");// 将文件路径存储到数据库中
            }
            boolean isOk = usersService.addUser(user);
            System.out.println("usersService.addUser(user) = " + isOk);
            if (isOk) {
                return true;
            }
        }
        return false;
    }

    // /**
    //  * @param phone
    //  * 获取手机号码并验证
    //  * @param session
    //  * @return
    //  */
    // @RequestMapping("/sendSmS")
    // @ResponseBody
    // public boolean getSmS(String phone, HttpSession session){
    //     // 验证手机号码格式是否正确
    //     if(VerifyUtil.verifyPhone(phone)){
    //         // 获取随机的 6 位数验证码
    //         String randomCode = SendSmS.getRandomCode();
    //         System.out.println("存储到会话中的randomCode = " + randomCode);
    //         // 将验证法存储到会话中
    //         session.setAttribute("code", randomCode);
    //         // 发送验证码
    //         SendSmS.sendCode(randomCode,phone);
    //         return true;
    //     }
    //     return false;
    // }
}
