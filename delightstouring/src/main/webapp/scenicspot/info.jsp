<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/30
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%--
Created by IntelliJ IDEA.
back/scenicspot: Administrator
Date: 20/10/07
Time: 13:37
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>信息</title>
    <!-- 引入 jQuery 插件 -->
    <script src="<%=request.getContextPath()%>/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入 boostarp 插件 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <!-- 引入 bootstrap 框架插件 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function(){
            // 点击搜索按钮时，根据条件搜索信息
            $("#open_servlet").click(function(){
                var pId = $("#pId").val();
                var rId = $("#rId").val();
                var ssName = $("#ssName").val();
                var ssDescribe = $("#ssDescribe").val();
                // console.log("查询的省份编号" + pId);
                // console.log("查询的地区编号" + rId);
                // console.log("查询的景点名称" + ssName);
                // console.log("需要查询的描述信息" + ssDescribe);
                window.location.href =
                    "<%=request.getContextPath()%>/back/scenicspot/findAll?pId=" + pId + "&rId=" + rId + "&ssName=" + ssName + "&ssDescribe=" + ssDescribe;

            })

            // 获取相应省份的地区信息
            var findrId = <%=request.getAttribute("findrId")%>;
            var findPid = <%=request.getAttribute("findpId")%>;
            // 当省份值改变时 findRegion
            $("#pId").change(function () {
                var pId = $(this).val();
                if(pId != "0"){
                    findRegion(pId);
                } else {
                    $("#rId").text("");
                    $("#rId").append("<option value='0'>---&nbsp;地区&nbsp;---</option>");
                }
            })

            findRegion(findPid);

            // 根据省份编号查询景点信息
            function findRegion(pId) {
                // console.log("获取到的省份编号" + pId);
                var rid = $("#rId");
                rid.text("");
                rid.append("<option value='0'>---&nbsp;地区&nbsp;---</option>");
                $.ajax({
                    url:"<%=request.getContextPath()%>/back/scenicspot/findRegion",
                    type:"post",
                    dataType:"json",
                    data:{
                        "pId":pId,
                    },
                    success:function (data) {
                        // console.log(data)
                        $.each(data,function (i, region) {
                            if(findrId == region.rId){
                                rid.append("<option value='"+ region.rId +"' selected='selected'>"+ region.rName +"</option>");
                            } else {
                                rid.append("<option value='"+ region.rId +"'>"+ region.rName +"</option>");
                            }
                        })
                    },
                    error:function (e) {
                        alert("ajax请求失败")
                    }
                })
            }

            var del_ssId = "";
            // 点击删除链接
            $(".tbody_tr_td:last-child").children(":last-child").click(function () {
                var name = $(this);
                del_ssId = name.attr("target-id");
                $("#delInfo").text("确认删除\t[" + name.attr("ssName") + "]\t吗？");
            })

            var target_href = "";

            // 删除确认
            $("#affirm").click(function(){
                var target = $(".tbody_tr_td:last-child").children(":last-child");
                var href = target.attr("target-href") + del_ssId;
                console.log("需要删除的地址    "  +href)
                var ssName = target.attr("target-name");
                var ssDescribe = target.attr("target-Describe");
                var rId = target.attr("target-rId");
                var pId = target.attr("target-pId");
                var pageNum = target.attr("target-pageNum");
                target_href = "<%=request.getContextPath()%>/back/scenicspot/findAll?pId=" + pId + "&rId=" + rId + "&ssName=" + ssName + "&ssDescribe=" + ssDescribe +"&pageNum=" + pageNum;
                $.ajax({
                    url:href,
                    type:"post",
                    dataType:"json",
                    data:{
                        // "id":id
                    },
                    success:function (data) {
                        window.location.href = target_href;
                    },
                    error:function (e) {
                        alert("请求失败"+e)
                    }
                })
            })
        })
    </script>
</head>
<body>

<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title " id="exampleModalCenterTitle"><span class="badge badge-danger">删除</span></h5>
            </div>
            <div class="modal-body text-center">
                <span id="delInfo">记录删除后无法恢复确认删除吗？</span>
            </div>
            <div class="modal-footer">
                <button type="button" id="affirm" class="btn btn-primary">确认</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row" style="padding: 25px 0;">
<%--                省份--%>
                <div class="col-md-1">
                    <select class="form-control" name="pId" id="pId">
                        <option value="0">---&nbsp;省份&nbsp;---</option>
                        <c:forEach var="province" items="${provinces}">
                            <c:if test="${province.pId == findpId}">
                                <option value="${province.pId}" selected="selected">${province.pName}</option>
                            </c:if>
                            <c:if test="${province.pId != findpId}">
                                <option value="${province.pId}">${province.pName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
<%--                地区--%>
                <div class="col-md-1">
                    <select class="form-control" name="rId" id="rId">
                        <option value="0">---&nbsp;地区&nbsp;---</option>
                    </select>
                </div>
<%--                 景点名称--%>
                <div class="col-md-2">
                    <input type="text" id="ssName" value="${findssName}"  class="form-control" name="ssName" placeholder="景点名称" style="width: 200px;">
                </div>
<%--                景点描述--%>
                <div class="col-md-2">
                <input type="text" id="ssDescribe" value="${findssDescribe}"  class="form-control" name="ssDescribe" placeholder="景点描述" style="width: 200px;margin-left: -40px">
                </div>
<%--                搜索按钮--%>
                <div class="col-md-1">
                    <button type="button" id="open_servlet" class="btn btn-primary btn-md" style="width: 120px;margin-left: -80px">搜索</button>
                </div>
            </div>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th style="width:5%">编号</th>
                    <th style="width:8%">名称</th>
                    <th style="width:5%">省份</th>
                    <th style="width:5%">地区</th>
                    <th style="width:10%">地址</th>
                    <th style="width:5%">图片</th>
                    <th style="width:8%">开放时间</th>
                    <th style="width:20%">描述</th>
                    <th style="width:5%">操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <c:if test="${!empty requestScope.page.list}">
                    <c:forEach var="scenicspot" items="${requestScope.page.list}">
                        <tr>
                            <td>${scenicspot.ssId}</td>
                            <td>${scenicspot.ssName}</td>
                            <td>${scenicspot.province.pName}</td>
                            <td>${scenicspot.region.rName}</td>
                            <td>${scenicspot.ssAddress}</td>
                            <td><img src="<%=request.getContextPath()%>${scenicspot.ssPhotopath}" style="width: 60px;height: 60px"></td>
                            <td>${scenicspot.ssOpendate}</td>
                            <td>${scenicspot.ssDescribe}</td>
                                <%--                        <td><f:formatDate value="${Scenicspot.birthday}" pattern="yyyy-MM-dd"></f:formatDate></td>--%>
                            <td class="tbody_tr_td">
                                <a href="<%=request.getContextPath()%>/back/scenicspot/findById/${scenicspot.ssId}">详情</a>&emsp;
                                <a target-href="<%=request.getContextPath()%>/back/scenicspot/del/"
                                   target-id="${scenicspot.ssId}"
                                   target-name="${findssName}"
                                   target-Describe="${findssDescribe}"
                                   target-rId="${findrId}"
                                   target-pId="${findpId}"
                                   target-pageNum="${page.pageNum}"
                                   ssName="${scenicspot.ssName}"
                                   data-toggle="modal"
                                   data-target="#delModal"
                                   del="del"
                                >
                                    删除
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <c:if test="${empty requestScope.page.list}">
                <h1 style="color: #8D8D8D;width:100%;">此处还没有景点快去添加吧</h1>
            </c:if>
            <div style="width:100%;position: fixed;bottom: 100px" class="row text-center" >
                <ul class="pagination" style="margin: 0 auto">
                    <c:if test="${page.pageNum == 1}">
                        <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                        <li class="disabled"><a href="javascript:void(0)">上一页</a></li>
                    </c:if>
                    <c:if test="${page.pageNum != 1}">
<%--                        /back/scenicspot/findAll?pId=" + pId + "&rId=" + rId + "&ssName=" + ssName + "&ssDescribe=" + ssDescribe--%>
                        <li><a href="<%=request.getContextPath()%>/back/scenicspot/findAll?pageNum=1&pId=${findpId}&rId=${findrId}&ssName=${findssName}&ssDescribe=${findssDescribe}">首页</a></li>
                        <li><a href="<%=request.getContextPath()%>/back/scenicspot/findAll?pageNum=${page.prePage}&pId=${findpId}&rId=${findrId}&ssName=${findssName}&ssDescribe=${findssDescribe}">上一页</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${page.pages}" varStatus="i" >
                        <c:if test="${page.pageNum == i.index}">
                            <li class="active"><a href="<%=request.getContextPath()%>/back/scenicspot/findAll?pageNum=${i.index}&pId=${findpId}&rId=${findrId}&ssName=${findssName}&ssDescribe=${findssDescribe}">${i.index}</a></li>
                        </c:if>
                        <c:if test="${page.pageNum != i.index}">
                            <li><a href="<%=request.getContextPath()%>/back/scenicspot/findAll?pageNum=${i.index}&pId=${findpId}&rId=${findrId}&ssName=${findssName}&ssDescribe=${findssDescribe}">${i.index}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${page.pageNum == page.pages}">
                        <li class="disabled"><a href="javascript:void(0)">下一页</a></li>
                        <li class="disabled"><a href="javascript:void(0)">尾页</a></li>
                    </c:if>
                    <c:if test="${page.pageNum != page.pages}">
                        <li><a href="<%=request.getContextPath()%>/back/scenicspot/findAll?pageNum=${page.nextPage}&pId=${findpId}&rId=${findrId}&ssName=${findssName}&ssDescribe=${findssDescribe}">下一页</a></li>
                        <li><a href="<%=request.getContextPath()%>/back/scenicspot/findAll?pageNum=${page.pages}&pId=${findpId}&rId=${findrId}&ssName=${findssName}&ssDescribe=${findssDescribe}">尾页</a></li>
                    </c:if>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">页数：${page.pageNum}/${page.pages}</li>
                    <li style="height: 32px;line-height: 32px;padding-left: 10px;">记录数：${page.total}条</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>

