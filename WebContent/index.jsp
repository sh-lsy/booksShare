<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>BooksShare</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <style>
    	.imgwh{
    		width:268px;
    		height:268px;
    	}
    </style>
</head>
<body>
<!-- ----------------------------head---------------------------- -->
<%@ include file="header.jsp" %>
<!-- -----------------------banner------------------------- -->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                 <div class="slide"><img src="img/banner1.png"/></div>
            </li>
            <li>
                <a href="userdiscussselect"> <div class="slide"><img src="img/banner2.png"/></div></a>
            </li>
        </ul>
    </div>
</div><!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix">
    <a href="selectproductlist?cid=39"><img src="img/i1.jpg"/></a>
    <a href="selectproductlist?fid=34"><img src="img/i2.jpg"/></a>
    <a href="selectproductlist?fid=35"><img src="img/i3.jpg"/></a></div>
</div>

<!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper">
    
        <h2><img src="img/ch1.jpg"/></h2>
        
        <div class="flower clearfix tran">
        
        <c:forEach var="b1" items="${list1 }">
        
        <a href="selectbooksview?id=33" class="clearfix">
            <dl>
                <dt><span class="abl"></span>
                <img src="http://localhost:8080/img/${b1.books_filename }" class="imgwh"/><span class="abr"></span></dt>
                <dd>【books】${b1.books_name }</dd>
                <dd><span>${b1.books_stock } 本</span></dd>
            </dl>
        </a>
        
        </c:forEach>
        
        
     </div>
    </div>
</div>


<!--返回顶部-->
<div class="gotop"><a href="showcart">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="userdiscussselect" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>去交<br/>流区</dd>
    </dl>
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>交流中心</p>
    </div>
<!--footer-->
<div class="footer">
    <p class="dibu">BooksShare&copy;2020-2022公司版权所有 渝ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：100-1000-1000</p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>