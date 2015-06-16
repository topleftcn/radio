<%@ page import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style/style.css" media="screen"
	type="text/css" />
	<meta charset=utf8>
<title>点歌平台</title>

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
			active : false, //false为都折叠，要某个不折叠，只要设置index即可
			header : '.head', //可以折叠的元素
			navigation : true,
			event : 'click', //折叠展开时的事件
			fillSpace : false,
			animated : 'bounceslide' //bounceslide,easeslide展开折叠时的动态效果，需要引入其他js文件（UI Effects Core）
		});
	});
</script>

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
			<%@ include file="link.jsp" %>			<div class="btn_right"></div>
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

		<div id="dg_all">

			<div id="dg_left">
				<div id="jm_right_bt">
					<h3 id="jm_left_bt">CONTENT</h3>
				</div>

				<div id="jm_right_nr"></div>

				<div id="container1">
					<div class="maincontent">
						<div class="box">
							<ul id="navigation">
							<c:if test="${requestScope.allSongSize-1 >= 0}">
							<c:forEach begin="0" step="1" end="${requestScope.allSongSize-1 }" var="i">
									<c:if test="${allSong[i].type == 1 }">
										<li><span class="head">点歌人:${requestScope.allSong[i].sender }
												&nbsp;&nbsp;歌名:${requestScope.allSong[i].songName }</span>
											<p>
												<font color=red>送给Ta:${requestScope.allSong[i].revicer }</font><br />
												寄语:${requestScope.allSong[i].content }
											</p></li>
									</c:if>
								</c:forEach>
							</c:if>
								
							</ul>
						</div>
					</div>
				</div>

				<div id="ty_nr_db">
					<!-- 样式无 -->
					<c:if test="${pages!=1 }">
						<a href="/radio/frontsongset.do?pages=${pages-2 }">上一页</a>
					</c:if>
					&nbsp;${pages } / ${totalPages }&nbsp;
					<c:if test="${pages < totalPages }">
						<a href="/radio/frontsongset.do?pages=${pages }">下一页</a>
					</c:if>
				</div>
			</div>
			<div id="dg_right">
				<center>
					<iframe id="radio" name="iframe_canvas"
						src="http://douban.fm/partner/baidu/doubanradio" scrolling="no"
						frameborder="0" height="190" width="380"></iframe>
				</center>
			</div>
		</div>
		<div id="clear_all"></div>

		<!--
	时间：2015-06-09
	描述：留言板在这里
-->
		<div id="dgt_ly">
			<div id="dgt_dg">
				<b>我要点歌</b>
			</div>

			<div id="dgt_ly_nr">
				<form method="post" action="/radio/songinsert.do" name="form1" onSubmit="return myCheck()">
					<div id="line">
						<input name="songName" id="songName" placeholder="歌名(必填)"
							tabindex="11" style="width: 25em ; height: 30px;" type="text">
						<div id="dg_cont">
							<textarea name="content" placeholder="寄语(必填)"
								 style="width: 750px; height: 55px;margin-top: 10px;"></textarea>
							<div id="r_left">
								<input name="revicer" placeholder="送给Ta(必填)"
									style="width: 20em ; height: 30px;" type="text">
							</div>
							<div id="r_right">
								<input name="sender" placeholder="点歌人(必填)" id="sender" 
									style="width: 20em ; height: 30px;" type="text">
							</div>
						</div>
					</div>
					<input type="submit" class="pnpnc" name="topicsubmit" value="点歌" style="width:100px;height:30px;background:#23B7C6;border:0px;"/>
				</form>
			</div>


		</div>
		<div id="clear_all"></div>
	</div>
	<div id="all_down"></div>

	</div>

<%@ include file="bottom.jsp" %>