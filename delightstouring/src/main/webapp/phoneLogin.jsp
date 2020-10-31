<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/28
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>手机登录</title>
    <link type="text/css" rel="stylesheet" href="css/zhuce.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var height=$(document).height();
            $('.main').css('height',height);
            // 获取验证码，1，不为空 2，手机格式是否正确 3，正确发送短信
            $("#btn").click(function(){
                var uPhone = $("#uPhone").val();
                var btn = this;
                // 1，判断是否为空
                if(uPhone == ""){
                    alert("手机号码不能为空")
                } else {
                    // 2，验证手机号码是否正确
                    $.ajax({
                        url:"<%=request.getContextPath()%>/user/verifyPhone",
                        type:"post",
                        dataType:"json",
                        data:{
                            "uPhone":uPhone,
                        },
                        success:function (data) {
                            if (data) {
                                // 3，发送短信
                                sendSmS(uPhone);
                            } else {
                                alert("手机格式不正确");
                            }
                        },
                        error:function (e) {
                            alert("ajax请求失败")
                        }
                    })
                }
            })

            // 发送短信 ajax
            function sendSmS(uPhone){
                $.ajax({
                    url:"<%=request.getContextPath()%>/user/sendSmS",
                    type:"post",
                    dataType:"json",
                    data:{
                        "uPhone":uPhone,
                    },
                    success:function (data) {
                        if (data) {
                            settime(btn);
                        } else {
                            alert("手机格式不正确");
                        }
                    },
                    error:function (e) {
                        alert("ajax请求失败")
                    }
                })
            }


            // 点击登录按钮时
            $("#submit").click(function () {
                var uPhone = $('input[name="uPhone"]').val();
                var code = $('input[name="code"]').val();
                if (uPhone == '') {
                    alert('手机号码不能为空');
                } else if (code == '') {
                    alert('验证码不能为空');
                } else {
                    $.ajax({
                        url:"<%=request.getContextPath()%>/user/phoneLogin",
                        type:"post",
                        dataType: "json",
                        data: {
                            "uPhone":uPhone,
                            "code":code
                        },
                        success:function (data) {
                            if(data){
                                window.location.href = "https://www.baidu.com/"
                            } else {
                                alert("用户不存在或者验证码错误")
                            }
                        },
                        error:function (error) {
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
            <img src="images/zhuce-image-3.png" class="theimg"/>
            <img src="images/zhuce-image-2.png" class="secimg"/>
            <img src="images/zhuce-image-1.png" class="firimg"/>
        </div>

        <div class="main_right">
            <div class="main_r_up">
                <img src="images/user.png" />
                <div class="pp">登录</div>
            </div>
            <div class="sub"><p><a href="<%=request.getContextPath()%>/login.jsp"><span class="blue">用户名密码登录</span></a></p></div>

            <div class="txt">
                <span style="letter-spacing:10px;">手机号:</span>
                <input name="uPhone" id="uPhone" type="text" class="txtphone" placeholder="请输入手机号码"/>
            </div>
            <div class="txt">
                <span style="float:left">短信验证码:</span>
                <input name="code" id="code" type="text" placeholder="请输入短信验证码" style="margin-left: 20px" class="txtyzmdx"/>
                <input id="btn" class="btn" type="button" style="width: 82px;padding: 0px;font-size: 12px;background-color: white" onclick="" value="验证码" />
            </div>
            <div class="xiayibu" id="submit">登录 </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var countdown = 60;
    function settime(val) {
        if(countdown == 0) {
            val.removeAttribute("disabled");
            val.value = "重新获取验证码";
            countdown = 5;
            return;
        } else {
            val.setAttribute("disabled", true);
            val.value = "重新发送(" + countdown + ")";
            countdown--;
        }
        setTimeout(function() {settime(val)}, 1000)
    }
</script>
</body>
</html>

