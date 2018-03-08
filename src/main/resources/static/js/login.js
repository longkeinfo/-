function login(){
	if ($("#username").val() == null || $("#username").val() == ''){
		$("#msg").html("请输入登录用户名");
		$("#username").focus();
		return;
	}

	if ($("#password").val() == null || $("#password").val() == ''){
		$("#msg").html("请输入登录密码");
		$("#password").focus();
		return;
	}

	$("#msg").html("");

	$.ajax({
		type : "POST",
		url : "/api/post/home/login",
		cache : false,  //禁用缓存
		data : {
			username : $("#username").val(),
			password : $("#password").val()
		},    //传入已封装的参数
		dataType : "json",
		success : function(result) {
			if (result == null){
				$("#msg").html("登录失败，请联系管理员！！！");
				return;
			}
			if (result.code == '00000'){
				console.info(result);
				window.location.replace(result.msg);
			} else {
				$("#msg").html(result.msg);
			}
		},
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	$("#msg").html("登录失败，请联系管理员！！！");
        }
	});
}