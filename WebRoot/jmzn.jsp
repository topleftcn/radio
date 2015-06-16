<%@ page import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="style/style.css" media="screen"
	type="text/css" />
<title>节目指南</title>

<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
<script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>

<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider();
	});
</script>

<script type="text/javascript">
	function MM_popupMsg(msg) { //v1.0
		alert(msg);
	}

	function lmjs(n) {
		if (n == 1) {
			document.getElementById("jm_right_nr").style.display = "block";
			document.getElementById("container").style.display = "none";
		}
		if (n == 2) {
			document.getElementById("jm_right_nr").style.display = "none";
			document.getElementById("container").style.display = "block";
		}
	}

</script>

<script language="javascript">
<!--
	i = 40;
	function scroll(a) {
		if (i) {
			a1.scrollLeft += 5 * a;
			i--;
			setTimeout("scroll(" + a + ")", 10);
		} else
			i = 40;
	}
//-->
</script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.accordion.js"></script>
<script type="text/javascript" src="js/jquery.easing.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#navigation').accordion({
			autoheight : false,
			active : false,//false为都折叠，要某个不折叠，只要设置index即可
			header : '.head',//可以折叠的元素
			navigation : true,
			event : 'click',//折叠展开时的事件
			fillSpace : false,
			animated : 'bounceslide'//bounceslide,easeslide展开折叠时的动态效果，需要引入其他js文件（UI Effects Core）
		});
	});
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
								<a href="javascript:void(0)" onclick="lmjs(1)">节目表</a>

							</div>
						</li>


						<li id="jm_left_li">
							<div id="jm_left_img"></div>
							<div id="jm_left_text">
								<a href="javascript:void(0)" onclick="lmjs(2)">栏目介绍</a>
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

						<div id="jm_right_nr_nr">
							<!-- 样式无 -->
							<table>
							<c:if test="${allColumnSize-1 >= 0}">
								<c:forEach begin="0" step="1" end="${allColumnSize-1 }" var="i">
									<tr>
										<td>${allColumn[i].title }</td>
										<td>${allColumn[i].columntime }</td>
									</tr>
								</c:forEach>
							</c:if>
							</table>
						</div>
						
					</div>


					<div id="container">
						<div class="maincontent">
							<div class="box03">
								<ul id="navigation">
									<c:if test="${requestScope.allColumnSize-1>=0}">
									<c:forEach begin="0" step="1"
												end="${requestScope.allColumnSize-1}" var="i">
												<li><span class="head">${requestScope.allColumn[i].title }</span>
													<p>${requestScope.allColumn[i].content }</p></li>
											</c:forEach>
									</c:if>
											
								</ul>
							</div>
							
						</div>
					</div>

				</div>

			</div>
			<div id="clear_all"></div>
		</div>

		<div id="all_down"></div>





	</div>



	



					<!--  -->
					<div id="container">
						<div class="maincontent">
							<div class="box03">
							<c:if test="${requestScope.allColumnSize-1>=0}">
							<c:forEach begin="0" step="1"
									end="${requestScope.allColumnSize-1}" var="i">
									<ul id="navigation">

										<li><span class="head">${requestScope.allColumn[i].title }</span>
											<p>${requestScope.allColumn[i].content }</p></li>
									</ul>
								</c:forEach>
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
