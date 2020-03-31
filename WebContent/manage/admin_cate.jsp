<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="admin_menu.jsp" %>
    <!-- /sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/booksShare/manage/admin_douserselect" method="get">
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
            <form action="/booksShare/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/booksShare/manage/admin_tocateadd"><i class="icon-font"></i>新增分类</a>
                        <a id="batchDel" href="javascript:delmore('你确定删除这些用户吗？', 'myform')"><i class="icon-font"></i>批量删除</a>
                        
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                   
                        <tr>
                            <th>ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="cate" items="${catelist}">
                         <c:if test="${cate.cate_parent_id==0}">
                        <tr>
                           <td>${cate.cate_id}</td>
                            <td>|-${cate.cate_name}</td>
                            <td>
                            <a class="link-update" href="admin_tocateupdate?id=${cate.cate_id }">修改</a>
                             <a class="link-del" >删除</a>
							</td>
                        </tr>
                         <c:forEach var="childCate" items="${catelist}">
                         <c:if test="${childCate.cate_parent_id==cate.cate_id}">
	                        <tr>
	                           <td>${childCate.cate_id}</td>
	                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childCate.cate_name}</td>
	                            <td>
	                            <a class="link-update" href="admin_tocateupdate?id=${childCate.cate_id }">修改</a>
	                             <a class="link-del" >删除</a>
								</td>
	                        </tr>
	                        </c:if>
							</c:forEach>
                          </c:if>
                     </c:forEach>
                     </table>
   							<script>
   							function Delete(mess, url) {
                        		if(confirm(mess)) {
                        			location.href=url;
                        			
                        		}
                        	}
   							</script>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>