<%@ page import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style/style.css" media="screen"
	type="text/css" />
<title>台友风采</title>

<script type="text/javascript">
	function MM_popupMsg(msg) { //v1.0
		alert(msg);
	}
	//INTRODUCE请求响应

	function tyfc(n) {
		if (n == 1) {
			document.getElementById("ty_right_nr_nr").style.display = "none";
			document.getElementById("tyfc_mrt").style.display = "block";
		} else if (n == 2) {
			document.getElementById("ty_right_nr_nr").style.display = "block";
			document.getElementById("tyfc_mrt").style.display = "none";
		}
	}

	function MM_swapImgRestore() { //v3.0
		var i, x, a = document.MM_sr;
		for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
			x.src = x.oSrc;
	}

	function MM_preloadImages() { //v3.0
		var d = document;
		if (d.images) {
			if (!d.MM_p)
				d.MM_p = new Array();
			var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
			for (i = 0; i < a.length; i++)
				if (a[i].indexOf("#") != 0) {
					d.MM_p[j] = new Image;
					d.MM_p[j++].src = a[i];
				}
		}
	}

	function MM_findObj(n, d) { //v4.01
		var p, i, x;
		if (!d)
			d = document;
		if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
			d = parent.frames[n.substring(p + 1)].document;
			n = n.substring(0, p);
		}
		if (!(x = d[n]) && d.all)
			x = d.all[n];
		for (i = 0; !x && i < d.forms.length; i++)
			x = d.forms[i][n];
		for (i = 0; !x && d.layers && i < d.layers.length; i++)
			x = MM_findObj(n, d.layers[i].document);
		if (!x && d.getElementById)
			x = d.getElementById(n);
		return x;
	}

	function MM_swapImage() { //v3.0
		var i, j = 0, x, a = MM_swapImage.arguments;
		document.MM_sr = new Array;
		for (i = 0; i < (a.length - 2); i += 3)
			if ((x = MM_findObj(a[i])) != null) {
				document.MM_sr[j++] = x;
				if (!x.oSrc)
					x.oSrc = x.src;
				x.src = a[i + 2];
			}
	}
</script>
</head>

<body onload="MM_preloadImages('image/xiaohui.png')">
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
				<img src="${alltitle[0].picture }" style="width:150px;height:150px;border-radius:100%;margin-top:25px;margin-left:25px;" >
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
								<a href="javascript:void(0))" onclick="tyfc(1)">名人堂</a>


							</div>
						</li>
						<li id="jm_left_li">
							<div id="jm_left_img"></div>
							<div id="jm_left_text">
								<a href="javascript:void(0))" onclick="tyfc(2)">广播台简介</a>
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

					<div id="jm_right_nr">

						<div id="ty_right_nr_nr">

							<div id="ty_bt">广播台简介</div>
							<div id="ty_nr">
							<c:if test="${alltyfcSize1-1>=0}">
							<c:forEach begin="0" step="1" end="${alltyfcSize1-1}" var="i">
										${alltyfc1[i].content }
										<img src="${alltyfc1[i].picture }" style="width:618px;height:246px;margin-bottom:20px;">
								</c:forEach>
							</c:if>
								
							</div>

						</div>

						<div id="tyfc_mrt">
							<div id="tyfc_mrtjs">
							<c:if test="${alltyfcSize-1 >= 0}">
							<c:forEach begin="0" step="1" end="${alltyfcSize-1}" var="i">
									<c:if test="${i%2==0 }">
										<div id="tyfc_mrt_text">
											<img src="${alltyfc[i].picture }" />
											<h3>${alltyfc[i].title }</h3>
											<p>${alltyfc[i].content }</p>
										</div>
									</c:if>
									 <c:if test="${i%2!=0 }">
										<div id="tyfc_mrt_text2">
											<img src="${alltyfc[i].picture }" />
											<h3>${alltyfc[i].title }</h3>
											<p>${alltyfc[i].content }</p>
										</div>
									</c:if>
								</c:forEach>
							</c:if>
								
							</div>

							<div id="ty_mrt_fy">
								<!-- 样式无 -->
								<c:if test="${pages!=1 }">
									<a href="/radio/fronttyfcset.do?pages=${pages-2 }">上一页</a>
								</c:if>
								&nbsp;${pages } / ${totalPages }&nbsp;
								<c:if test="${pages < totalPages }">
									<a href="/radio/fronttyfcset.do?pages=${pages }">下一页</a>
								</c:if>
							</div>

						</div>

					</div>
				</div>

			</div>
			<div id="clear_all"></div>
		</div>

		<div id="all_down"></div>

	</div>

<%@ include file="bottom.jsp" %>