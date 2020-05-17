<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="admin_menu.jsp" %>

    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">共享管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/booksShare/manage/admin_doorderselect" method="get">
                    <table class="search-tab">
                    		<tr>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a  href="/booksShare/manage/admin_doorderselect"><i class=""></i>所有订单</a>
                        <a href="/booksShare/manage/admin_doorderselect?vaild=1"><i class=""></i>未收货订单</a>
                        <a href="/booksShare/manage/admin_doorderselect?vaild=2"><i class=""></i>已收货订单</a>
                        <a href="/booksShare/manage/admin_doorderselect?vaild=3"><i class=""></i>已完成订单</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>订单号</th>
                            <th>下单时间</th>
                            <th>订单内容</th>                    
                            <th>下单人</th>
                            <th>订单状态</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="no" items="${nolist}">
                        <tr>
                           	<td>${no.order_no}</td>
                            <td>${no.order_time}</td>
                            
                            <td>
                            <c:forEach var="o" items="${orderlist}">
                            <c:if test="${o.order_no ==no.order_no}">
                            <span>图书名:[${o.order_b_name }]-数量:[${o.order_quantity }]&nbsp;&nbsp;</span>
                            </c:if>
                            </c:forEach>
                            </td>
                            
                            <td>${no.order_u_id}</td>
                            
                            <c:if test="${no.order_valid ==1}">
                            <td style="color:red">未收货</td>
                            <td>
                                <a class="link-update" href="admin_completeorder?id=${no.order_no}&cpage=${cpage}">确认收货</a>
                            </td>
                            </c:if>
                            <c:if test="${no.order_valid ==2}">
                            <td>已收货</td>
                             <td>
                                <a class="link-update" href="admin_completeorder?id=${no.order_no}&cpage=${cpage}">确认归还</a>
                            </td>
                            </c:if>
                            <c:if test="${no.order_valid ==3}">
                            <td>交易完成</td>
                            <td>
                                <a class="link-update" href="JavaScript:;"></a>
                            </td>
                            </c:if>
                              
                        </tr>
                     </c:forEach>
   			
                    </table>
                    <div class="list-page">
                    	共${tsum} 条记录  当前${cpage}/${tpage}页
                    	<a href="admin_doorderselect?cp=1${searchParms}">首页</a>
                    	<a href="admin_doorderselect?cp=${cpage-1<1?1:cpage-1}${searchParms}">上一页</a>
                    	<a href="admin_doorderselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParms}">下一页</a>
                    	<a href="admin_doorderselect?cp=${tpage}${searchParms}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
  
</body>
</html>