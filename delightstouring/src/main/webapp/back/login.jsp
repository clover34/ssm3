<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/28
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>登录界面</title>
    <link href="<%=request.getContextPath()%>/css/default.css" rel="stylesheet" type="text/css" />
    <!--必要样式-->
    <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/css/loaders.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class='login'>
    <div class='login_title'>
        <span>管理员登录</span>
    </div>
    <div class='login_fields'>
        <div class='login_fields__user'>
            <div class='icon'>
                <img alt="" src='<%=request.getContextPath()%>/img/user_icon_copy.png'>
            </div>
            <!-- 用户名 -->
            <input name="username" id="username" placeholder='用户名' maxlength="16" type='text' autocomplete="off"/>
            <div class='validation'>
                <img alt="" src='../img/tick.png'>
            </div>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img alt="" src='<%=request.getContextPath()%>/img/lock_icon_copy.png'>
            </div>
            <!-- 密码 -->
            <input name="password" id="password" placeholder='密码' maxlength="16" type='text' autocomplete="off">
            <div class='validation'>
                <img alt="" src='../img/tick.png'>
            </div>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img alt="" src='<%=request.getContextPath()%>/img/key.png'>
            </div>
            <input name="code" placeholder='验证码' maxlength="4" type='text' name="ValidateNum" autocomplete="off">
            <div class='validation' style="opacity: 1; right: -5px;top: -3px;">
                <canvas class="J_codeimg" id="myCanvas" onclick="Code();">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
            </div>
        </div>
        <div class='login_fields__submit'>
            <input type='button' value='登录'>
        </div>
    </div>
    <div class='success'>
    </div>
    <div class='disclaimer'>
        <p>欢迎登录后台管理系统</p>
    </div>
</div>
<div class='authent'>
    <div class="loader" style="height: 44px;width: 44px;margin-left: 28px;">
        <div class="loader-inner ball-clip-rotate-multiple">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>
    <p>认证中...</p>
</div>
<div class="OverWindows"></div>
<link href="<%=request.getContextPath()%>/layui/css/layui.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/js/stopExecutionOnTimeout.js?t=1'></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/layui/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Particleground.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Treatment.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.mockjax.js"></script>
<script type="text/javascript">
    var canGetCookie = 0;//是否支持存储Cookie 0 不支持 1 支持

    var CodeVal = 0;
    Code();
    function Code() {
        if(canGetCookie == 1){
            createCode("AdminCode");
            var AdminCode = getCookieValue("AdminCode");
            showCheck(AdminCode);
        }else{
            showCheck(createCode(""));
        }
    }
    function showCheck(a) {
        CodeVal = a;
        var c = document.getElementById("myCanvas");
        var ctx = c.getContext("2d");
        ctx.clearRect(0, 0, 1000, 1000);
        ctx.font = "80px 'Hiragino Sans GB'";
        ctx.fillStyle = "#E8DFE8";
        ctx.fillText(a, 0, 100);
    }
    $(document).keypress(function (e) {
        // 回车键事件
        if (e.which == 13) {
            $('input[type="button"]').click();
        }
    });
    //粒子背景特效
    $('body').particleground({
        dotColor: '#E8DFE8',
        lineColor: '#133b88'
    });
    $('input[name="password"]').focus(function () {
        $(this).attr('type', 'password');
    });
    $('input[type="text"]').focus(function () {
        $(this).prev().animate({ 'opacity': '1' }, 200);
    });
    $('input[type="text"],input[type="password"]').blur(function () {
        $(this).prev().animate({ 'opacity': '.5' }, 200);
    });
    $('input[name="username"],input[name="password"]').keyup(function () {
        var Len = $(this).val().length;
        if (!$(this).val() == '' && Len >= 5) {
            $(this).next().animate({
                'opacity': '1',
                'right': '30'
            }, 200);
        } else {
            $(this).next().animate({
                'opacity': '0',
                'right': '20'
            }, 200);
        }
    });
    var open = 0;
    layui.use('layer', function () {
        //非空验证
        $('input[type="button"]').click(function () {
            var username = $('input[name="username"]').val();
            var password = $('input[name="password"]').val();
            var code = $('input[name="code"]').val();
            if (username == '') {
                ErroAlert('请输入您的账号');
            } else if (password == '') {
                ErroAlert('请输入密码');
            } else if (code == '' || code.length != 4) {
                ErroAlert('输入验证码');
            } else {
                if(code.toUpperCase() == CodeVal.toUpperCase()){
                    $.ajax({
                        url:"<%=request.getContextPath()%>/admin/login",
                        type:"post",
                        dataType:"json",
                        // contentType: false,
                        // processData: false,
                        data:{
                            username:username,
                            password:password
                        },
                        success:function(data){
                            if(data){
                                window.location.href = "<%=request.getContextPath()%>/back/index.jsp";
                            } else {
                                ErroAlert("用户名密码错误");
                            }
                        },
                        error:function(e){
                            alert("ajax请求失败" + e.message);
                        }
                    })
                }else{
                    ErroAlert("验证码错误")
                }
            }
        })
    })
</script>

</body>
</html>
