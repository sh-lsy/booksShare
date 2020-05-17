<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="admin_menu.jsp" %>
    <!-- /sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">评论管理</span></div>
        </div>
        <div class="search-wrap">
            
        </div>
        <div class="result-wrap">
            <form action="" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_discussadd.jsp"><i class="icon-font"></i>新增话题</a>     
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                   
                        <tr>
                            <th>ID</th>
                            <th>话题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th>发布人</th>
                            <th>发布时间</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="d" items="${discusslist}">
                         
                        <tr>
                        	
                            <td>${d.discuss_id}</td>
                            <td>${d.discuss_content}</td>
                            <td>${d.discuss_u_id}</td>
                            <td>${d.discuss_time}</td>
                            <td>
                            <a class="link-update" href="admin_tocdiscuss?pid=${d.discuss_id }">查看</a>
                             <a class="link-del" href="javascript:discussdel(${d.discuss_id })" >删除</a>
							</td>
                        </tr>
                       
                          
                     </c:forEach>
                     </table>
   							<script>
   							function discussdel(id) {
                        		if(confirm("你确定要删除这个话题吗？")) {
                        			location.href="admin_dodiscussdel?id="+id;
                        			
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