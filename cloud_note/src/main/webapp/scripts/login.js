$(function(){
	$("#regist_username").blur(function(){
		var name=$("#regist_username").val().trim();
		if(name==""){
			$("#warning_1 span").html("用户名不能为空");
			$("#warning_1").show();
		}else{
			$("#warning_1").hide();
		}
	});
	$("#regist_username").focus(function(){
			$("#warning_1").hide();
	});
	$("#regist_password").blur(function(){
		var password=$("#regist_password").val().trim();
		if(password==""){
			$("#warning_2 span").html("密码不能为空");
			$("#warning_2").show();
		}else if(password.length>0&&password.length<6){
			$("#warning_2 span").html("密码不能小于6位");
			$("#warning_2").show();
		}else{
			$("#warning_2").hide();
		}
	});
	$("#final_password").blur(function(){
		var password=$("#regist_password").val().trim();
		var final_password=$("#final_password").val().trim();
		if(password!=final_password){
			$("#warning_3 span").html("密码输入不一致");
			$("#warning_3").show();
		}else{
			$("#warning_3").hide();
		}
	});
	
	$("#count").blur(function(){
		var name=$("#count").val().trim();
		if(name==""){
			$("#count_span").html("用户名不能为空");
		}else{
			$("#count_span").empty();
		}
	});
	$("#password").blur(function(){
		var name=$("#password").val().trim();
		if(name==""){
			$("#password_span").html("密码不能为空");
		}else{
			$("#password_span").empty();
		}
	});
})
function userRegist(){
			var name=$("#regist_username").val().trim();
			var nickname=$("#nickname").val().trim();
			var password=$("#regist_password").val().trim();
			var final_password=$("#final_password").val().trim();
			/* alert(name+","+nickname+","+password+","+final_password); */
			var ok=true;
			if(name==""){
				$("#warning_1 span").html("用户名不能为空");
				$("#warning_1").show();
				ok=false;
			}
			//检测密码:非空;不能小于6位
			if(password==""){
				$("#warning_2 span").html("密码不能为空");
				$("#warning_2").show();
				ok=false;
			}else if(password.length>0&&password.length<6){
				$("#warning_2 span").html("密码不能小于6位");
				$("#warning_2").show();
				ok=false;
			} 
			//检测确认密码:非空;是否与密码一致
			if(password!=final_password){
				ok=false;
				$("#warning_3 span").html("密码输入不一致");
				$("#warning_3").show();
			}
			//数据校验通过
			if(ok){
				$.ajax({
					url:path+"/user/add.do",
					type:"post",
					data:{"name":name,"nickname":nickname,"password":password},
					dataType:"json",
					success:function(result){
						if(result.status==0){
							alert(result.msg);
							//返回到登录页面
							$('#back').click();
						}else if(result.status==1){
							alert(result.msg);
							$("#warning_1 span").html(result.msg);
							$("#warning_1").show();
						}
					},
					error:function(){
						alert("error注册失败!");
					}
				})
			}}
function userLogin(){
			//测试绑定事件
			//alert("123");
			//获取参数
			var name=$("#count").val().trim();
			var password=$("#password").val().trim();
			//alert(name);
			//格式检测
			var ok=true;
			if(name==""){
				$("#count_span").html("用户名不能为空");
				ok=false;
			}
			if(password==""){
				$("#password_span").html("密码不能为空");
				ok=false;
			}else{
				$("#password_span").empty();
			}
			if(ok){
				$.ajax({
					"url":path+"/user/login.do",
					"type":"post",
					"data":{"name":name,"password":password},
					"dataType":"json",
					"success":function(result){
						//result是服务器返回的json结果
						if(result.status==0){
							//将用户信息保存到Cookie
							var userId=result.data.cn_user_id;
							addCookie("userId",userId,2);
							window.location.href="edit.html";
						}else if(result.status==1){
							$("#count_span").html(result.msg);
						}else if(result.status==2){
							$("#password_span").html(result.msg);
							
						}
						},
					//异常情况下走error,并不是result返回null时执行
					"error":function(){
						alert("登录失败!");
					}
				});
			}
		}