<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>详情页</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>
<!-- header -->
<%@ include file="header.jsp" %>

<div class="address">
    <div class="wrapper clearfix">
    		<a href="indexselect">首页</a><span>/</span>
    		<a href="selectproductlist?cid=${cate.cate_id}">${cate.cate_name }</a><span>/</span>
    		<a href="javascript:;" class="on">${b.books_name }</a>
    </div>
</div>
<!-- ---------------------Detail---------------------------- -->
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl"><img class="det" src="http://localhost:8080/img/${b.books_filename }">
                <div class="smallImg clearfix"><img src="http://localhost:8080/img/${b.books_filename }"
                                                    data-src="http://localhost:8080/img/${b.books_filename }">
                                              <img src="http://localhost:8080/img/${b.books_filename1 }" data-src="http://localhost:8080/img/${b.books_filename1 }"><img
                        src="http://localhost:8080/img/${b.books_filename2 }" data-src="http://localhost:8080/img/${b.books_filename2 }">
                        </div>
            </div>
            <div class="fr intro">
                <div class="title"><h4>【books】${b.books_name }</h4>
                    <p>【书籍描述】${b.books_description }</p><span>【书籍共享者】${b.books_user }</span></div>
                <div class="proIntro"><p>选择系列</p>
                    <div class="smallImg clearfix categ"><p class="fl"><img src="http://localhost:8080/img/${b.books_filename }"
                                                                            alt="${b.books_description }"
                                                                            data-src="http://localhost:8080/img/${b.books_filename }"></p>
                        <p class="fl"><img src="http://localhost:8080/img/${b.books_filename1 }"
                                                                            alt="${b.books_description }"
                                                                            data-src="http://localhost:8080/img/${b.books_filename1 }"></p>
                        <p class="fl"><img src="http://localhost:8080/img/${b.books_filename2 }"
                                                                            alt="${b.books_description }"
                                                                            data-src="http://localhost:8080/img/${b.books_filename2 }"></p>
                    </div>
                    <p>数量&nbsp;&nbsp;库存<span>${b.books_stock }</span>本</p>
                    <div class="num clearfix"><img class="fl sub" src="img/temp/sub.jpg">
                    <span class="fl" contentEditable="true" id="count">1</span>
                    <img class="fl add" src="img/temp/add.jpg">
                        </div>
                </div>
                <div class="btns clearfix">
                <a href="javascript:booksAdd(${b.books_id },'z')"> <p class="buy fl">立即租用</p></a>
                <a href="javascript:booksAdd(${b.books_id },'s')"><p class="cart fr">加入购物车</p></a></div>
            </div>
        </div>
    </div>
</div>
<script>
	function booksAdd(id,url){
		var count = document.getElementById("count").innerHTML;
		
		location.href='cartadd?id='+id+'&count='+count+'&url='+url;
	}
</script>
<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix"><a class="on">图书详情</a></div>
        <div class="msgAll">
            <div class="msgImgs"><img src="http://localhost:8080/img/${b.books_filename }" style="width:80%">
            <img src="http://localhost:8080/img/${b.books_filename1 }" style="width:80%">
            <img src="http://localhost:8080/img/${b.books_filename2 }" style="width:80%"></div>

        </div>
    </div>
    <div class="msgR fr" style="width:200px"><h4>为你推荐</h4>
        <div class="seeList">
        
        <c:forEach  var="cb" items="${classlist }">
        <a href="selectbooksview?id=${cb.books_id }">
            <dl>
                <dt><img src="http://localhost:8080/img/${cb.books_filename }" width="100%"></dt>
                <dd>【book】${cb.books_name }</dd>
                <dd>库存${cb.books_stock }</dd>
            </dl>
        </a>
        </c:forEach>
         </div>
    </div>
</div>
<div class="like"><h4>最近访问</h4>
    <div class="bottom">
        <div class="hd"><span class="prev"><img src="img/temp/prev.png"></span><span class="next"><img
                src="img/temp/next.png"></span></div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>
                 <c:forEach  var="lb" items="${lastlylist }">
       				 <a href="selectbooksview?id=${lb.books_id }">
            		 <dl>
                	<dt><img src="http://localhost:8080/img/${lb.books_filename }" width="100%"></dt>
                	<dd>【book】${lb.books_name }</dd>
                	<dd>库存${lb.books_stock }</dd>
            		</dl>
       				 </a>
       			 </c:forEach>
                
               </div>
            </div>
        </div>
    </div>
</div><!--返回顶部-->
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
<div class="msk"></div>
<!--footer-->
<div class="footer">
    <p class="dibu">BooksShare&copy;2020-2022公司版权所有 渝ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：100-1000-1000</p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>