<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/28
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/Treatment.js"></script>
    <script type="text/javascript">
        $(function () {
            var height=$(document).height();
            $('.main').css('height',height);

            $("#loginbtn").click(function () {
                var username = $('input[name="username"]').val();
                var password = $('input[name="password"]').val();
                if (username == '') {
                    alert('请输入您的账号');
                } else if (password == '') {
                    alert('请输入密码');
                }  else {
                    $.ajax({
                        url:"<%=request.getContextPath()%>/user/login",
                        type:"post",
                        dataType:"json",
                        data:{
                            "username":username,
                            "password":password
                        },
                        success:function (data) {
                            if(data){
                                window.location.href = "https://www.baidu.com/";
                            } else {
                                alert("用户名密码错误");
                            }
                        },
                        error:function (e) {
                            alert("ajax请求失败")
                        }
                    })
                }
            })

        })


    </script>
</head>

<body>
<div class="main">
    <div class="main0">
        <div class="main_left">
            <img src="<%=request.getContextPath()%>/images/login-image-3.png" class="theimg"/>
            <img src="<%=request.getContextPath()%>/images/login-image-2.png" class="secimg"/>
            <img src="<%=request.getContextPath()%>/images/login-image-1.png" class="firimg"/>
        </div>
        <div class="main_right">
            <div class="main_r_up">
                <img src="<%=request.getContextPath()%>/images/user.png" />
                <div class="pp">登录</div>
            </div>
            <div class="sub"><p>还没有账号？<a href="<%=request.getContextPath()%>/register.jsp"><span class="blue">立即注册</span></a></p></div>
            <div class="txt">
                <span style="letter-spacing:8px;">用户名:</span>
                <input name="username" id="username" value="${param.username}" type="text" class="txtphone" placeholder="请输入注册手机号或用户名"/>
            </div>
            <div class="txt">
                <span style="letter-spacing:4px;">登录密码:</span>
                <input name="password" id="password" type="password" class="txtphone" placeholder="请输入登录密码"/>
            </div>
            <p style="padding-left: 280px;margin: 20px 0 ;"><a href="<%=request.getContextPath()%>/phoneLogin.jsp"><span class="blue" style="font-size: 14px;">手机号登录</span></a></p>
            <div class="xiayibu" id="loginbtn">登录</div>
        </div>
    </div>
</div>

</body>
</html>
