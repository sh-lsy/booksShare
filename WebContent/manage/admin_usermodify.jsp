<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/booksShare/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="/booksShare/manage/admin_douserselect">用户管理</a>
            <span class="crumb-step">&gt;</span><span>修改用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/booksShare/manage/admin_douserupdate" method="post" id="myform" name="myform">
                <!--  设置隐藏 ，获取value值 -->
                <input type="hidden" name="userStatus" value="${user.user_status }">
                	<input type="hidden" name="cpage" value="${cpage }">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="userName" size="50" value="${user.user_id}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>用户姓名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="${user.user_name}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>登录密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="password" size="50" value="${user.user_password}" type="text">
                                </td>
                            </tr>
  
                            <tr>
                                <th>性别：</th>
                                <td>
                                    <input type="radio" name="sex" value="T" ${user.user_sex =='T'?"checked":"" }>男
                                    <input type="radio" name="sex" value="F" ${user.user_sex =='F'?"checked":"" }>女
                                </td>
                            </tr>
                            <tr>
                                <th>出生日期：</th>
                                <td><input class="common-text" name="birthday" size="50" value="${user.user_birthday}" type="text"></td>
                            </tr>
                            	 <tr>
                                <th><i class="require-red">*</i>Email：</th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="${user.user_email}" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>手机号码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" size="50" value="${user.user_mobile}" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>身份：</th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="${user.user_address}" type="text">
                                </td>
                            </tr>
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
    <!--/main-->
</div>
</body>
</html>