<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="../../js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			// ajax 方法 获取到相关的数据
			function showAllType() {
				$.ajax({
					url: "../../controller/type/showType",
					dataType: "json",
					success: function(data) {
						//alert(data[0].t_typename);
						var context = "";
						for (var i = 0; i < data.length; i++) {
							context += '<li>'
							           +'<a href="paging.jsp?t_id='+data[i].t_id+'">'
							           +'<div>'
							           +'<img src="'+data[i].t_img+'">'
							           +'</div>'
							           +'<div>'
							           +'<h3>'+data[i].t_typename+'</h3>'
							           +'<p>'+data[i].t_typeshow+'</p>'
							           +'</div>'
							           +'</a>'
							           +'</li>';
						}
						$("#showAllType").html(context);
				 	}
				 })
			}
			// 然后使用页面加载函数，加载ajax内容
			$(function(){
				showAllType();
			})
		</script>
	</head>
	<body>
		<div id="showAllType">
			<!-- 插入展示页 -->
		</div>
	</body>
</html>
