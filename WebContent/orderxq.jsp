<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
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
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
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
</div><!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="indexselect" class="fl">首页</a><span>/</span>
    <a href="userorderselect"  class="on">我的订单</a><span>/</span><a
            href="#" class="on">订单详情</a></div>
</div><!------------------------------Bott------------------------------>
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
        <c:forEach var="xq" items="${requestScope.xqno }">
        <div class="you fl">
            <div class="my clearfix"><h2>订单详情<a href="javascript:;">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></h2>
                <h3>订单号：<span>${xq.order_no}</span></h3></div>
                
             
            <div class="orderList">
            	
                <div class="orderList1">
                <c:if test="${xq.order_valid ==2 }">
                <h3>已收货</h3>
               </c:if>
               <c:if test="${xq.order_valid ==1 }">
                <h3 style="color:red">未收货</h3>
               </c:if>
                <c:forEach var="ox" items="${requestScope.orderxq }">
                    <div class="clearfix">
                    <a href="JavaScript:;" class="fl">
                    <img src="http://localhost:8080/img/${ox.order_b_filename }" style="width:65px"/>
                    </a>
                        <p class="fl"><a href="javascript:;">${ox.order_b_name}</a>
                        <a href="javascript:;">数量: ${ox.order_quantity}  &nbsp;&nbsp;</a>
                        <a href="javascript:;">共享者: ${ox.order_b_user}</a></p>
                        </div>
                    </c:forEach>    
                </div>
                <div class="orderList1"><h3>收货信息</h3>
                    <p>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<span>${name.user_name }</span></p>
                    <p>联系电话：<span>${name.user_mobile }</span></p>
                    <p>邮箱地址：<span>${name.user_email }</span></p></div>
                <div class="orderList1"><h3>支付方式及下单时间</h3>
                    <p>支付方式：<span>${xq.order_way }</span></p>
                    <p>下单时间：<span>${xq.order_time }</span></p></div>
            </div>
            
            
        </div>
        </c:forEach>
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
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>