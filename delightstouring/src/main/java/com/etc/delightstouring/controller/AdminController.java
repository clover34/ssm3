package com.etc.delightstouring.controller;

import com.etc.delightstouring.domain.Admin;
import com.etc.delightstouring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 14:45
 * @Version 1.0
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public boolean adminLogin(String username, String password, HttpSession session){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        Admin admin = adminService.findAdminByNameAndPwd(username, password);
        System.out.println("admin = " + admin);
        if (admin != null) {
            // 将当前登录的管理员信息存储到回话当中
            session.setAttribute("admin", admin);
            // 返回信息
            return true;
        }
        return false;
    }
}
