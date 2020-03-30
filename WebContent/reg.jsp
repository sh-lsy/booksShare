<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/calendar.js"></script>
    <script src="js/jquery-1.12.4.min.js"> </script>
    <style type="text/css">
  
    </style>
</head>
<body>
<div class="reg">
    <form action="register" method="post" onsubmit="return submitcheck()"><h1><a href="index.jsp">
      <img src="img/temp/logo.png" id="headImg"></a></h1>
        <h2 id="regH">用户注册</h2> 
        <p><input class="messages" type="text" name="userName" id="userName" value="" ><span  id="user-s"></span></p>
        <p><input class="messages" type="text" name="name" id="name" value="" ><span  id="user-n"></span></p>
        <p><input type="password" placeholder="请输入密码：" name="password" id="password" maxlength="16" value="" ><span  id="user-p"></span></p>
        <p><input  type="password" placeholder="请确认密码：" name="rePassword" id="rePassword" maxlength="16" value="" ><span id="user-rp"></span></p>
        <p>	<input class='sex' type="radio" name="sex" value="T" checked>男
        	<input  class ='sex' type="radio" name="sex" value="" >女</p>
        <p><input class="messages" type="text" onfocus="c.show(this)" name="birthday" id="birthday" value="" ></p>
        <p><input class="messages" type="text" name="email" id="email" value="" ><span id="user-e"></span></p>
        <p><input class="messages" type="text" name="mobil" id="mobil" maxlength="11" value="" ><span id="user-m"></span></p>
        <p><input class="messages"  autocomplete="off" type="text" name="address" id="address" list="sexlist"  value="" >
         <datalist id="sexlist">
                <option>学生</option>
                <option>老师</option>
                <option>外来人员</option>
            </datalist>
        </p>
        <p><input class="code" type="text" name="veryCode" id="veryCode" value="" placeholder="验证码">
        <img class="codeimg" src="getcode" onclick="change(this)" title="点击，更换验证码"><span id="user-v"></span></p>
        
        <p><input type="submit" name="" id="reg-sub" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="javascript:;">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
 <script src="js/login.js"></script>
</body>
</html>