<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>吉利学院广播台后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>

<%
	String loginuser = (String)session.getAttribute("username");
	if( loginuser == null)
		response.sendRedirect("/radio/admin/login.jsp");
 %>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/radio/admin/index.jsp">首页</a></li>
                <li><a href="/radio/index" target="_blank">网站首页</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="/radio/indexset.do"><i class="icon-font">&#xe008;</i>首页内容设置</a></li>
                        <li><a href="/radio/jmznset.do"><i class="icon-font">&#xe005;</i>节目指南内容设置</a></li>
                        <li><a href="/radio/newsset.do"><i class="icon-font">&#xe006;</i>校园圈内容设置</a></li>
                        <li><a href="/radio/songset.do"><i class="icon-font">&#xe004;</i>点歌台内容设置</a></li>
                        <li><a href="/radio/tyfcset.do"><i class="icon-font">&#xe012;</i>台友风采内容设置</a></li>
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>北京吉利学院广播台网站后台</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="/radio/bottom.do"><i class="icon-font">&#xe001;</i>页面底部设置</a>
                    <a href="/radio/alltitle.do?type=${1 }"><i class="icon-font">&#xe005;</i>节目指南头部设置</a>
                    <a href="/radio/alltitle.do?type=${2 }"><i class="icon-font">&#xe048;</i>校园圈头部设置</a>
                    <a href="/radio/alltitle.do?type=${3 }"><i class="icon-font">&#xe041;</i>点歌平台头部设置</a>
                    <a href="/radio/alltitle.do?type=${4 }"><i class="icon-font">&#xe01e;</i>台友风采头部设置</a>
                </div>
            </div>
        </div>      
    </div>
    <!--/main-->
</div>
</body>
</html>
