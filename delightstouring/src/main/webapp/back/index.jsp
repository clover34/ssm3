<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/10/30
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String contextPath = request.getContextPath();
        request.setAttribute("contentPath", contextPath);
    %>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/public.css">
</head>
<body>
<div class="public-header-warrp">
    <div class="public-header">
        <div class="content">
            <div class="public-header-logo"><a href=""><i>LOGO</i><h3>美食旅游后台</h3></a></div>
            <div class="public-header-admin fr">
                <p class="admin-name">${admin.aName}管理员 您好！</p>
                <div class="public-header-fun fr">
                    <a href="" class="public-header-man">管理</a>
                    <a href="" class="pu blic-header-loginout">安全退出</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<!-- 内容展示 -->
<div class="public-ifame mt20">
    <div class="content">
        <div class="clearfix"></div>
        <!-- 左侧导航栏 -->
        <div class="public-ifame-leftnav">
            <div class="public-title-warrp">
                <div class="public-ifame-title ">
                    <a href="">首页</a>
                </div>
            </div>
            <ul class="left-nav-list">
                <!-- 景点管理 -->
                <li class="public-ifame-item">
                    <a href="javascript:;">景点管理</a>
                    <div class="ifame-item-sub">
                        <ul>
                            <li><a href="<%=request.getContextPath()%>/back/scenicspot/findAll?rId=&pId=" target="content">景点信息</a>|<a href="<%=request.getContextPath()%>/scenicspot/add.jsp" target="content">添加</a></li>
                        </ul>
                    </div>
                </li>
                <!-- 店铺管理 -->
                <li class="public-ifame-item">
                    <a href="javascript:;">店铺管理</a>
                    <div class="ifame-item-sub">
                        <ul>
                            <li><a href="#" target="content">景点信息</a>|<a href="#" target="content">添加</a></li>
                            <li><a href="#" target="content">添加景点</a>|<a href="#" target="content">添加</a></li>
                        </ul>
                    </div>
                </li>
                <!-- 加盟申请 -->
                <li class="public-ifame-item">
                    <a href="javascript:;">加盟申请</a>
                    <div class="ifame-item-sub">
                        <ul>
                            <li><a href="#" target="content">会员管理</a></li>
                            <li><a href="#" target="content">会员管理（未认证）</a></li>
                            <li><a href="#" target="content">过滤过期会员</a></li>
                            <li><a href="#" target="content">会员认证统计</a></li>
                            <li><a href="#" target="content">会员提现实名认证</a></li>
                            <li><a href="/user_vbcz.html" target="content">V币充值</a></li>
                            <li><a href="#" target="content">V币充值统计</a></li>
                            <li><a href="#" target="content">续费记录</a></li>
                            <li><a href="#" target="content">续费统计</a></li>
                            <li><a href="#" target="content">申请提现</a></li>
                            <li><a href="#" target="content">推广认证管理</a></li>
                            <li><a href="#" target="content">收支统计</a></li>
                            <li><a href="#" target="content">V币转送</a></li>
                            <li><a href="#" target="content">会员在线留言</a></li>
                            <li><a href="#" target="content">重置会员代理</a></li>
                            <li><a href="#" target="content">内容推荐</a></li>
                        </ul>
                    </div>
                </li>
                <!-- 管理员管理 -->
                <li class="public-ifame-item">
                    <a href="javascript:;">管理员管理</a>
                    <div class="ifame-item-sub">
                        <ul>
                            <li><a href="#" hhref="" target="content">文本广告列表</a></li>
                            <li><a href="#" hhref="" target="content">图片广告列表</a></li>
                            <li><a href="#" hhref="" target="content">链接广告列表</a></li>
                            <li><a href="#" hhref="" target="content">广告开通记录</a></li>
                            <li><a href="#" hhref="" target="content">广告统计</a></li>
                            <li><a href="#" hhref="" target="content">过滤过期广告</a></li>
                        </ul>
                    </div>
                </li>
                <!-- 用户管理 -->
                <li class="public-ifame-item">
                    <a href="javascript:;">用户管理</a>
                    <div class="ifame-item-sub">
                        <ul>
                            <li><a href="#" target="content">V商城列表</a>|<a href="#" target="content">添加</a></li>
                            <li><a href="#" target="content">入驻V商城申请</a></li>
                            <li><a href="#" target="content">V商城订单</a></li>
                        </ul>
                    </div>
                </li>
                <!-- 留言管理 -->
                <li class="public-ifame-item">
                    <a href="javascript:;">留言管理</a>
                    <div class="ifame-item-sub">
                        <ul>
                            <li><a href="#" target="content">品牌列表</a></li>
                            <li><a href="#" target="content">品牌模板</a></li>
                            <li><a href="#" target="content">品牌开通申请</a></li>
                            <li><a href="#" target="content">预订管理</a></li>
                        </ul>
                    </div>
                </li>
                <!-- 新闻资讯 -->
                <li class="public-ifame-item">
                    <a href="javascript:;">新闻资讯</a>
                    <div class="ifame-item-sub">
                        <ul>
                            <li><a href="#" target="content">首页轮播图管理</a></li>
                            <li><a href="#" target="content">登录页轮播图管理</a></li>
                            <li><a href="#" target="content">会员名片轮播图管理</a></li>
                            <li><a href="#" target="content">商城轮播图管理</a></li>
                            <li><a href="#" target="content">分享轮播图管理</a></li>
                        </ul>
                    </div>
                </li>
                <!-- 地区管理 -->
                <li class="public-ifame-item">
                    <a href="javascript:;">地区管理</a>
                    <div class="ifame-item-sub">
                        <ul>
                            <li><a href="#" target="content">设置SEO</a></li>
                        </ul>
                    </div>
                </li>
                <!-- 审核状态管理 -->
                <li class="public-ifame-item">
                    <a href="javascript:;">审核状态管理</a>
                    <div class="ifame-item-sub">
                        <ul>
                            <li><a href="#" target="content">管理员管理</a>|<a href="#" target="content">添加</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
        <!-- 右侧内容展示部分 -->
        <div class="public-ifame-content">
            <iframe name="content" src="main.html" frameborder="0" id="mainframe" scrolling="yes" marginheight="0" marginwidth="0" width="100%" style="height: 700px;"></iframe>
        </div>
    </div>
</div>
<script src="../js/jquery.min.js"></script>
<script>
    $().ready(function(){
        var item = $(".public-ifame-item");

        for(var i=0; i < item.length; i++){
            $(item[i]).on('click',function(){
                $(".ifame-item-sub").hide();
                if($(this.lastElementChild).css('display') == 'block'){
                    $(this.lastElementChild).hide()
                    $(".ifame-item-sub li").removeClass("active");
                }else{
                    $(this.lastElementChild).show();
                    $(".ifame-item-sub li").on('click',function(){
                        $(".ifame-item-sub li").removeClass("active");
                        $(this).addClass("active");
                    });
                }
            });
        }
    });
</script>
</body>
</html>
