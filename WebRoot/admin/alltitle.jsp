<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link rel="stylesheet" type="text/css"
	href="/radio/admin/css/common.css" />
<link rel="stylesheet" type="text/css" href="/radio/admin/css/main.css" />
<script type="text/javascript"
	src="/radio/admin/js/libs/modernizr.min.js"></script>
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
					<li><a class="on"
						href="/radio/admin/index.jsp">首页</a></li>
					<li><a href="/radio/index"
						target="_blank">网站首页</a></li>
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
					<li><a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
						<ul class="sub-menu">
							<li><a href="/radio/indexset.do"><i class="icon-font">&#xe008;</i>首页内容设置</a></li>
							<li><a href="/radio/jmznset.do"><i class="icon-font">&#xe005;</i>节目指南内容设置</a></li>
							<li><a href="/radio/newsset.do"><i class="icon-font">&#xe006;</i>校园圈内容设置</a></li>
							<li><a href="/radio/songset.do"><i class="icon-font">&#xe004;</i>点歌台内容设置</a></li>
							<li><a href="/radio/tyfcset.do"><i class="icon-font">&#xe012;</i>台友风采内容设置</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!--/sidebar-->
		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i>首页<span class="crumb-step">&gt;</span><span
						class="crumb-name">首页内容设置</span>
				</div>
			</div>
			<div class="result-wrap">
				<form name="myform" id="myform" method="post">
					<div class="result-title">
						<div class="result-list">
							<c:if test="${alltitle[0].type == null}">
								<a href="/radio/admin/bottominsert.jsp"><i class="icon-font"></i>新增内容</a>
							</c:if>
							<c:if test="${alltitle[0].type != null}">
								<a href="/radio/alltitleupdate1.do?type=${alltitle[0].type }"><i class="icon-font"></i>修改</a>
							</c:if>
						</div>
					</div>
					<div class="result-content">
						<table class="result-tab" width="100%">
							<c:if test="${alltitle[0].type == 1}">
								<tr><td>类型</td><td>节目指南</td></tr>
								<tr><td>标题</td><td>${alltitle[0].title }</td></tr>
								<tr><td>内容<td>${alltitle[0].content }</td></tr>
								<tr><td>有图片?<td>
									<c:if test="${alltitle[0].picture != null}">
										有
									</c:if>
									<c:if test="${alltitle[0].picture == null}">
										无
									</c:if>
								</td></tr>
							</c:if>
							<c:if test="${alltitle[0].type == 2}">
								<tr><td>类型</td><td>校园圈</td></tr>
								<tr><td>标题</td><td>${alltitle[0].title }</td></tr>
								<tr><td>内容<td>${alltitle[0].content }</td></tr>
								<tr><td>有图片?<td>
									<c:if test="${alltitle[0].picture != null}">
										有
									</c:if>
									<c:if test="${alltitle[0].picture == null}">
										无
									</c:if>
							</c:if>
							<c:if test="${alltitle[0].type == 3}">
								<tr><td>类型</td><td>点歌平台</td></tr>
								<tr><td>标题</td><td>${alltitle[0].title }</td></tr>
								<tr><td>内容<td>${alltitle[0].content }</td></tr>
								<tr><td>有图片?<td>
									<c:if test="${alltitle[0].picture != null}">
										有
									</c:if>
									<c:if test="${alltitle[0].picture == null}">
										无
									</c:if>
							</c:if>
							<c:if test="${alltitle[0].type == 4}">
								<tr><td>类型</td><td>台友风采</td></tr>
								<tr><td>标题</td><td>${alltitle[0].title }</td></tr>
								<tr><td>内容<td>${alltitle[0].content }</td></tr>
								<tr><td>有图片?<td>
									<c:if test="${alltitle[0].picture != null}">
										有
									</c:if>
									<c:if test="${alltitle[0].picture == null}">
										无
									</c:if>
							</c:if>
						</table>
					</div>
				</form>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>