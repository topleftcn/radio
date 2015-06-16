<%@ page import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>广播台后台管理</title>
<link href="/radio/admin/css/admin_login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="admin_login_wrap">
		<h1>
			<b>广播台后台管理</b>
		</h1>
		<div class="adming_login_border">
			<div class="admin_input">
				<form action="/radio/login.do" method="post">
					<ul class="admin_items">
						<li><c:if test="${flag == 'true' }">
								<font color="red">您输入的帐号或密码不正确，请重新输入。</font>
							</c:if></li>
						<li> <input type="text"
							name="username" placeholder="用户名" id="user" size="40"
							class="admin_input_style" style="width:270px;"/></li>
						<li> <input type="password"
							name="password" placeholder="密码" id="pwd" size="40"
							class="admin_input_style" style="width:270px;"/></li>
						<li><input type="submit" tabindex="3" value="登陆"
							class="btn btn-primary" /></li>
					</ul>
				</form>
			</div>
		</div>
		<p class="admin_copyright">
			<b><a tabindex="5" href="/radio/index"
				target="_blank">返回首页</a> &copy; 2015 Powered by 理工文德工作室</b>
		</p>
	</div>
</body>
</html>