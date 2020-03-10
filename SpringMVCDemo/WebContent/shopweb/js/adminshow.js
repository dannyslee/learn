//展示所有商品信息
function showAlltype(){
	$.ajax({
		url:"../controller/type/showType",
		type:"POST",
		dataType:"json",
		success:function(data){
			var simpledata = data.obj1;
			var context="";
			var statusflag="";
			var a = 0;
			for (var i = 0; i < simpledata.length; i++) {
			    a = i+1
				
				context+='<p class="alert">'+
				      '<span id="oid" class="alert">'+a+'</span>  '+
					   '<span id="a class="alert">'+simpledata[i].t_typename+'</span> '+
					   '<span id="a" class="alert">'+simpledata[i].t_typeshow+'</span>  '+
					   '<a class="alert" href="'+simpledata[i].t_img+'">图片路径</a>'+
					   '<a class="alert" href="javascript:deleteType('+simpledata[i].t_id+')">删除</a>'+
					   '<a class="alert" href="javascript:changetype('+simpledata[i].t_id+')">修改</a>'+
					   '<a class="alert" href="javascript:showItemOrder('+simpledata[i].t_id+')">详情</a>'+
				'</p>';
			}
			
			statusflag='<p class="alert">'+'<a class="alert" href="javascript:submitshow()">新增</a>'+'</p>';
			
			$("#showCommo").html(statusflag+context);
			//$("#insert").html(statusflag);
		}
	})
}

//删除类型
function deleteType(tid){
	
	$.ajax({
		url:"../controller/adm/deltype",
		type:"POST",
		data:{
			t_id:tid,
		},
		dataType:"json",
		success:function(data){
			showAlltype();
		}
	})

}

//新增显示
function submitshow(){
	var context="";
	context= '<div class="row">' +
	
					'<div class="col-sm-3">' +
					'<input type="text" id="t_typename" class="text-center" placeholder="名称" value="" >' +
					'</div>' +

					'<div class="col-sm-3 ">' +
					'<input type="text" id="t_typeshow" placeholder="简介" value="">' +
					'</div>' +

					'<div class="col-sm-2">' +
					'<input type="text" id="t_img" value=""  placeholder="图片" disabled>' +
					'</div>' +
					
					'<div class="col-sm-4">' +
					'<p class="alert">'+'<a class="alert" href="javascript:addType()">提交</a>'+'</p>';
					'</div>' +
					
            '</divs>';
	$("#showItem").html(context);
}

//新增类型添加
function addType(){
	$.ajax({
		url:"../controller/adm/inserttype",
		type:"POST",
		data:{
			t_typename:$("#t_typename").val(),
			t_img:"./images/banner/2.jpg",
			t_typeshow:$("#t_typeshow").val(),
			
		},
		dataType:"json",
		success:function(data){
			if(data.flag){
				alert("添加成功");
				showAlltype();
			};
		}
	})
}

//更改展示
function changetype(tid){
	$.ajax({
		url:"../controller/adm/selecttypebytid",
		type:"POST",
		data:{
			t_id:tid,
		},
		dataType:"json",
		success:function(data){
			var context="";
			context= '<div class="row">' +
							'<div class="col-sm-3">' +
							'<input type="text" id="t_typename" class="text-center" placeholder="类型名称" value="'+data.obj1.t_typename+'" >' +
							'</div>' +
			
							'<div class="col-sm-3 ">' +
							'<input type="text" id="t_typeshow" placeholder="类型简介" value="'+data.obj1.t_typeshow+'">' +
							'</div>' +
			
							'<div class="col-sm-2">' +
							'<input type="text" id="t_img" value=""  placeholder="图片" disabled>' +
							'</div>' +
							
							'<div class="col-sm-4">' +
							'<p class="alert">'+'<a class="alert" href="javascript:sumbitUpdate('+data.obj1.t_id+')">提交</a>'+'</p>';
							'</div>' +
							
			        '</divs>';
			
			$("#showItem").html(context);
		}
		
	})
}


//更改执行
function sumbitUpdate(num){
	
	
	$.ajax({
		url:"../controller/adm/updatetype",
		type:"POST",
		data:{
			t_typename:$("#t_typename").val(),
			t_img:"./images/banner/2.jpg",
			t_typeshow:$("#t_typeshow").val(),
			t_id:num
		},
		dataType:"json",
		success:function(data){
			if(data.flag){
				alert("更改成功！")
				showAlltype();
			}
		}
	});
	
}

//返回所有具体商品项
function showItemOrder(num){
	
	$.ajax({
		url:"../controller/commo/showCommoDesc",
		type:"POST",
		data:{
			t_id:num,
			page:1,
		},
		dataType:"json",
		success:function(data){
			var simpledata = data.obj1.obj1;
			var showtitle = "";
			var context="";
			//var subtotal = 0;
			for (var i = 0; i < simpledata.length; i++) {
			    a = i+1
				
				context+='<p class="alert">'+
				      '<span id="oid" class="alert">'+simpledata[i].c_id+'</span>    '+
					   '<span id="odate" class="alert">'+simpledata[i].c_name+'</span>    '+
					   '<a class="alert" href="'+simpledata[i].c_img+'">图片路径</a>'+
					   '<span id="status" class="alert">'+simpledata[i].c_price+'</span>    '+
					   '<span id="status" class="alert">'+simpledata[i].c_stock+'</span>    '+
					   '<a class="alert" href="javascript:updateShowItemCommo('+simpledata[i].c_id+')">更改</a>'+
					   '<a class="alert" href="javascript:deleteCommo('+simpledata[i].c_id+')">删除</a>'+

				'</p>'+
				   '<p class="alert"><span id="status" class="alert">'+simpledata[i].c_show+'</span></p>';
		
				//subtotal = subtotal+simpledata[i].i_price;
			}
			
			showtitle ='<div class="coupon-info">'+
            '<h6 class="procced-title text-uppercase pb-15 mb-20"> 详情列表 </h6> '+
            '<span id="subtotal" class="alert"></span>'+
            '</div>';
			
			statusflag='<p class="alert">'+'<a class="alert" href="javascript:submitInsertCommoShow()">新增</a>'+'</p>';

			
			$("#showItem").html(showtitle+statusflag+context);
			//$("#subtotal").html("<strong>共计 :"+subtotal+"元</strong>")
		}
	})
}
//删除该商品
function deleteCommo(cid){
	$.ajax({
		url:"../controller/adm/delcommo",
		type:"POST",
		data:{
			c_id:cid,
		},
		dataType:"json",
		success:function(data){
			if(data.flag){
				alert("删除成功,点击详情查看!")
				
			}
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


//新增商品项展示

function submitInsertCommoShow(){
			context= '<div class="row">' +
							'<div class="col-sm-2">' +
							'<input type="text" id="c_name" class="text-center" placeholder="名称" value="" >' +
							'</div>' +
			
							'<div class="col-sm-2 ">' +
							'<input type="text" id="c_show" placeholder="简介" value="">' +
							'</div>' +
							
							'<div class="col-sm-2 ">' +
							'<input type="text" id="c_price" placeholder="价格" value="">' +
							'</div>' +
							
							'<div class="col-sm-2 ">' +
							'<input type="text" id="c_stock" placeholder="库存" value="">' +
							'</div>' +
							
							'<div class="col-sm-2 ">' +
							'<input type="text" id="ct_id" placeholder="类型编号" value="">' +
							'</div>' +
			
							'<div class="col-sm-2">' +
							'<input type="text" id="c_img" value="images/product/arrival/1.jpg"  placeholder="图片" disabled>' +
							'</div>' +
							
							'<div class="col-sm-2">' +
							'<p class="alert">'+'<a class="alert" href="javascript:submitInsertCommo()">OK</a>'+'</p>';
							'</div>' +
							
			        '</divs>';
					
					$("#showOneCommo").html(context);
					
	      
}


function submitInsertCommo(){
	$.ajax({
		url:"../controller/adm/insertcommo",
		type:"POST",
		data:{
			c_name:$("#c_name").val(),
			c_img:$("#c_img").val(),
			c_show:$("#c_show").val(),
			c_price:$("#c_price").val(),
			c_stock:$("#c_stock").val(),
			ct_id:$("#ct_id").val(),
		},
		dataType:"json",
		success:function(data){
			if(data.flag){
				alert("插入成功,请重新点击详情,即可查看!")
			}
		}
	})
}

//更改商品项展示
function updateShowItemCommo(cid){
	$.ajax({
		url:"../controller/commo/showOneCommo",
		type:"POST",
		data:{
			c_id:cid,
		},
		dataType:"json",
		success:function(data){
			var context="";
			context= '<div class="row">' +
							'<div class="col-sm-2">' +
							'<input type="text" id="c_name" class="text-center" placeholder="类型名称" value="'+data.obj1.c_name+'" >' +
							'</div>' +
			
							'<div class="col-sm-2 ">' +
							'<input type="text" id="c_show" placeholder="类型简介" value="'+data.obj1.c_show+'">' +
							'</div>' +
							
							'<div class="col-sm-2 ">' +
							'<input type="text" id="c_price" placeholder="类型简介" value="'+data.obj1.c_price+'">' +
							'</div>' +
							
							'<div class="col-sm-2 ">' +
							'<input type="text" id="c_stock" placeholder="类型简介" value="'+data.obj1.c_stock+'">' +
							'</div>' +
			
							'<div class="col-sm-2">' +
							'<input type="text" id="c_img" value="'+data.obj1.c_img+'"  placeholder="图片" disabled>' +
							'</div>' +
							
							'<div class="col-sm-2">' +
							'<p class="alert">'+'<a class="alert" href="javascript:sumbitUpdateItemCommo('+data.obj1.c_id+')">OK</a>'+'</p>';
							'</div>' +
							
			        '</divs>';
							
			
			$("#showOneCommo").html(context);
		}
		
	})
}

//更改商品项执行
function sumbitUpdateItemCommo(cid){
	$.ajax({
		url:"../controller/adm/updatecommo",
		type:"POST",
		data:{
			c_name:$("#c_name").val(),
			c_img:$("#c_img").val(),
			c_show:$("#c_show").val(),
			c_price:$("#c_price").val(),
			c_stock:$("#c_stock").val(),
			c_id:cid,
		},
		dataType:"json",
		success:function(data){
			if(data.flag){
				alert("更新成功，重新点击详情，即可查看！")
			}
		}
		
	})
}

//加载自启
$(function(){
	showAlltype();
})



	// context += '<div class="row">' +
				// 	'<div class="col-sm-1">' +
				// 	'<input type="text" id="c_id" class="text-center" value="'+simpledata[i].c_id+'" disabled>' +
				// 	'</div>' +

				// 	'<div class="col-sm-2 ">' +
				// 	'<input type="text" id="c_name" value="'+simpledata[i].c_name+'" disabled>' +
				// 	'</div>' +

				// 	'<div class="col-sm-2">' +
				// 	'<input type="text" id="c_show" value="'+simpledata[i].c_show+'" disabled>' +
				// 	'</div>' +

				// 	'<div class="col-sm-1">' +
				// 	'<input type="text" id="c_price" value="'+simpledata[i].c_price+'" disabled>' +
				// 	'</div>' +

				// 	'<div class="col-sm-1">' +
				// 	'<input type="text" id="c_stock" value="'+simpledata[i].c_stock+'" disabled>' +
				// 	'</div>' +

				// 	'<div class="col-sm-2">' +
				// 	'<input type="file" placeholder="图片上传" id="c_img" disabled>' +
				// 	'</div>' +

				// 	'<div class="col-sm-1">' +
				// 	'<select class="custom-select" id="ct_id" disabled>' +
				// 	'<option value="1">男性</option>' +
				// 	'<option value="2">女性</option>' +
				// 	'<option value="3">鞋子</option>' +
				// 	'<option value="4">包</option>' +
				// 	'<option value="5">童装</option>' +
				// 	'</select>' +
				// 	'</div>' +

				// 	'<div class="col-sm-1">' +
				// 	'<button class="btn-default" type="button" id="choose">选中</button>' +
				// 	'</div>' +
					
				// '<div class="col-sm-1">' +
				// '<button class="btn-default" type="button" id="sub" disabled>提交更改</button>' +
				// '</div>' +

				// '<div class="col-sm-1">' +
				// '<button class="btn btn-danger" type="button" id="del" disabled>删除</button>' +
				// '</div>' +

				// '</div>' +
				// '<br>';