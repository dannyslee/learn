//获取验证码信息
function changeLogPic() {
	src = '../controller/user/getpic?a=' + Math.random();
	$("#imgPic").prop("src", src);
}

//获取登录信息
function sendLoginMes() {
	$.ajax({
		url: "../controller/user/login",
		type: "POST",
		data: {
			req: "req",
			resp: "resp",
			user: $("#user").val(),
			password: $("#pass").val(),
			loginCode: $("#logPic").val()
		},
		dateType: "json",
		success: function(data) {
			alert(data.res);
			if(data.res.indexOf("成功")!=-1){
				window.location.href = "index.jsp";
			}
		}
	})
}

//重复密码检查
function checkPass() {
	var a = $("#rpass").val();
	var b = $("#rcpass").val();
	if (a != b) {
		$("#mes").html("两次密码不同")
	}
}

//提交注册
function sendRegiterMes() {
	$.ajax({
		url: "../controller/user/register",
		type: "POST",
		data: {
			req: "req",
			resp: "resp",
			user: $("#ruser").val(),
			password: $("#rpass").val()
		},
		dataType: "json",
		success: function(data) {
			alert(data.res)
		}
	})
}

$(function(){
	changeLogPic();
})