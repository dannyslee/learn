//展示所有订单
function showOrder(){
	$.ajax({
		url:"../controller/order/showorder",
		type:"POST",
		dataType:"json",
		success:function(data){
			var simpledata = data.obj1;
			var context="";
			var statusflag="";
			var a = 0;
			for (var i = 0; i < simpledata.length; i++) {
			    a = i+1
				switch (simpledata[i].o_status){
					case 0:
					statusflag="未支付";
						break;
					case 1:
					statusflag="已支付";
						break;
					case 2:
					statusflag="已完成";
						break;
					case 3:
					statusflag="退款中";
						break;
					case 4:
					statusflag="已退款";
						break;
					case 5:
					statusflag="已发货";
						break;
					case 6:
					statusflag="已收货";
						break;
					default:
						break;
				}
				
				context+='<p class="alert">'+
				      '<span id="oid" class="alert">'+a+'</span>    '+
					   '<span id="odate" class="alert">'+simpledata[i].o_creattime+'</span>    '+
					   '<span id="status" class="alert">'+statusflag+'</span>    '+
					   '<a class="alert" href="javascript:showItemOrder('+simpledata[i].o_id+')">详情</a>'+
				'</p>';
			}
			
			$("#showOrder").html(context);
		}
	})
}



//返回所有具体订单项
function showItemOrder(num){
	
	$.ajax({
		url:"../controller/order/showitem",
		type:"POST",
		data:{
			o_id:num,
		},
		dataType:"json",
		success:function(data){
			var simpledata = data.obj1;
			var showtitle = "";
			var context="";
			var subtotal = 0;
			for (var i = 0; i < simpledata.length; i++) {
			    a = i+1
				
				context+='<p class="alert">'+
				      '<span id="oid" class="alert">'+a+'</span>    '+
					   '<span id="odate" class="alert">'+simpledata[i].c_name+'</span>    '+
					   '<span id="status" class="alert">'+simpledata[i].i_num+'</span>  x  '+
					   '<span id="status" class="alert">'+simpledata[i].c_price+'</span>  =  '+
					   '<span id="status" class="alert">'+simpledata[i].i_price+'</span>    '+
				'</p>';
				
				subtotal = subtotal+simpledata[i].i_price;
			}
			
			showtitle ='<div class="coupon-info">'+
            '<h6 class="procced-title text-uppercase pb-15 mb-20"> 详情列表 </h6> '+
            '<span id="subtotal" class="alert"></span>'+
            '</div>';
			
			$("#showItem").html(showtitle+context);
			$("#subtotal").html("<strong>共计 :"+subtotal+"元</strong>")
		}
	})
}

//调用加载
$(function(){
	showOrder();
	showCart();

})