<%@ page import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style/style.css" media="screen"
	type="text/css" />
<title>校园圈</title>
<script type="text/javascript">
	function MM_popupMsg(msg) { //v1.0
		alert(msg);
	
	}
</script>
</head>

<body>
	<div id="head">

		<!--头部开始-->
		<div class="headertop">
			<div class="h_left"></div>
			<div id="h_right">
				<ul id="TopMenu">

					<li><a href="#" target="_blank"></a></li>
				</ul>
			</div>

			<div class="top_logo">
				<img src="image/top_image.png" usemap="#Image1Map" id="Image1"
					border="0" />
				<map name="Image1Map" id="Image1Map">
					<area shape="rect" coords="4,5,421,76" href="index"
						onfocus="blur(this);" />
				</map>
			</div>
			<%@ include file="link.jsp" %>
			<div class="btn_right"></div>
		</div>
		<!--头部结束-->
	</div>
	</div>

	<div id="all">
		<div id="all_top">

			<div id="jm_top">
				<h3>${alltitle[0].title }</h3>
				<p>${alltitle[0].content }</p>
			</div>
			<div id="jm_null"></div>
			<div id="jm_pic"></div>

			<div id="jm_img">
				<img src="${alltitle[0].picture }"
					style="width:150px;height:150px;border-radius:100%;margin-top:25px;margin-left:25px;">

			</div>

		</div>
		<div id="all_nr">
			<div id="all_left">

				<div id="jm_left">
					<h3 id="jm_left_bt">INTRODUCE</h3>
					<ul id="jm_left_ul">
						<li id="jm_left_li">

							<div id="jm_left_img"></div>
							<div id="jm_left_text">
								<a href="/radio/frontxyqset.do" >头条新闻</a>

							</div>
						</li>

					</ul>

				</div>
			</div>

			<div id="all_right">

				<div id="jm_right">

					<div id="jm_right_bt">
						<h3 id="jm_left_bt">CONTENT</h3>
					</div>


					<div id="xyq_right_nr">

						<div id="xyq_right_nr">

							<div id="ty_bt">
								${allnews.title}
								
								<!-- 这个是文章的标题 -->
							</div>
							<center><font size="2px">${allnews.inserttime}</font></center>
							<div id="ty_nr">

								<p>
									${allnews.content}
									<!-- 这个是文章的内容 -->
								</p>

								<div id="xw_tu">
									<c:if test="${allnews.picture != null}">
										<img src="${allnews.picture }" />
									</c:if>
								</div>


							</div>


						</div>

					</div>


					<div id="try"></div>


				</div>
			</div>
			<div id="clear_all"></div>
		</div>
	</div>
	</div>
	</div>

<%@ include file="bottom.jsp" %>