<%@ page import="java.util.List" %>
<%@ page import="java.lang.ref.ReferenceQueue" %>
<%@ page import="org.springframework.web.context.request.RequestScope" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/07
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
    <!-- 引入 jQuery 插件 -->
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入 boostarp 插件 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css"/>
    <!-- 引入 bootstrap 框架插件 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function(){
            // 设置点击图片控件的时候选择文件
            $("#showImage").click(function () {
                $("#photo").click();
            })
            // 当 file 控件发生改变的时候
            $("#photo").change(function(){
                // 获取整个上传文件控件标签
                var image = $("#photo")[0];
                // image.files[0] 能获取到文件的名称，文件类型，文件大小，将此文件的对象传到 getUrl 方法
                var url = getUrl(image.files[0]);
                // 判断方法返回的 ULR 是否为空
                if(url == null){
                    alert("文件异常")
                }else{
                    // 设置图片空间的 src 属性；给了一个路径
                    $("#showImage").attr("src",url);
                }
            });
            // 接受一个文件的参数
            function getUrl(file) {
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

            $("#pId").focus(function () {
                // ajax 请求查询省份信息
                $.ajax({
                    url:"<%=request.getContextPath()%>/back/scenicspot/findProvinces",
                    type:"post",
                    dataType: "json",
                    data:{},
                    success:function (data) {
                        var pIdTag = $("#pId");
                        pIdTag.text("");
                        var strHead = "<option value='0'>---&nbsp;请选择&nbsp;---</option>";
                        pIdTag.append(strHead);
                        $.each(data,function (i,province) {
                            var str = "<option value='"+ province.pId +"'>"+ province.pName +"</option>";
                            pIdTag.append(str);
                        })
                    },
                    error:function (e) {
                        alert(e)
                    }
                })
            })


            // 当省份标签发生改变的时候
            $("#pId").change(function () {
                var pIdVal = $(this).val();
                var rIdTag = $("#rId");
                rIdTag.text("");
                rIdTag.append("<option value='0'>---&nbsp;请选择&nbsp;---</option>");
                if(pIdVal != 0){
                    $.ajax({
                        url:"<%=request.getContextPath()%>/back/scenicspot/findRegion",
                        type:"post",
                        dataType:"json",
                        data:{
                            "pId":pIdVal,
                        },
                        success:function (data) {
                            $.each(data,function (i,region) {
                                rIdTag.append("<option value='"+ region.rId +"'>"+ region.rName +"</option>")
                            })
                        },
                        error:function (e) {
                            alert(e)
                        }

                    })
                } else {
                    rIdTag.text("")
                    rIdTag.append("<option value='0'>---&nbsp;请选择&nbsp;---</option>");
                }
            })

            // 提交按钮被点击的时候
            $("#submitBtn").click(function(){
                // ajax 提交数据
                sumbitData();
            })
            function sumbitData(){
                // 获取 id = add 的表单数据
                var formData = new FormData(document.getElementById("add"));
                $.ajax({
                    url:"<%=request.getContextPath()%>/back/scenicspot/updateById",
                    type:"post",
                    data:formData,
                    dataType:"json",
                    contentType: false,// 让 jq 不要处理请求头
                    processData: false,// 让 jq 不要处理请求数据
                    success: function(data){
                        alert(data ? "修改成功" : "修改失败");
                        location.href = "<%=request.getContextPath()%>/back/scenicspot/findAll?pId=&rId=";
                    },
                    error : function (e) {
                        alert(e);
                    }
                })
            }
        })
    </script>
</head>
<body>
<div class="container" style="margin-top: 10px">
    <div class="row clearfix">
        <div class="col-md-4 column col-md-offset-4">
            <form role="form" id="add">
<%--                景点编号--%>
                <div class="form-group">
                    <label for="ssId">景点编号&nbsp;<span style="color: red">*</span></label>
                    <input type="text" class="form-control" name="ssId" id="ssId" value="${scenicspot.ssId}" readonly/>
                </div>
                <%--                景点名称--%>
                <div class="form-group">
                    <label for="ssName">景点名称&nbsp;<span style="color: red">*</span></label>
                    <input type="text" class="form-control" name="ssName" value="${scenicspot.ssName}" id="ssName" placeholder="景点名称"/>
                </div>
                <%--                    省份信息--%>
                <div class="form-group">
                    <label for="pId">省份&nbsp;<span style="color: red">*</span></label>
                    <select class="form-control" name="pId" id="pId">
                        <option value="${scenicspot.pId}">${scenicspot.province.pName}</option>
                    </select>
                </div>
                <%--                 地区信息--%>
                <div class="form-group">
                    <label for="rId">地区&nbsp;<span style="color: red">*</span></label>
                    <select class="form-control" name="rId" id="rId">
                        <option value="${scenicspot.rId}">${scenicspot.region.rName}</option>
                    </select>
                </div>
                <%--                景点图片--%>
                <div class="form-group text-center">
                    <label for="ssName">景点图片&nbsp;<span style="color: red">*</span></label>
                    <img id="showImage"  src="<%=request.getContextPath()%>${scenicspot.ssPhotopath}" class="img-rounded"  style="height: 60px;width: 290px;cursor: pointer">
                    <input type="file" class="form-control-file" value="<%=request.getContextPath()%>${scenicspot.ssPhotopath}" name="photo" id="photo" style="display: none">
                </div>
                <%--                景点描述--%>
                <div class="form-group">
                    <label for="ssDescribe">景点描述：&nbsp;<span style="color: red">*</span></label>
                    <textarea class="form-control" name="ssDescribe" id="ssDescribe" placeholder="景点描述">${scenicspot.ssDescribe}</textarea>
                </div>
                <%--                详细地址--%>
                <div class="form-group">
                    <label for="ssAddress">详细地址&nbsp;<span style="color: red">*</span></label>
                    <input type="text" class="form-control" value="${scenicspot.ssAddress}" name="ssAddress" id="ssAddress" placeholder="详细地址"/>
                </div>
                <%--                开放时间--%>
                <div class="form-group">
                    <label for="ssOpendate">开放时间&nbsp;<span style="color: red">*</span></label>
                    <input type="text" class="form-control" value="${scenicspot.ssOpendate}" name="ssOpendate" id="ssOpendate" placeholder="开放时间"/>
                </div>
                <span id="info"></span>
                <%--    提交按钮--%>
                <div class="form-group">
                    <button type="button" id="submitBtn" class="btn btn-primary col-md-12" style="margin-top: 10px">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
