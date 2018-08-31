$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 输入框获取焦点后出现下划线
	$('.form-control').focus(function() {
		$(this).parent().addClass('fg-toggled');
	}).blur(function() {
		$(this).parent().removeClass('fg-toggled');
	});
});
Checkbix.init();
$(function() {
	// 点击登录按钮
	$('#login-bt').click(function() {
		login();
	});
	// 回车事件
	$('#user_account, #user_password').keypress(function (event) {
		if (13 == event.keyCode) {
			login();
		}
	});
});
// 登录
function login() {
		var user = {};
		user.user_account = $("#user_account").val();
		user.user_password = $("#user_password").val();
		$.ajax({
			type : "POST",
			url : "/hrms/user/login",
			async : true,
			contentType : "application/json",
			data : JSON.stringify(user),
			success : function(result) {
				console.log(result);
				if (result["msg"] == "登陆成功") {
									alert("登录成功");
									$(location).attr('href','http://localhost:8080/hrms/static/index.html');
						}else{
										alert("登录失败");}
					
				}
			
		});
}
	
	
	
