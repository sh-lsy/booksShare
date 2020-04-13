<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="admin_menu.jsp" %>
    <!-- /sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span></div>
        </div>
        <div class="result-wrap">
            <form action="/booksShare/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/booksShare/manage/admin_tobooksadd"><i class="icon-font"></i>新增图书</a>     
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="60%">
                   
                        <tr>
                            <th>ID</th>
                            <th>图书名称</th>
                            <th>操作</th>
                        </tr>
                    <c:forEach var="b" items="${blist }">
                        	<tr>
                        		<td>${b.books_id }</td>
                        		<td><img src="../img/books/${b.books_filename}" width="80" height="80">
                        			${b.books_name }
                        		</td>
                        		<td>
                        			<a href="">修改</a>
                        			<a href="">删除</a>
                        		</td>
                        	</tr>
	                    </c:forEach>
                        
                     </table>
   							<script>
   							function catedel(id) {
                        		if(confirm("你确定要删除这个分类吗？")) {
                        			location.href="admin_docatedel?id="+id;
                        			
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