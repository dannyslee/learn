// ajax 方法 获取到相关的数据
// ajax 方法 获取到相关的数据
function showAllType() {
	$.ajax({
		url: "../controller/type/showType",
		dataType: "json",
		success: function(data) {
			//alert(data.obj1[0].t_typename);	

			var context = "";

			for (var i = 0; i < data.obj1.length; i++) {
				
				switch (i) {
					case 0:
						context += '<div class="col-sm-8 cp-style">' +
							'<div class="banner-inner">' +
							'<a class="test-popup-link banner-img" href="shop.jsp?t_id=' + data.obj1[i].t_id + '">' +
							'<img src="' + data.obj1[i].t_img + '" alt="">' +
							'</a>' +
							'<div class="banner-text banner-text-2 text-center">' +
							'<a href="shop.jsp?t_id=' + data.obj1[i].t_id + '" class="banner-heading text-uppercase text-right">' + data.obj1[i].t_typename + '</a>' +
							'<h3 class="banner-title text-uppercase text-right">' + data.obj1[i].t_typeshow + '</h3>' +
							'</div>' +
							'</div>' +
							'</div>';
						break;
					case 1:
				
						context += '<div class="col-sm-4 cp-style">' +
							'<div class="banner-inner">' +
							'<a class="test-popup-link banner-img" href="shop.jsp?t_id=' + data.obj1[i].t_id + '">' +
							'<img src="' + data.obj1[i].t_img + '" alt="">' +
							'</a>' +
							'<div class="banner-text banner-text-3">' +
							'<a href="shop.jsp?t_id=' + data.obj1[i].t_id + '" class="banner-heading text-uppercase text-right">' + data.obj1[i].t_typename + '</a>' +
							'<h3 class="banner-title text-uppercase text-right">' + data.obj1[i].t_typeshow + '</h3>' +
							'</div>' +
							'</div>' +
							'</div>'+
							 '</div>';
						break;
					case 2:
				
						context +=
						    
						     '<div class="row rp-style mt-8">'+
						     '<div class="col-sm-4 cp-style">' +
							'<div class="banner-inner">' +
							'<a class="test-popup-link banner-img" href="shop.jsp?t_id=' + data.obj1[i].t_id + '">' +
							'<img src="' + data.obj1[i].t_img + '" alt="">' +
							'</a>' +
							'<div class="banner-text banner-text-4 text-right">' +
							'<a href="shop.jsp?t_id=' + data.obj1[i].t_id + '" class="banner-heading text-uppercase text-right">' + data.obj1[i].t_typename + '</a>' +
							'<h3 class="banner-title text-uppercase text-right">' + data.obj1[i].t_typeshow + '</h3>' +
							'</div>' +
							'</div>' +
							'</div>';
						break;
					case 3:
			
						context += '<div class="col-sm-8 cp-style">' +
							'<div class="banner-inner m-0">' +
							'<a class="test-popup-link banner-img" href="shop.jsp?t_id=' + data.obj1[i].t_id + '">' +
							'<img src="' + data.obj1[i].t_img + '" alt="">' +
							'</a>' +
							'<div class="banner-text banner-text-5 text-center">' +
							'<a href="shop.jsp?t_id=' + data.obj1[i].t_id + '" class="banner-heading text-uppercase text-right">' + data.obj1[i].t_typename + '</a>' +
							'<h3 class="banner-title text-uppercase text-right">' + data.obj1[i].t_typeshow + '</h3>' +
							'</div>' +
							'</div>' +
							'</div>'+
							'</div>'+
							'</div>';
						break;
					default:

						break;
				}
			}
			$("#showAllType").html(context);
		}
	})
}
// 然后使用页面加载函数，加载ajax内容
$(function() {
	showAllType();
})
