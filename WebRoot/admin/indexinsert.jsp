<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link rel="stylesheet" type="text/css"
	href="/radio/admin/css/common.css" />
<link rel="stylesheet" type="text/css" href="/radio/admin/css/main.css" />
<script type="text/javascript"
	src="/radio/admin/js/libs/modernizr.min.js"></script>
<script src="/radio/admin/js/ckeditor.js"></script>
<script type="text/javascript">
      function myCheck()
      {
         for(var i=0;i<document.form1.elements.length-1;i++)
         {
          if(document.form1.elements[i].value=="")
          {
           alert("当前表单不能有空项");
           document.form1.elements[i].focus();
           return false;
          }
         }
         return true;
        
      }
    </script>
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
				<h1 class="topbar-logo none">
					<a href="index.jsp" class="navbar-brand">后台管理</a>
				</h1>
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
					<i class="icon-font"></i>首页<span class="crumb-step">&gt;</span>新增内容<span
						class="crumb-step">&gt;</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-content">
					<form action="/radio/indexinsert.do" name="form1" method="post" onSubmit="return myCheck()">
						<table class="insert-tab" width="100%">
							<tbody>
								<font color="red" size="3px"><b>*号必填</b></font>
								<tr>
									<th><font color="red" size="4px">*</font>励志英语:</th>

									<td><textarea name="english" id="c" class="ckeditor"
											col="10" row="10"></textarea></td>
								</tr>
								<tr>
									<th><font color="red" size="4px">*</font>英语对应中文:</th>
									<td><textarea name="zhongwen" id="cc" class="ckeditor"
											style="width:600px;height:100px;"></textarea></td>
								</tr>
								<tr>
									<th><font color="red" size="4px">*</font>广播台公告:</th>
									<td><textarea name="gonggao" id="ccc" class="ckeditor"
											style="width:600px;height:100px;"></textarea></td>
								</tr>
								<tr>
									<th></th>
									<td><input class="btn btn-primary btn6 mr10" value="提交"
										type="submit"> <input class="btn btn6"
										onclick="history.go(-1)" value="返回" type="button"></td>
								</tr>
								<tr>
									<td><c:if test="${flag == 'true' }">
											<font color="red">插入数据失败</font>
										</c:if></td>
								</tr>

							</tbody>
						</table>
					</form>
				</div>
			</div>

		</div>
		<!--/main-->
	</div>
</body>
</html>
