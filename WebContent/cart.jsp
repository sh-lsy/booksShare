<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>cart</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body><!--------------------------------------cart--------------------->
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexselect">
         <img src="img/temp/logo.png" style="width: 144px; opacity: 0.8;"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="搜索"/><input type="button"/>
                </form>
                <div class="btn fl clearfix"><a href="mygxin.html"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a><a href="cart.html"><img src="img/gwc.png"/></a>
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
<div class="cart mt"><!-----------------logo------------------->
    <!--<div class="logo"><h1 class="wrapper clearfix"><a href="index.html"><img class="fl" src="img/temp/logo.png"></a><img class="top" src="img/temp/cartTop01.png"></h1></div>-->
    <!-----------------site------------------->
    <div class="site"><p class=" wrapper clearfix"><span class="fl">购物车</span>
    <img class="top" src="img/temp/cartTop01.png">
    <a href="indexselect" class="fr">寻找图书&gt;</a></p></div><!-----------------table------------------->
    <div class="table wrapper">
        <div class="tr">
            <div>商品</div>
            <div>共享者</div>
            <div>数量</div>
            <div>操作</div>
        </div>
        <c:forEach var="rs" items="${requestScope.bookslist }">
        <div class="th">
            <div class="pro clearfix"><label class="fl">
            <input name="ck"  type="checkbox" value="${rs.cart_id }"/>
            <span></span></label>
            <a class="fl"  href="selectbooksview?id=${rs.cart_b_id }">
                <dl class="clearfix">
                    <dt class="fl">
                    <img src="http://localhost:8080/img/${rs.cart_b_filename }" width="120" height="120" >
                    </dt>
                    <dd class="fl"><p>${rs.cart_b_name }</p>
                        <p>图书分类</p>
                        <p>${rs.cart_b_description }</p></dd>
                </dl>
            </a></div>
            <div class="price">${rs.cart_b_user }</div>
            <div class="number">
            <p class="num clearfix">
            <img class="fl sub" src="img/temp/sub.jpg">
            <span class="fl" datasrc="${rs.cart_id }">${rs.cart_quantity }</span>
            <img class="fl add" src="img/temp/add.jpg">
            </p>
            </div>
            <div class="price"><a class="del" href="javascript:;" datasrc="${rs.cart_id }">删除</a></div>
        </div>
		</c:forEach>

        <div class="goOn">空空如也~<a href="indexselect">去逛逛</a></div>
        
        <div class="tr clearfix"><label class="fl"><input class="checkAll" type="checkbox"/><span></span></label>
            <p class="fl"><a href="javascript:;">全选</a>
            <a class="del" href="javascript:;">删除</a>
            </p>
            <p class="fr"><span>共<small id="sl">0</small>件图书</span>
            <a href="javascript:toorder()" class="count">享用</a></p></div>
    </div>
</div>
<script>
	function toorder() {
		var str = "";
		$("input[name='ck']:checked").each(function(index, item){
			if($("input[name='ck']:checked").length-1 == index){
				str+= $(this).val();
			}else{
				str+= $(this).val()+",";
			}
			
		});
		
		location.href="orderselect?eids="+str;
	}
</script>
<div class="mask"></div>
<div class="tipDel"><p>确定要删除该商品吗？</p>
    <p class="clearfix"><a class="fl cer" href="#">确定</a><a class="fr cancel" href="#">取消</a></p></div><!--返回顶部-->
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
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div>
<!--footer-->

<div class="pleaseC"><p>请选择宝贝</p><img class="off" src="img/temp/off.jpg"/></div>
<div class="footer cartfo">
    <p class="dibu">BooksShare&copy;2020-2022公司版权所有 渝ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：100-1000-1000</p>
</div>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>