<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexselect">
        <img src="img/temp/logo.png" style="width: 144px; opacity: 0.8;"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            <c:if test="${isLogin !=1 }">
            <a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            </c:if>
            <c:if test="${isLogin ==1 }">
            	 <b>您好:</b><a href="JavaScript:;" id="login">${ name.user_id}</a>
            </c:if>
             <c:if test="${isAdminLogin ==1 }">
            	<a href="manage/admin_index.jsp" id="login1">进入后台</a>
            </c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：考研资料"/><input
                        type="button"/></form>
                        
                <div class="btn fl clearfix">
                
                <c:if test="${isLogin !=1 }">
                <a href="login.jsp"><img src="img/grzx.png" title="个人中心"/></a>
                <a href="login.jsp" class="er1"><img src="img/ewm.png" title="交流区"/></a>
                </c:if>
                <c:if test="${isLogin ==1 }">
                <a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                <a href="#" class="er1"><img src="img/ewm.png"/></a>
                </c:if>
                 </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
            
             <c:forEach var="f" items="${flist }">
            
            <li><a href="selectproductlist?fid=${f.cate_id }">${f.cate_name }</a>
                <div class="sList2">
                    <div class="clearfix">
                    	<c:forEach var="c" items="${clist }">
                    		<c:if test="${f.cate_id == c.cate_parent_id }">
                    			<a href="selectproductlist?cid=${c.cate_id }">${c.cate_name }</a>
                    		</c:if>
                    	</c:forEach>
                    </div>
                </div>
            </li>
           </c:forEach>
           
        </ul>
    </div>
</div>