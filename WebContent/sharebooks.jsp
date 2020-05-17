<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
 <style type="text/css">
			
			form input{
				margin-left: 20px;
				height: 25px;
				width: 450px;
				border:1px solid black;
			}
			form table{
				width: 100%;
				border-collapse:collapse;
				border: 1px solid rgba(0,0,0,.3);
			}
			form table tr{
				height:30px
			}
			form table select{
				margin-left: 20px;
				height: 25px;
				width: 200px;
				border:1px solid black;
			}
			.doadd,
			.back{
				margin-left: 20px;
				width: 100px;
				background-color: #006dcc;
			}
			.ding div form{
			border-bottom: 1px solid rgba(255,255,255,0.1);
			}
			
		</style>
</head>
<body><!------------------------------head------------------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexselect">
         <img src="img/temp/logo.png" style="width: 144px; opacity: 0.8;"/></a></h1>
            <div class="fr clearfix" id="top1">
            <p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>
            </p>
                <form  class="fl " >
                </form>
                
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
            href="mygxin.jsp">个人中心</a><span>/</span><a href="tobooksShare" class="on">共享图书</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
               <p class="clearfix"><span class="fl">[${name.user_id}]</span><span class="fr">[<a href="logout">退出登录</a>]</span></p></h3>
            <div><h4>我的活动</h4>
                <ul>
                    <li class="on"><a href="tobooksShare">共享图书</a></li>
                    <li ><a href="userorderselect">我的图书</a></li>
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
        <div class="you fl"><h2>图书信息</h2>
            <div class="gxin">
                 
              <form action="/booksShare/dosharebooks" method="post" enctype="multipart/form-data"  name="myform">
			<table >
				<tr>
					<th>&nbsp;图书名称：</th>
					<td>
						<input type="text" name="booksName" value="" type="text"/>
					</td>
				</tr>
				<tr><th>&nbsp;图书分类：</th>
				<td>
					<select name="parentId">
				<c:forEach var="f" items="${flist }">
 					<option value="${f.cate_id }" disabled="disabled"> |-${f.cate_name } </option>
     				<c:forEach var="c" items="${clist }">
          		<c:if test="${c.cate_parent_id == f.cate_id}">
           			<option value="${f.cate_id }-${c.cate_id }"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.cate_name } </option>
                     	</c:if>
                  	</c:forEach>
         			</c:forEach>
					</select>
				</td>
				</tr>
				<tr>
					<th>图书图片1</th>
					<td>
						<input type="file" name="photo1" id="title" value="" />
					</td>
				</tr>
				<tr>
					<th>图书图片2</th>
					<td>
						<input type="file" name="photo2"  value="" />
					</td>
				</tr>
				<tr>
					<th>图书图片3</th>
					<td>
						<input type="file" name="photo3"  value="" />
					</td>
				</tr>
				<tr>
					<th>图书介绍</th>
					<td>
						<input type="text" name="booksDesc"  value="" />
					</td>
				</tr>
				<tr>
					<th>图书数量</th>
					<td>
						<input type="text" name="booksStock" id="" value="" />
					</td>
				</tr>
				<tr>
					<th></th>
				      <td>
				       <input class="doadd" value="提交" type="submit">
				       <input class="back" onClick="history.go(-1)" value="返回" type="button">
				          </td>
				      </tr>
			</table>
			
		</form>
                 
                 
                 
            </div>
        </div>
    </div>
</div>
<!--返回顶部-->
<div class="gotop"><a href="cart.html">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.html">
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
    <p>400-800-8200</p></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>