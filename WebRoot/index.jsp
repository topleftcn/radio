<%@ page import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style/style.css" media="screen"
	type="text/css" />

<title>北京吉利学院广播台</title>


<script type="text/javascript">
	function MM_preloadImages() { //v3.0
		var d = documeEmnt;
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
	function MM_popupMsg(msg) { //v1.0
		alert(msg);
	}
</script>


<!--点歌台滚动-->
<script type="text/javascript">
	window.onload = function() {
		setTimeout("startmarquee(34, 50, 0, 'marquee')", 1000);
	}
	function startmarquee(lh, speed, delay, id) {

		var t;
		var p = false;
		var o = document.getElementById(id);
		o.innerHTML += o.innerHTML + o.innerHTML + o.innerHTML;
		o.onmouseover = function() {
			p = true;
		}
		o.onmouseout = function() {
			p = false;
		}
		o.scrollTop = 0;

		function start() {
			t = setInterval(scrolling, speed);
			if (!p)
				o.scrollTop += 2;
		}

		function scrolling() {
			if (o.scrollTop % lh != 0) {
				o.scrollTop += 2;
				if (o.scrollTop >= o.scrollHeight / 2)
					o.scrollTop = 0;
			} else {
				clearInterval(t);
				setTimeout(start, delay);
			}
		}
		setTimeout(start, delay);
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
	<div id="neirong">
		<div id="nr_shang">
			<div id="gonggao">
				<div id="g_bt">
					<h2>
						广播台公告
						<hr color="21b7c6">
					</h2>
				</div>
				<div id="g_nr">
					<!-- 公告 -->
					<ul id="gonggao_ul">
						<c:forEach begin="0" step="1" end="2" var="i">
						<c:if test="${allIndex[i].gonggao !=null}">
						<li id="gonggao_li">
								<div id="gonggao_img"></div>
								<div id="gonggao_text">
									<h4 id="g_text">公告${i+1 }</h4>
									<div id="g_text_text">
										<a href="#">${allIndex[i].gonggao }</a>
									</div>
									<time>${allIndex[i].inserttime }</time>
								</div>
							</li>
						</c:if>
						<c:if test="${allIndex[i].gonggao ==null}">
						<li id="gonggao_li">
								<div id="gonggao_img"></div>
								<div id="gonggao_text">
									<h4 id="g_text">公告${i+1 }</h4>
									<div id="g_text_text">
										<a href="#">${allIndex[i-1].gonggao }</a>
									</div>
									<time>${allIndex[i-1].inserttime }</time>
								</div>
							</li>
						</c:if>
						</c:forEach>
					</ul>
				</div>

			</div>
			<div id="img_show">
				<!--我是焦点图-->

				<div id="slider" class="nivoSlider">

					<a href="/radio/newsprint.do?id=${allNew[0].id }" target="_blank"><img
						src="${allNew[0].picture }" alt="" title="${allNew[0].title }"
						width="618px" height="246px" /></a> <a
						href="/radio/newsprint.do?id=${allNew[1].id }" target="_blank"><img
						src="${allNew[1].picture }" alt="" title="${allNew[1].title }"
						width="618px" height="246px" /></a> <a
						href="/radio/newsprint.do?id=${allNew[2].id }" target="_blank"><img
						src="${allNew[2].picture }" alt="" title="${allNew[2].title }"
						width="618px" height="246px" /></a> <a
						href="/radio/newsprint.do?id=${allNew[3].id }" target="_blank"><img
						src="${allNew[3].picture }" alt="" title="${allNew[3].title }"
						width="618px" height="246px" /></a>

				</div>
			</div>



		</div>
		<div id="nr_xia">
			<div id="xiaoyuan_rili">

				<div id="xiaoyuanquan">
					<div id="dg_bt">
						<h2>
							校园圈
							<hr color="21b7c6" width="580px">
						</h2>
					</div>

					<!-- 校园新闻 -->
					<ul>
					<c:forEach var="i" begin="0" end="5" step="1">
								
						<!-- 样式要修改 -->
						<li>
							<div id="xw_bt">
							<img src="image/xyq_xw.png" width="13" height="15" />
								<c:if test="${allNew[0].type == 0}">
									<a href="/radio/newsprint.do?id=${allNew[i].id }">【校内新闻】${allNew[i].title }</a>(${allNew[i].inserttime })</a>
								</c:if>
								<c:if test="${allNew[0].type == 1}">
									<a href="/radio/newsprint.do?id=${allNew[i].id }">【校外新闻】${allNew[i].title }</a>(${allNew[i].inserttime })</a>
								</c:if>
							</div>
						</li>
						</c:forEach>

					</ul>
				</div>

				<div id="rili">
					<div id="dg_bt">
						<h2>
							English
							<hr color="21b7c6" width="580px;">
						</h2>
					</div>

					<div id="eng">
						<div id="eng_nr">
							<div id="eng_nr_time">
								<span id="day">${time1 }</span><br /> ${time2 }
							</div>

							<% int i=0; %>
							<c:forEach var="i" begin="0" step="1" end="<%= i %>">
								<c:if test="${allIndex[i].english!=null }">
									<p>${allIndex[i].english}
									<h3>${allIndex[i].zhongwen}</h3>
									<%i=0; %>
									</p>
								</c:if>
								<c:if test="${allIndex[i].english==null }">
									<%i++; %>
								</c:if>
							</c:forEach>
							
						</div>




					</div>


				</div>
			</div>

			<div id="diange">

				<div id="dg_bt">
					<h2>
						点歌台
						<hr color="21b7c6">
					</h2>
					<div id="dg_nr">
						<div id="ydgq">
							<span>已点歌曲</span>
							<hr width="300px" />
						</div>

						<div style="height:400px;width:300px; overflow:hidden">

							<ul id="marquee" style="height:400px">

								<c:if test="${allSongSize-1 >= 0}">
									<c:forEach begin="0" step="1" end="${allSongSize-1 }" var="i">
											<li>
											<p>
												${allSong[i].songName }<font color="green">(播放)</font>
											</p>
											<p>送给Ta:${allSong[i].revicer }</p>
											<p>点歌用户: ${allSong[i].sender }</p>
											<p id="dg_ly">
												<b>寄语:${allSong[i].content }</b>
											</p>
										</li>
										<hr width="300px" />
									</c:forEach>
								</c:if>

							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div id="index_null"></div>
	
<%@ include file="bottom.jsp" %>

	