<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>order</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
</head>
<body><!----------------------------------------order------------------>
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
</div>
<div class="order cart mt"><!-----------------site------------------->
    <div class="site"><p class="wrapper clearfix"><span class="fl">订单确认</span><img class="top"
                                                                                   src="img/temp/cartTop02.png"></p>
    </div><!-----------------orderCon------------------->
    <div class="orderCon wrapper clearfix">
        <div class="orderL fl"><!--------h3----------------><h3>收件信息</h3>
            <!--------addres---------------->
            <div class="addres clearfix">
                <div class="addre fl on">
                    <div class="tit clearfix"><p class="fl">[姓名]: ${name.user_name } </p>
                        <p class="fr"></div>
                    <div class="addCon"><p>
                    <span class="default">[身份]: </span>${name.user_address }</p>
                        <p>[手机号]: ${name.user_mobile }</p>
                         <p>[邮箱]: ${name.user_email }</p></div>
                </div>
            </div>
            <h3>选择取书方式</h3><!--------dis---------------->
            <div class="dis clearfix">
            <span class="on">共享中心凭订单获取</span>
           
            </div>
            <br><br><br><br><br><br><br><br>
        </div>
        <div class="orderR fr">
            <div class="msg"><h3>订单内容<a href="showcart" class="fr">返回购物车</a></h3>
                 <c:forEach var="rs" items="${requestScope.shoplist }">
                 <input type="hidden" name="rb" value="${rs.cart_id }">
                <ul class="clearfix">
                    <li class="fl">
                    <img width="100" height="100" src="http://localhost:8080/img/${rs.cart_b_filename}"></li>
                    <li class="fl"><p>${rs.cart_b_name }</p>
                        <p>${rs.cart_b_description}</p>
                        <p>数量: ${rs.cart_quantity}</p></li>
                    <li class="fr">共享者[${rs.cart_b_user}]</li>
                </ul>
                 </c:forEach>
                 
            </div>
            <div class="count tips"></div>
			<a href="javascript:toorderadd()" class="pay">确认享用图书</a></div>
			<br><br><br><br><br><br>
    </div>
</div>
<script type="text/javascript">
	function toorderadd() {
		var str = "";
		var way = document.getElementsByClassName('on')[1].innerHTML;
		
		var date = new Date();
        var y = date.getFullYear();
        var ms =(date.getMonth() + 1).toString();
        var d = (date.getDate()).toString();
        if (ms.length == 1) {
            ms = "0" + ms;
        }
        if (d.length == 1) {
            d = "0" + d;
        }
        var h = date.getHours();
        var m = date.getMinutes();
        var s = date.getSeconds();
        var ran = parseInt(Math.random()*10);
        var now=y+ms+d+h+m+s+ran;
        var time =date.toLocaleString('chinese',{hour12:false});
        
		$("input[name='rb']").each(function(index, item){
			if($("input[name='rb']").length-1 == index){
				str+= $(this).val();
			}else{
				str+= $(this).val()+",";
			}
			
		});
		location.href="orderadd?rids="+str+'&way='+way+'&date='+now+"&time="+time;
	}
</script>
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
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>