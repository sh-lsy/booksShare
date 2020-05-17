<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span></span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="/booksShare/manage/admin_douserselect"><i class="icon-font">&#xe001;</i>用户管理</a>
                    <a href="/booksShare/manage/admin_cateselect"><i class="icon-font">&#xe005;</i>分类管理</a>
                    <a href="/booksShare/manage/admin_cateselect"><i class="icon-font">&#xe048;</i>图书管理</a>
                    <a href="insert.html"><i class="icon-font">&#xe041;</i>共享管理</a>
                    <a href="#"><i class="icon-font">&#xe01e;</i>评论管理</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info">WIN10</span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info">Apache</span>
                    </li>
                    <li>
                        <label class="res-lab">设计-版本</label><span class="res-info">v-0.1</span>
                    </li>
                    <li>
                        <label class="res-lab">上传附件限制</label><span class="res-info">2M</span>
                    </li>
                    <li>
                        <label class="res-lab">北京时间</label><span class="res-info" id="time"></span>
                    </li>
                    <li>
                        <label class="res-lab">服务器域名/IP</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
                    </li>
                    <li>
                        <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>

        </div>
    </div>
    <!--/main-->
	<script>
	var date1=new Date();
	         var d1=date1.toLocaleString();
	         var div1=document.getElementById("time");
	         div1.innerHTML =d1;
	function  getD1(){
		         var date=new Date();
		         var d2=date.toLocaleString();
		         div1.innerHTML =d2;
		 
		     }
		 
		     setInterval("getD1();",1000);

	</script>
</body>
</html>