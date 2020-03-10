//通过商品类型，获取商品信息
function showOneCommo() {
	$.ajax({
		url: "../controller/commo/showOneCommo",
		type: "POST",
		//async:false,
		data: {
			c_id: $("#c_id").val(),
		},
		dataType: "json",
		success: function(data) {
			//alert(data.obj1.obj1[0].c_name);
			var context="";
			var simpleData = data.obj1;
			var pageNow = data.pageNow;
			var pageCount = data.pageCount;
			var pageN = data.pageSplit;
			//for (let i = 0; i < simpleData.length; i++) {
				
				//商品详情展示		
				context ='<div class="cp-style-2 mt-30">'+
				    '<div class="product-inner-list clearfix">'+
				       '<div class="product-img-list">'+
				            '<a href="#">'+
				                '<div class="product-img b-img">'+
				                    '<img alt="" src="'+simpleData.c_img+'">'+
				                '</div>'+
				            '</a>'+
				            '<span class="product-tag text-uppercase black-bg">new</span>'+
				        '</div>'+
				        '<div class="product-text product-text-list gray-ash-bg">'+
				            '<h5 class="product-name-list">'+
				                '<a title="' + simpleData.c_name + '" href="#"><strong>' + simpleData.c_name + '</strong></a>'+
				            '</h5>'+
				            '<ul class="pull-left list-inline ratings rating-list pb-20">'+
				                '<li><i class="rated fa fa-star"></i></li>'+
				                '<li><i class="rated fa fa-star"></i></li>'+
				                '<li><i class="rated fa fa-star"></i></li>'+
				                '<li><i class="rated fa fa-star"></i></li>'+
				                '<li><i class="rated fa fa-star"></i></li>'+
				                '<li class="reviews text-theme"><span>10</span>Review(s)</li>'+
				            '</ul>'+
				            '<p>' + simpleData.c_show + '</p>'+
				            '<ul class="pricing pricing-list">'+
				                '<li class="text-right c-price text-defualt text-center">￥' + simpleData.c_price + '</li>'+
				            '</ul>'+
				            '<div class="clear"></div>'+
				            '<ul class="quick-veiw-list">'+
				                '<li><a href="javascript:addCart(' + simpleData.c_id + ',' + simpleData.c_price + ')"><i class="fa fa-shopping-cart"></i></a></li>'+
				            '</ul>'+
				        '</div>'+                                             
				    '</div>'+
				'</div>';
				
			//}
			//简单商品展示
			$("#onecommo").html(context);
		}
	});
}

//加载执行
$(function(){
	showOneCommo();
	showCart();

})


//点击添加到购物车，需要一个新的ajax
function addCart(num, session_price) {
	$.ajax({
		url: "../controller/cart/addcart",
		type: "POST",
		async: false,
		data: {
			req: "req",
			c_id: num,
			'cart.sc_id': num,
			'cart.s_num': 1,
			'cart.sesssin_price': session_price,
		},
		dataType: "json",
		success: function(data) {
			alert(data.res);
			showCart();
		}
	})
}
