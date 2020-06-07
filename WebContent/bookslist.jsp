<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>
<!-- header -->
<%@ include file="header.jsp" %>

<div class="banner"><a href="#"><img src="img/temp/banner1.png"></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix"><a href="indexselect">首页</a><span>/</span>
    <a href="JavaScript:;" class="on">${title}</a></div>
</div><!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix"><h3 class="fl">${title}</h3>
        
    </div>
</div><!----------------proList------------------------->
<ul class="proList wrapper clearfix">
   	<c:forEach var="b" items="${list }">
	    <li><a href="selectbooksview?id=${b.books_id}">
	        <dl>
	            <dt><img src="http://localhost:8080/img/${b.books_filename }"></dt>
	            <dd>【BOOK】${b.books_name }</dd>
	            <dd>库存${b.books_stock }</dd>
	        </dl>
	    </a></li>
    </c:forEach>
</ul>
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
<div class="msk"></div><!--footer-->
<div class="footer">
    <p class="dibu">BooksShare&copy;2020-2022公司版权所有 渝ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：100-1000-1000</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>