//展示购物车
function showCart() {
	$.ajax({
		url: "../controller/cart/showcart",
		type: "POST",
		dataType: "json",
		success: function(data) {
			var simpledata = data.obj1;
			var context = "";
			var totalprice = 0;
			for (var i = 0; i < simpledata.length; i++) {
				context += '<li class="media">' +
					'<a href="#"><img alt="" src="'+simpledata[i].c_cartimg+'" ></a>' +
					'<div class="cart-item-wrapper">' +
					'<a href="#">' + simpledata[i].c_name + '</a>' +
					'<br/>'+
					'<span class="quantity">' +
					'<span class="amount">￥' + simpledata[i].c_price + '</span>' +
					' x <span class="amount">' + simpledata[i].s_num + '</span>'+
					'</span>' +
					'<a title="Remove this item" class="remove" href="javascript:deleteCart(' + simpledata[i].s_id + ',' +
					simpledata[i].sc_id + ')">' +
					'<i class="fa fa-trash-o"></i>' +
					'</a>' +
					'</div>' +
					'</li>';
					
					totalprice+=simpledata[i].c_price*simpledata[i].s_num;

					
			}
			$("#showcart").html(context);
			$("#totalprice").html(totalprice);
		}
	})
}

//自动加载
$(function() {
	showCart();
})

//删除购物车
function deleteCart(sid, cid) {
	$.ajax({
		url: "../controller/cart/removecart",
		type: "POST",
		data: {
			s_id: sid,
			sc_id: cid,
		},
		success: function() {
			showCart();
		}
	})
}
