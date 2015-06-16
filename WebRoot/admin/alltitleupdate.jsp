<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="/radio/admin/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/radio/admin/css/main.css"/>
    <script type="text/javascript" src="/radio/admin/js/libs/modernizr.min.js"></script>
<script src="/radio/admin/js/ckeditor.js"></script>
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
            <h1 class="topbar-logo none"><a href="index.jsp" class="navbar-brand">后台管理</a></h1>
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
            <div class="crumb-list"><i class="icon-font"></i>首页<span class="crumb-step">&gt;</span>新增内容<span class="crumb-step">&gt;</span>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
            <form action="/radio/alltitleupdate.do" method="post" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody>
                       		<tr>
                            <th width="120"><i class="require-red"></i>分类：</th>
                            <td>
                            <input type="radio" name="type" value="1" <% if(request.getParameter("type").equals("1"))
                            	%>checked<%
                            %>
                            />节目指南
                            <input type="radio" name="type" value="2" <% if(request.getParameter("type").equals("2"))
                            	%>checked<%
                            %>/>校园圈
                            <input type="radio" name="type" value="3" <% if(request.getParameter("type").equals("3"))
                            	%>checked<%
                            %>/>点歌平台
                            <input type="radio" name="type" value="4" <% if(request.getParameter("type").equals("4"))
                            	%>checked<%
                            %>/>台友风采</td>
                        </tr>
                        	<tr>
                                <th>标题:</th>
                                <td>
                                <textarea class="ckeditor" name="title" id= "c" style="width:600px;height:30px;">
                                	<c:if test="${alltype == 1 }">
										${alltitle[0].title }
									</c:if>
									<c:if test="${alltype == 2 }">
										${alltitle[0].title }
									</c:if>
									<c:if test="${alltype == 3 }">
										${alltitle[0].title }
									</c:if>
									<c:if test="${alltype == 4 }">
										${alltitle[0].title }
									</c:if>
                                </textarea>
								</td>
                            </tr>
                            <tr>
                                <th>内容:</th>
                                <td>
								<textarea class="ckeditor" name="content" id= "cc" style="width:600px;height:100px;">
									<c:if test="${alltype == 1 }">
										${alltitle[0].content }
									</c:if>
									<c:if test="${alltype == 2 }">
										${alltitle[0].content }
									</c:if>
									<c:if test="${alltype == 3 }">
										${alltitle[0].content }
									</c:if>
									<c:if test="${alltype == 4 }">
										${alltitle[0].content }
									</c:if>
								</textarea>
								</td>
                            </tr>
                             <tr>
                                <th><i class="require-red"></i>图片：</th>
                                <td>
                                   	<input type="file" name="fileName"/>
                                </td>
                            </tr>    
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit" onclick="fa()">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
							<tr>
								<td>
									<c:if test="${flag == 'true' }">
										<font color="red">插入数据失败</font>
									</c:if>
								</td>
							</tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>
