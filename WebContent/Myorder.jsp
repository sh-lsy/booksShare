<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>booksShare</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexselect">
         <img src="img/temp/logo.png" style="width: 144px; opacity: 0.8;"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="搜索"/><input type="button"/>
                </form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a><a href="cart.jsp"><img src="img/gwc.png"/></a>
                    <p><a href="#"></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
            
            <li><a href="selectproductlist?fid=32">教材用书</a>
            </li>
            <li><a href="selectproductlist?fid=33">计算机编程类</a></li>
            <li><a href="selectproductlist?fid=34">考研资料</a></li>
            <li><a href="selectproductlist?fid=35">课外阅读</a></li>
            <li><a href="selectproductlist?fid=36">文档资料</a></li>
        </ul>
    </div>
</div>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="indexselect" class="fl">首页</a><span>/</span><a
            href="mygxin.jsp">个人中心</a><span>/</span><a href="userorderselect" class="on">我的订单</a></div>
</div>

<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
                <p class="clearfix"><span class="fl">[${name.user_id}]</span><span class="fr">[<a href="logout">退出登录</a>]</span></p></h3>
            <div><h4>我的活动</h4>
                <ul>
                    <li><a href="tobooksShare">共享图书</a></li>
                    <li class="on"><a href="userorderselect">我的图书</a></li>
                    <li><a href="myprod.html">我的交流</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li ><a href="mygxin.jsp">我的中心</a></li>
                    <li><a href="showmysharebooks">我的共享</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li><a href="tomygrxx">个人信息</a></li>
                    <li><a href="remima.html">修改密码</a></li>
                </ul>
            </div>
        </div>
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2><a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="javascript:;">全部有效订单</a></li>
                    <li><a href="javascript:;">待收货</a></li>
                    <li><a href="javascript:;">已确认</a></li>
                    <li><a href="javascript:;">共享完成</a></li>
                </ul>
                <form action="#" method="get" class="fr clearfix">
                <input type="text" name="" id="" value="" placeholder="请输入商品名称、订单号"/>
                <input type="button" value=""/>
                </form>
            </div>
            
            <div id="allorder">
             <c:forEach var="no" items="${requestScope.no }">
             
				<c:if test="${no.order_valid ==1 }">
            <div class="dkuang clearfix deng"><p class="one fl">待收货</p>
                <div class="clearfix">
                </div>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                       <li>${no.order_time}</li>
                        <li>订单号:${no.order_no}</li>
                        <li>取书方式:${no.order_way }</li>
                    </ul>
                     <p class="fr myorder">
                     <a href="finishorder?no=${no.order_no }">确认收货</a>
                    <a href="orderxq?no=${no.order_no }" class="xq">订单详情</a>
                    </p>
                    </div>
                    <c:forEach var="o" items="${requestScope.orderlist }">
                	<c:if test="${o.order_no == no.order_no }">
                	<div class="shohou clearfix">
               
                	<a href="#" class="fl"><img src="http://localhost:8080/img/${o.order_b_filename }"/></a>
                    <p class="fl">
                    <a href="#">${o.order_b_name}</a>
                    <a href="#">数量:${o.order_quantity}</a>
                    </p>
                    
                    <p class="fr"><a href="javascript:;">共享者:${o.order_b_user}</a>
                    </p>
                    </div>
                    </c:if>
                    </c:forEach>
            </div>
            </c:if>
             
             
				<c:if test="${no.order_valid ==2 }">
            <div class="dkuang ">
            <p class="one">已收货</p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                    	<li>${no.order_time}</li>
                        <li>订单号:${no.order_no}</li>
                        <li>取书方式:${no.order_way }</li>
                    </ul>                   
                    <p class="fr ">
                    <a href="orderxq?no=${no.order_no }" class="xq">订单详情</a>
                    </p>
                    </div>
         		<c:forEach var="o" items="${requestScope.orderlist }">
                	<c:if test="${o.order_no == no.order_no }">
                	<div class="shohou clearfix">
                	<a href="#" class="fl">
                	<img src="http://localhost:8080/img/${o.order_b_filename }" /></a>
                    <p class="fl">
                    <a href="#">${o.order_b_name}</a>
                    <a href="#">共享者:${o.order_b_user}</a>
                    <a href="#">数量:${o.order_quantity}</a>
                    </p>
                    <p class="fr"><a href="javascript:;">共享者:${o.order_b_user}</a>
                    </div>
                    </c:if>
                    </c:forEach>
            </div>
            </c:if>
            
            <c:if test="${no.order_valid ==3 }">
            <div class="dkuang ">
            <p class="one">共享完成</p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                    	<li>${no.order_time}</li>
                        <li>订单号:${no.order_no}</li>
                        <li>取书方式:${no.order_way }</li>
                    </ul>                   
                    <p class="fr ">
                    <a href="orderxq?no=${no.order_no }" class="xq">订单详情</a>
                    </p>
                    </div>
         		<c:forEach var="o" items="${requestScope.orderlist }">
                	<c:if test="${o.order_no == no.order_no }">
                	<div class="shohou clearfix">
                	<a href="#" class="fl">
                	<img src="http://localhost:8080/img/${o.order_b_filename }" /></a>
                    <p class="fl">
                    <a href="#">${o.order_b_name}</a>
                    <a href="#">共享者:${o.order_b_user}</a>
                    <a href="#">数量:${o.order_quantity}</a>
                    </p>
                    <p class="fr"><a href="javascript:;">共享者:${o.order_b_user}</a>
                    </div>
                    </c:if>
                    </c:forEach>
            </div>
            </c:if>
            </c:forEach>
           </div>

			<div id="reorder">
				<c:forEach var="no" items="${requestScope.no }">
				<c:if test="${no.order_valid ==1 }">
            <div class="dkuang clearfix deng"><p class="one fl">待收货</p>
                <div class="clearfix">
                </div>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                       <li>${no.order_time}</li>
                        <li>订单号:${no.order_no}</li>
                        <li>取书方式:${no.order_way }</li>
                    </ul>
                     <p class="fr myorder">
                     <a href="finishorder?no=${no.order_no }">确认收货</a>
                    <a href="orderxq?no=${no.order_no }" class="xq">订单详情</a>
                    </p>
                    </div>
                    <c:forEach var="o" items="${requestScope.orderlist }">
                	<c:if test="${o.order_no == no.order_no }">
                	<div class="shohou clearfix">
               
                	<a href="#" class="fl"><img src="http://localhost:8080/img/${o.order_b_filename }"/></a>
                    <p class="fl">
                    <a href="#">${o.order_b_name}</a>
                    <a href="#">数量:${o.order_quantity}</a>
                    </p>
                    
                    <p class="fr"><a href="javascript:;">共享者:${o.order_b_user}</a>
                    </p>
                    </div>
                    </c:if>
                    </c:forEach>
            </div>
            </c:if>
			</c:forEach>
			</div>
			
			<div id="rorder">
			<c:forEach var="no" items="${requestScope.no }">
			<c:if test="${no.order_valid ==2 }">
            <div class="dkuang ">
            <p class="one">已收货</p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                    	<li>${no.order_time}</li>
                        <li>订单号:${no.order_no}</li>
                        <li>取书方式:${no.order_way }</li>
                    </ul>                   
                    <p class="fr ">
                    <a href="orderxq?no=${no.order_no }"class="xq">订单详情</a>
                    </p>
                    </div>
         		<c:forEach var="o" items="${requestScope.orderlist }">
                	<c:if test="${o.order_no == no.order_no }">
                	<div class="shohou clearfix">
                	<a href="#" class="fl">
                	<img src="http://localhost:8080/img/${o.order_b_filename }" /></a>
                    <p class="fl">
                    <a href="#">${o.order_b_name}</a>
                    <a href="#">共享者:${o.order_b_user}</a>
                    <a href="#">数量:${o.order_quantity}</a>
                    </p>
                    <p class="fr"><a href="javascript:;">共享者:${o.order_b_user}</a>
                    </div>
                    </c:if>
                    </c:forEach>
            </div>
            </c:if>
            </c:forEach>
			</div>
			
			<div id="completeorder">
			<c:forEach var="no" items="${requestScope.no }">
			<c:if test="${no.order_valid ==3 }">
            <div class="dkuang ">
            <p class="one">共享完成</p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                    	<li>${no.order_time}</li>
                        <li>订单号:${no.order_no}</li>
                        <li>取书方式:${no.order_way }</li>
                    </ul>                   
                    <p class="fr ">
                    <a href="orderxq?no=${no.order_no }"class="xq">订单详情</a>
                    </p>
                    </div>
         		<c:forEach var="o" items="${requestScope.orderlist }">
                	<c:if test="${o.order_no == no.order_no }">
                	<div class="shohou clearfix">
                	<a href="#" class="fl">
                	<img src="http://localhost:8080/img/${o.order_b_filename }" /></a>
                    <p class="fl">
                    <a href="#">${o.order_b_name}</a>
                    <a href="#">共享者:${o.order_b_user}</a>
                    <a href="#">数量:${o.order_quantity}</a>
                    </p>
                    <p class="fr"><a href="javascript:;">共享者:${o.order_b_user}</a>
                    </div>
                    </c:if>
                    </c:forEach>
            </div>
            </c:if>
            </c:forEach>
			</div>

            <div class="fenye clearfix"><a href="javascript:;">
            <img src="img/zuo.jpg"/></a>
            <a href="javascript:;">1</a><a href="javascript:;">
            <img src="img/you.jpg"/></a></div>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="showcart">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
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
    <p>400-800-8200</p></div>
<!--footer-->
<div class="footer">
    <p class="dibu">BooksShare&copy;2020-2022公司版权所有 渝ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：100-1000-1000</p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>