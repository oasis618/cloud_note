function checkPwd2(){
		var newPwd = $("#new_password").val().trim();
		var newTPwd = $("#new_tPassword").val().trim();
		if(newTPwd == ""){
			$("#new_tPassword_span").html("");
			$("#new_tPassword_span").html("密码不能为空");
			return;
		}else{
			$("#new_tPassword_span").html("");
		}
		if(newTPwd.length < 6){
			$("#new_tPassword_span").html("");
			$("#new_tPassword_span").html("长度小于6位");
			return;
		}else{
			$("#new_tPassword_span").html("");
		}
		if(newPwd != newTPwd){
			$("#new_tPassword_span").html("");
			$("#new_tPassword_span").html("密码输入不一致");
			return;
		}else{
			$("#new_tPassword_span").html("");
		}
	}
function checkPwd1(){
		var lastPwd = $("#last_password").val().trim();	
		var newPwd = $("#new_password").val().trim();
		if(newPwd == ""){
			$("#new_password_span").html("");
			$("#new_password_span").html("新密码不能为空");
			return;
		}else{
			$("#new_password_span").html("");
		}
		if(newPwd.length < 6){
			$("#new_password_span").html("");
			$("#new_password_span").html("长度小于6位");
			return;
		}else{
			$("#new_password_span").html("");
		}
		if(lastPwd == newPwd){
			$("#new_password_span").html("");
			$("#new_password_span").html("新旧密码重复");
			return;
		}else{
			$("#new_password_span").html("");
		}
	}
function checkPwd(){
	var lastPwd = $("#last_password").val().trim();	
	var userId = getCookie("userId");
	if(lastPwd == ""){
		$("#last_password_span").html("");
		$("#last_password_span").html("密码不能为空");
		return;
	}else{
		$("#last_password_span").html("");
	}
	if(userId == null){
		window.location.href="log_in.html";
	}
		$.ajax({
			url:path+"/change/check.do",
			type:"post",
			data:{"userId":userId,"lastPwd":lastPwd},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					$("#last_password_span").html(result.msg);
				}else{
					$("#last_password_span").html(result.msg);
				}
			},
			error:function(){
				alert("修改密码失败error");
				}
		});
	}