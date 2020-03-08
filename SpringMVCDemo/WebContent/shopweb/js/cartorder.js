//展示购物车信息

function showCartToOrder() {
	$.ajax({
		url: "../controller/cart/showcart",
		type: "POST",
		dataType: "json",
		success: function(data) {
			var simpledata = data.obj1;
			var context = "";
			var totalprice = 0;
			for (var i = 0; i < simpledata.length; i++) {

				context += '<div class="product-container cp-style-2">' +
					'<div class="product-inner">' +
					'<a href="#">' +
					'<div class="product-img b-img">' +
					'<img alt="" src="' + simpledata[i].c_img + '">' +
					'</div>' +
					'</a>' +
					'<ul class="quick-veiw text-center">' +
					'<li><a href="#"><i class="fa">' + simpledata[i].c_price + '</i></a></li>' +
					'<li><a href="#"><i class="fa"></i> x</a></li>' +
					'<li><a href="#"><i class="fa">' + simpledata[i].s_num + '</i></a></li>' +
					'<li><a href="javascript:removeCart('+simpledata[i].s_id+','+simpledata[i].sc_id+')"><i class="fa fa-remove"></i></a></li>' +
					'</ul>' +
					'<div class="product-text pt-15">' +
					'<ul class="pricing list-inline pull-center">' +
					'<li class="text-center"> ' +
					'<input type="text"  onblur="updateCart('+simpledata[i].s_id+','+simpledata[i].s_id+')" id="ccount'+simpledata[i].s_id+'" value="' + simpledata[i].s_num + '" />' +
					'</li>' +
					'</ul>' +
					'<div class="clear"></div>' +
					'</div>' +
					'</div>' +
					'</div>';

				totalprice += simpledata[i].c_price * simpledata[i].s_num;

			}

			$("#carts").html(context);
			$("#subTotal").html("￥" + totalprice);
		}
	})
}

//数量更改
function updateCart(num,cid) {
	var count = '#ccount' + num + '';
	$.ajax({
		url: "../controller/cart/updatecart",
		type: "POST",
		data: {
			req: "req",
			s_id: num,
			sc_id: cid,
			s_num: $(count).val(),
		},
		success: function() {
			showCartToOrder();
		}
	})
}

//物品删除
//删除功能
	function removeCart(sid,cid){
		$.ajax({
			url:"../controller/cart/removecart",
			type:"POST",
			data:{
				s_id:sid,
				sc_id:cid,
			},
			success:function(data){
				showCartToOrder(); 
			}
		})
	}

//加载启动
$(function() {
	showCartToOrder();
})
