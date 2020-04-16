<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/booksShare/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/booksShare/manage/admin_booksselect">图书管理</a><span class="crumb-step">&gt;</span><span>新增图书</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/booksShare/manage/admin_dobooksadd" method="post" enctype="multipart/form-data" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                         <tbody>
                          <tr>
                                <th><i class="require-red">*</i>图书名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="booksName" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>图书分类：</th>
                                <td>
                                    <select class="common-text required"  name="parentId">
                                    	
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
                                <th><i class="require-red">*</i>图书图片1：</th>
                                <td>
                                    <input class="common-text required" id="title" name="photo1" size="50" value="" type="file">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>图书图片2：</th>
                                <td>
                                    <input class="common-text required" id="title" name="photo2" size="50" value="" type="file">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>图书图片3：</th>
                                <td>
                                    <input class="common-text required" id="title" name="photo3" size="50" value="" type="file">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>图书拥有者：</th>
                                <td>
                                    <input class="common-text required" id="title" name="booksUser" size="50" value="" type="text">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>图书介绍：</th>
                                <td>
                                    <input class="common-text required" id="title" name="booksDesc" size="50" value="" type="text">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>图书库存：</th>
                                <td>
                                    <input class="common-text required" id="title" name="booksStock" size="50" value="" type="text">
                                </td>
                            </tr>
                         
                               	<tr>
                               	<th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>

</body>
</html>