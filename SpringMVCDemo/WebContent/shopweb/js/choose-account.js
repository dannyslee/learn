// 身份选择

function chooseAccount(){
	$.ajax({
		uri:"../controller/user/chooseAccount",
		type:"POST",
	})
}