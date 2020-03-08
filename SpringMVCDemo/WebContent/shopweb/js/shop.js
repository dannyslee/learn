//通过商品类型，获取商品信息
function showCommoBytid(page) {
	$.ajax({
		url: "../controller/commo/showCommo",
		type: "POST",
		//async:false,
		data: {
			t_id: $("#t_id").val(),
			page: page,
		},
		dataType: "json",
		success: function(data) {
			//alert(data.obj1.obj1[0].c_name);
			var simpleContext = "";
			var context="";
			var simpleData = data.obj1.obj1;
			var pageNow = data.pageNow;
			var pageCount = data.pageCount;
			var pageN = data.pageSplit;
			for (let i = 0; i < simpleData.length; i++) {
				
				//商品简单展示
				simpleContext +='<div class="product-inner cp-style-2 mt-30 col-2">'+
				    '<a href="http://localhost:8080/SpringMVCDemo/shopweb/shopone.jsp?c_id='+simpleData[i].c_id+'">'+
				        '<div class="product-img b-img">'+
				            '<img alt="" src="'+simpleData[i].c_img+'">'+
				        '</div>'+
				    '</a>'+
				    '<span class="product-tag text-uppercase black-bg">new</span>'+
				   '<ul class="quick-veiw text-center">'+
				        '<li><a href="javascript:addCart(' + simpleData[i].c_id + ',' + simpleData[i].c_price + ')"><i class="fa fa-shopping-cart"></i></a></li>'+
						'<li><a href="http://localhost:8080/SpringMVCDemo/shopweb/shopone.jsp?c_id='+simpleData[i].c_id+'"><i class="fa fa-eye"></i></a></li>'+
				   '</ul>'+
				    '<div class="product-text pt-10">'+
				        '<ul class="pull-left list-inline ratings">'+
				            '<li><i class="rated fa fa-star"></i></li>'+
				           '<li><i class="rated fa fa-star"></i></li>'+
				            '<li><i class="rated fa fa-star"></i></li>'+
				            '<li><i class="rated fa fa-star"></i></li>'+
				            '<li><i class="rated fa fa-star"></i></li>'+
				        '</ul>'+
				        '<ul class="pricing list-inline pull-right">'+
				            '<li class="text-right c-price">￥' + simpleData[i].c_price + '</li>'+
				        '</ul>'+
				        '<div class="clear"></div>'+
				        '<h6 class="product-name m-0">'+
				            '<a title="' + simpleData[i].c_name + '" href="#">' + simpleData[i].c_name + '</a>'+
				        '</h6>'+
				    '</div>'+
				    '</div>';
				
			}
			//简单商品展示
			$("#simplecommo").html(simpleContext);
			//商品详情展示
			//$("#commo").html(context);
			//总页数
			$("#pageN").html(pageN);
			//当前页数
			$("#pageNow").html(pageNow);
		}
	});
}

//点击查看详情
function showOneCommo(cid){
	window.location.replace("http://localhost:8080/SpringMVCDemo/controller/commo/showOneCommo?c_id="+cid);
}

//在页面打开时执行获取商品信息的操作
$(function() {
	showCommoBytid(1);
})

//点击添加到购物车，需要一个新的ajax
function addCart(num, session_price) {
	$.ajax({
		url: "../controller/cart/addcart",
		type: "POST",
		//async: false,
		data: {
			req: "req",
			c_id: num,
			'cart.sc_id': num,
			'cart.s_num': 1,
			//'cart.s_name':name,
			//'cart.s_img':img.toString(),
			'cart.sesssin_price': session_price,
		},
		dataType: "json",
		success: function(data) {
			alert(data.res);
		}
	})
}

//下一页
function nextPage() {
	var pageNow = parseInt($("#pageNow").html());
	var pageN = parseInt($("#pageN").html());
	if (!(pageNow < 1 || pageNow >= pageN)) {
		showCommoBytid(pageNow + 1);
	}
}
//上一页
function lastPage() {
	var pageNow = parseInt($("#pageNow").html());
	var pageN = parseInt($("#pageN").html());
	if (!(pageNow < 2 || pageNow > pageN)) {
		showCommoBytid(pageNow - 1);
	}
}


