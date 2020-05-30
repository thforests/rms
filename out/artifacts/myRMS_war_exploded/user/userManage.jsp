<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link rel="stylesheet" href="sources/bootstrap-3.3.4/css/scojs.css" type="text/css"></link>
<link rel="stylesheet" href="sources/myCss/style.css" type="text/css"></link>
<script type="text/javascript" src="sources/bootstrap-3.3.4/js/sco.modal.js"></script>
<script type="text/javascript" src="sources/bootstrap-3.3.4/js/sco.confirm.js"></script>

<script type="text/javascript">
	$(function() {
		//显示当前导航
		$("#left-nav").find("a").eq(2).addClass("active");


		//初始化密码操作
		$(".for-password-button").click(function(){
			var $tr = $(this).parent().parent();
			id =   $tr.find(":hidden").val();
			$.post("userServlet?method=forPassword",{id:id},function(data){
			if(data == '1'){
				alert('初始化密码成功（12345）');
			}
			});
		});
		
	});
	
	function confirmDel(str) {
		return confirm(str);
	}
</script>

</head>

<body>
	<%@ include file="/WEB-INF/jsp/public/head.jspf"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="/WEB-INF/jsp/public/left-nav.jspf"%>
			</div>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">账户管理</div>
					<div class="panel-body">
						<table class="table table-hover table-condensed book-manage">
							<tr>
								<td colspan="9">
									<a href="user/addNewUser.jsp" class="btn btn-primary btn-block">
										<i class="glyphicon glyphicon-plus"></i>添加帐号</a>
								</td>
							</tr>
						</table>
						<table
							class="table table-hover table-bordered table-condensed book-manage">

							<thead>
								<tr>
									<th>帐号</th>
									<th>姓名</th>
									<th>密码</th>
									<th>职位</th>
									<th>联系方式</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody class="trs">

							</tbody>
						</table>

						<script>
							$(function () {
								getAjax();
								function getAjax() {
									$.ajax({
										type:"POST",
										url:"userServlet",
										data:{"method":"select"},
										dataType:"JSON",
										success:function (result) {
											console.log(result);
											if (result != null){
												var strs="";
												$.each(result,function(i,obj){
													console.log(i,obj.id+":"+obj.name);
													strs="<tr><td>"+obj.id+"</td><td><a href='#'>"+ obj.name +" </a></td><td>"+obj.password+"</td><td>"+obj.type+"</td><td>"+obj.tell+"</td><td><a href='userServlet?method=update&uid="+obj.id+"'>修改</a>|<a href='userServlet?method=delete&uid="+obj.id+"'>删除</a></td></tr>";
													$(".trs").append(strs);
												})
											}
										},
										error:function (xth,errorMsg,error) {

										}
									})
								}
							});
						</script>


						<nav class="text-center">
							<ul class="pagination">
								<li class=" ${page.hasPrev == true?"":"disabled"}"><a
									href="userServlet?method=toUserManageUI&pageNum=1"> <span
										aria-hidden="true">首页</span> </a>
								</li>

								<li class=" ${page.hasPrev == true?"":"disabled"}"><a
									href="userServlet?method=toUserManageUI&pageNum=${page.prevPage }"
									aria-label="Previous"> <span aria-hidden="true">&laquo;上一页</span>
								</a>
								</li>

								<li class="disabled"><a>第 ${page.pageNo } 页 共
										${page.totalPageNumber } 页</a>
								</li>
								<li class=" ${page.hasNext == true?"":"disabled"}"><a
									href="userServlet?method=toUserManageUI&pageNum=${page.nextPage}"
									aria-label="Next"> <span aria-hidden="true">下一页&raquo;</span>
								</a>
								</li>
								<li class=" ${page.hasNext == true?"":"disabled"}"><a
									href="userServlet?method=toUserManageUI&pageNum=${page.totalPageNumber}">
										<span aria-hidden="true">末页</span> </a>
								</li>
							</ul>
						</nav>


					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<%@ include file="/WEB-INF/jsp/public/foot.jspf"%>
</body>
<script type="text/javascript">

</script>
</html>

