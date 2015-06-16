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
						class="crumb-name">台友风采内容设置</span>
				</div>
			</div>
			<div class="result-wrap">
				<form name="myform" id="myform" method="post">
					<div class="result-title">
						<div class="result-list">
							<a href="/radio/admin/tyfcinsert.jsp"><i class="icon-font"></i>新增内容</a>
						</div>
					</div>
					<div class="result-content">
						<table class="result-tab" width="100%">
							<tr>
								<th class="tc" width="5%"><input class="allChoose" name=""
									type="checkbox"></th>
								<th>ID</th>
								<th>类型</th>
								<th>标题</th>
								<th>更新时间</th>
								<th></th>
							</tr>
							<c:if test="${alltyfcSize-1>=0}">
								<c:forEach begin="0" step="1" end="${alltyfcSize-1}" var="i">
									<tr>
										<td class="tc"><input name="${alltyfc[i].id }"
											type="checkbox"></td>
										<td>${alltyfc[i].id }</td>
										<td><c:if test="${alltyfc[i].type == 0}">广播台简介</c:if> <c:if
												test="${alltyfc[i].type == 1}">成员简介</c:if></td>
										<td>${alltyfc[i].title }</td>
										<td>${alltyfc[i].inserttime }</td>
										<td><a class="link-update"
											href="/radio/deletetyfc.do?id=${alltyfc[i].id }">删除</a></td>
									</tr>

								</c:forEach>
							</c:if>

						</table>
						<div class="list-page">
							<c:if test="${pages!=1 }">
								<a href="/radio/tyfcset.do?pages=${pages-2 }">上一页</a>
							</c:if>
							&nbsp;${pages } / ${totalPages }&nbsp;
							<c:if test="${pages < totalPages }">
								<a href="/radio/tyfcset.do?pages=${pages }">下一页</a>
							</c:if>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>