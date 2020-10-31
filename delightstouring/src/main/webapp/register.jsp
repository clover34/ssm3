<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/28
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册</title>
    <link type="text/css" rel="stylesheet" href="css/zhuce.css" />
    <!-- 引入 jQuery 插件 -->
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<%--    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>--%>
    <!-- 引入 boostarp 插件 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css"/>
    <!-- 引入 bootstrap 框架插件 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            var height=$(document).height();
            $('.main').css('height',height);

            // 当 file 控件发生改变的时候
            $("#photo").change(function(){
                // 获取整个上传文件控件标签
                var image = $("#photo")[0];
                // image.files[0] 能获取到文件的名称，文件类型，文件大小，将此文件的对象传到 getUrl 方法
                var url = geturl(image.files[0]);
                // 判断方法返回的 ULR 是否为空
                if(url == null){
                    alert("文件异常")
                }else{
                    // 设置图片空间的 src 属性；给了一个路径
                    $("#showImage").attr("src",url);
                }
            });

            // 设置点击图片控件的时候选择文件
            $("#showImage").click(function () {
                $("#photo").click();
            })

            // 获取验证码：1，判断是否为空 2，验证手机格式是否正确 3，判断手机是否已经被注册 4，注册成功或者失败
            $("#btn").click(function(){
                var uPhone = $("#uPhone").val();
                // 1，判断是否为空
                if(uPhone == ""){
                    alert("手机号码不能为空")
                } else {
                    // 2，验证手机格式是否正确 verifyPhone
                    $.ajax({
                        url:"<%=request.getContextPath()%>/user/verifyPhone",
                        type:"post",
                        dataType:"json",
                        data:{
                            "uPhone":uPhone,
                        },
                        success:function (data) {
                            if (data) {
                                // 手机格式正确
                                phoneExists(uPhone);
                            } else {
                                // 格式正确，验证手机号码是否已被注册
                                alert("手机格式错误");
                            }
                        },
                        error:function (e) {
                            alert("ajax请求失败")
                        }
                    })
                }
            })

            // phoneExists 验证手机号码是否已经被注册
            function phoneExists(uPhone){
                $.ajax({
                    url:"<%=request.getContextPath()%>/user/phoneExists",
                    type:"post",
                    dataType:"json",
                    data:{
                        "uPhone":uPhone,
                    },
                    success:function (data) {
                        if (data) {
                            alert("手机号已被注册");
                        } else {
                            // 手机号没有被注册的时候发送短信
                            sendSmS(uPhone);
                        }
                    },
                    error:function (e) {
                        alert("ajax请求失败")
                    }
                })
            }

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
                        }
                    },
                    error:function (e) {
                        alert("ajax请求失败")
                    }
                })
            }

            // 点击注册按钮时候
            $("#registerBtn").click(function () {
                var uPhone = $('input[name="uPhone"]').val();
                var username = $('input[name="username"]').val();
                var code = $('input[name="code"]').val();
                var password = $('input[name="password"]').val();
                if (uPhone == '') {
                    alert('手机号码不能为空');
                } else if (code == '') {
                    alert('验证码不能为空');
                } else if (username == '') {
                    alert('用户名不能为空');
                } else if (password == '') {
                    alert('密码不能为空');
                }  else {
                    var formData = new FormData($("#registerDate")[0]);
                    $.ajax({
                        url:"<%=request.getContextPath()%>/user/register",
                        type:"post",
                        dataType:"json",
                        contentType: false,
                        processData: false,
                        data:formData,
                        success:function (data) {
                            if(data){
                                // 注册成功 跳转页面;
                                alert("注册成功")
                                window.location.href = "<%=request.getContextPath()%>/login.jsp?username="+username;
                            } else {
                                alert("信息注册失败")
                            }
                        },
                        error:function (e) {
                            alert("ajax请求失败")
                        }
                    })
                }
            })
        })

        // 接受一个文件的参数
        function geturl(file) {
            var url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file);
            } else if (window.URL != undefined) {
                // 根据传入的参数创建一个指向该参数对象的URL. 这个URL的生命仅存在于它被创建的这个文档里. 新的对象URL指向执行的File对象或者是Blob对象.
                // File对象,就是一个文件,比如我用input type="file"标签来上传文件,那么里面的每个文件都是一个File对象.
                url = window.URL.createObjectURL(file);
            } else
            if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file);
            }
            // 当没有进入上面的三个逻辑方法的时候 url 返回的是一个空
            return url;
        }
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
            <form id="registerDate">
                <div class="txt txt0">
                    <img id="showImage"  src="upload/1.png" class="img-circle"
                         style="height: 60px;width: 60px;cursor: pointer;margin-left: 170px; margin-top: -10px">
                    <input type="file" class="form-control-file" name="photo" id="photo" style="display: none">
                </div>
                <div class="txt txt0">
                    <span style="letter-spacing:8px;">手机号:</span>
                    <input name="uPhone" id="uPhone" type="text" class="txtphone" placeholder="请输入手机号码"/>
                </div>
                <div class="txt txt0">
                    <span style="float:left">短信验证码:</span>
                    <input name="code" id="code" type="text" placeholder="短信验证码" class="txtyzmdx"/>
                    <input id="btn" class="btn" type="button" style="width: 82px;padding: 0px;font-size: 12px;background-color: white" onclick="" value="验证码" />
                </div>
                <div class="txt txt0">
                    <span style="letter-spacing:8px;">用户名:</span>
                    <input name="username" type="text" id="username" class="txtphone" placeholder="请输入用户名"/>
                </div>
                <div class="txt txt0">
                    <span style="letter-spacing:4px;">登录密码:</span>
                    <input name="password" type="password" id="password" class="txtphone" placeholder="请输入密码"/>
                </div>
            </form>
            <div class="txt txt0">
                <a href="<%=request.getContextPath()%>/login.jsp"><span style=" float:left;color:#31acfb">已有账号</span></a>
                <div class="zhucebtn" id="registerBtn" style="width: 240px">确认注册</div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var countdown = 60;
    function settime(val) {
        if(countdown == 0) {
            val.removeAttribute("disabled");
            val.value = "重新获取";
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
