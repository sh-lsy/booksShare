<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <style type="text/css">
    body{
    
    }
    </style>
</head>
<body>
<div class="login">
    <form action="login" method="post"><h1><a href="index.jsp">
      <img  id="headImg" src="img/temp/logo.png" style="width: 144px; opacity: 0.8;"></a></h1>
        <p></p>
        <p><input type="text" name="userName" value="昵称/邮箱/手机号" style="color: #999;"
          onfocus="if(this.value=='昵称/邮箱/手机号'){this.value='';this.style.color='#424242'}"
          onblur="if(this,value==''){this.value='昵称/邮箱/手机号';this.style.color='#999'}"></p>
      
        <p><input type="password" name="password" placeholder="请输入密码："></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.jsp">免费注册</a><a href="forget.html">忘记密码？</a></p></form>
</div>
</body>
</html>