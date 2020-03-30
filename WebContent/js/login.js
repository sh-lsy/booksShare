var inputs=document.getElementsByClassName('messages');
		let arr=['请输入用户名:','请输入姓名:','请输入出生日期:','请输入邮箱:','请输入手机号:','您的身份是:'];
		for(let i=0;i<inputs.length;i++){
			inputs[i].value=arr[i]
			inputs[i].style.color='#999'
			inputs[i].addEventListener('focus',function(){
				if(this.value==arr[i]){
					this.value='';
					this.style.color='#424242';
					}
			})
			inputs[i].addEventListener('blur',function(){
				if(this.value==''){
					this.value=arr[i]
					this.style.color='#999';
					}
			})
		}

function change(img){
	img.src="getcode?"+new Date().getTime();
}

$(document).ready(function() {
	$('#userName').blur(function() {
		if ($('#userName').val().length <3||$('#userName').val().length >12) {
			$('#user-s').text('用户名3-12位');
			$("#user-s").removeClass("right"); 
			$("#user-s").addClass("error"); 
			$('#user-s').show()
    }else{
    		$.ajax({
    			type:"post",
    			url:"servletJqAjax",
    			data:{"userName":$("#userName").val()},
    			dataType:"text",
    			success:function(data){
    				if(data=="用户名已被注册"){
    					$("#user-s").html(data);
    					$("#user-s").removeClass("right"); 
    					$("#user-s").addClass("error"); 
    	    			$("#user-s").show()
    				}else{
    					$("#user-s").html(data);
    					$("#user-s").removeClass("error"); 
    					$("#user-s").addClass("right"); 
    	    			$("#user-s").show()
    				}
    			
    			}	
    		})
    }	
  });
  $('#name').blur(function() {
		if ($('#name').val().length <2) {
      $('#user-n').text('请输入正确姓名');
      $("#user-n").addClass("error"); 
      $('#user-n').show()
			return false;
    }else{
    	$("#user-n").removeClass("error"); 
    	$('#user-n').hide()
    }	
  });
  $('#password').blur(function() {
		if ($('#password').val().length <6) {
      $('#user-p').text('密码不能少于6位');
      $("#user-p").addClass("error"); 
      $('#user-p').show()
			return false;
    }else{
    	$("#user-p").removeClass("error"); 
    	$('#user-p').hide()
    }	
  });
  $('#rePassword').blur(function() {
    
		if ($('#rePassword').val() != $('#password').val()) {
      $('#user-rp').text('两次密码不一致');
      $("#user-rp").addClass("error"); 
      $('#user-rp').show()
			return false;
    }else{
    	$("#user-rp").removeClass("error"); 
    	$('#user-rp').hide();
    }	
  });
  var reg = /^[A-Za-z0-9]+([_\.][A-Za-z0-9]+)*@([A-Za-z0-9\-]+\.)+[A-Za-z]{2,6}$/;
  $('#email').blur(function() {
    
		if (!reg.test($('#email').val())) {
      $('#user-e').text('亲，邮箱格式有误');
      $("#user-e").addClass("error"); 
      $('#user-e').show()
			return false;
    }else{
    	$("#user-e").removeClass("error"); 
    	$('#user-e').hide();
    }	
  });
  var sqq = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
  $('#mobil').blur(function() {
		if (!sqq.test($('#mobil').val())) {
      $('#user-m').text('请输入正确的手机号码');
      $("#user-m").addClass("error"); 
      $('#user-m').show()
			return false;
    }else{
    	$("#user-m").removeClass("error"); 
    	$('#user-m').hide();
    }	
	});
  $('#veryCode').blur(function() {
		if ($('#veryCode').val()=="") {
			$('#user-v').text('验证码不能为空');
			$("#user-v").removeClass("right"); 
			$("#user-v").addClass("error"); 
			$("#user-v").show()
			return false;
  }else{
		$.ajax({
			type:"post",
			url:"servletnum",
			data:{"veryCode":$("#veryCode").val()},
			dataType:"text",
			success:function(data){
				if(data=="验证码错误"){
					$("#user-v").html(data);
					$("#user-v").removeClass("right"); 
					$("#user-v").addClass("error"); 
	    			$("#user-v").show()
				}else{
					$("#user-v").html(data);
					$("#user-v").removeClass("error"); 
					$("#user-v").addClass("right"); 
	    			$("#user-v").show()
				}
			
			}	
		})
  }	
	});

});
 function submitcheck(){
	 
	 let numr=document.getElementsByClassName('right');
	 if(numr.length==2 && $("#password").val() !=""&&  $("#rePassword").val() !=""){
		 return true;		 
	 }else{
		 alert('请输入完整信息')
		 return false
	 }
 }	