<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>booksShare</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
    <link rel="stylesheet" href="../res/layui/css/layui.css">
  	<link rel="stylesheet" href="../res/css/global.css">
  	<style>
  	
.disu{
      list-style: none;
    }
    #discuss{
      background-color: #f5f5f5;
      border-bottom: 1px solid #eee;
    }
    #message {
    width: 1190px;
    color: #3c3c3c;
    margin: 0 auto;
    }
    .disu{
      display: flex;
      flex-direction: column;
      justify-content: center;
    }
    .pdismes{
      height: 60px;
      width: 600px;
      margin: 0 auto;
      padding: 10px 0;
      text-align: center;
      font-size:60px;
      line-height:60px;
      margin-bottom:30px;
    }
    .dismes{
      height: 60px;
      width: 600px;
      margin: 0 auto;
      padding: 10px 0;
      text-align: center;
      border: 1px solid rgba(0, 0, 0,.1);
    }
    .dismes div{
      font-size: 30px;
      line-height: 30px;
      width: 600px;
      height: 30px;
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
    
    }
    .dismes p span{
      display: inline-block;
      height: 20px;
      width: 200px;
      padding: 5px 0;
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
    }
  	  	  .mytextarea{
      width: 600px;
      height: 600px;
      position: absolute;
      left: 50%;
      top: 50%;
      margin-top: -200px;
      margin-left: -300px;
      display: none;
      z-index: 999;
    }
    .text textarea{
      width: 600px;
      height: 500px;
    }
    .mytextarea div input{
      width: 80px;
      height: 40px;
      font-size:20px;
      margin-left: 260px;
    }
    .mytextarea div .hidetext{
      margin-left: 500px;
    }
  	</style>
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
                    <p></p></div>
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
    <a href="userdiscussselect">交流中心</a><span>/</span><a href="javascript:;">${pdiscuss.discuss_content }</a>
    <div style="float:right;" class="hidetext1">
    	<a style="color:red" href="javascript:;">发布交流信息</a>
    </div>
    </div>
</div>

 <div id="discuss">
    <div id="message">
      <ul class="disu">
       <li class="pdismes">${pdiscuss.discuss_content }</li>
      	<c:forEach var="u" items="${ucdiscusslist}">
      	
        <li class="dismes">
       
          <div>
          ${u.discuss_content } 
          </div>
          <p>
            <span>发布人：${u.discuss_u_id }</span> <span>发布时间：${u.discuss_time }</span>
          </p>
          
        </li>
         
        </c:forEach>
       
      </ul>
    </div>
  </div>




  <div class="mytextarea">
    <form action="udiscussadd" method="post" >
   
      <div class="text">
      	<input type="hidden" value="${pdiscuss.discuss_id }" name="pid">
      	<input type="hidden" value="${name.user_id}" name="u_id">
        <input type="hidden" value="${name.user_name}" name="u_name">
        <input type="hidden" value="" name="time" id="time">
        <textarea placeholder="请输入内容。。。" name="cvalue"></textarea>
      </div>
    <div >
      <input type="submit" id="usub">
      <div class="hidetext" style="color:red">取消发布</div>
    </div>
  </form>
  
  </div>
  <!--返回顶部-->
<div class="gotop"><a href="showcart">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="javascript:show1();" class="dh" id="showt">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>发布<br/>交流</dd>
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
    <p>交流信息</p>
    </div>
 <script>
   $(".hidetext").click(function(){
     $(".mytextarea").hide();
   })
   $(".hidetext1").click(function(){
     $(".mytextarea").show();
   })
 function show1(){
    $("#showt").click(function(){
     $(".mytextarea").show();
   })
   }
    
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
    var time =date.toLocaleString('chinese',{hour12:false});
    
 
   	var t=document.getElementById("time");
   	
   	$("#usub").click(function(){
   		t.value=time;
   	})
   	

 </script>


<div class="footer" style="margin-top:100px">
    <p class="dibu">BooksShare&copy;2020-2022公司版权所有 渝ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：100-1000-1000</p>
</div>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>