<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/booksShare/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/booksShare/manage/admin_cateselect">评论管理</a><span class="crumb-step">&gt;</span><span>新增话题</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/booksShare/manage/admin_dodiscussadd" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                    
                    
                        <tbody>
                            
                            <tr>
                                <th><i class="require-red">*</i>话题内容：</th>
                                <td>
                                	<input type="hidden" value="${name.user_id}" name="u_id">
                                	<input type="hidden" value="${name.user_name}" name="u_name">
                                	<input type="hidden" value="" name="time" id="time">
                                	<textarea style="width:300px;height:100px;" name="cvalue"></textarea>
                                    
                                </td>
                            </tr>
                         
                               	<tr>
                               	<th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit"id="btnclick">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>

   <script>
	var date = new Date();
    var y = date.getFullYear();
    var ms =(date.getMonth() + 1).toString();
    var d = (date.getDate()).toString();
    if (ms.length == 1) {
        ms = "0" + ms;
    }
    if (d.length == 1) {
        d = "0" + d;
    }
    var h = date.getHours();
    var m = date.getMinutes();
    var s = date.getSeconds();
    var time =date.toLocaleString('chinese',{hour12:false});
    
   	var btn=document.getElementById("btnclick");
   	var t=document.getElementById("time");
   	
   	btn.onclick=function(){
   		t.value=time;
   		
   	}
   </script>
</body>
</html>