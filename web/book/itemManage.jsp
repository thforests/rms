
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
	<link rel="stylesheet" href="sources/bootstrap-3.3.4/css/scojs.css" type="text/css"></link>
	<link rel="stylesheet" href="sources/myCss/style.css" type="text/css"></link>
	<script type="text/javascript" src="sources/bootstrap-3.3.4/js/sco.modal.js"></script>
	<script type="text/javascript" src="sources/bootstrap-3.3.4/js/sco.confirm.js"></script>
	<link rel="stylesheet"
		  href="sources/bootstrap-3.3.4/css/webuploader.css" type="text/css">
	<script type="text/javascript" src="sources/webuploader/webuploader.js"></script>
	<link rel="stylesheet" href="sources/webuploader/upload-style.css" type="text/css"></link>
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
				<div class="panel-heading">菜单管理</div>
				<div class="panel-body">
					<table class="table table-hover table-condensed book-manage">
						<tr>
							<td>
								<div class="col-sm-10">
									<input type="text" name="name"
										   class="form-control" id="name" required="required"
										   placeholder="请输入菜单名">
								</div></td>
							<td>
								<div class="col-sm-8"><input type="button" class="btn btn-danger" id="btnSelect"  value="查询"></div>
							</td>

						<tr>
						<tr>
							<td colspan="9">
								<a href="book/bookAdd.jsp" class="btn btn-primary btn-block">
									<i class="glyphicon glyphicon-plus"></i>增加菜单</a>
							</td>
						</tr>
					</table>
					<table class="table table-hover table-bordered table-condensed book-manage">

						<thead>
							<tr>
								<th>编号</th>
								<th>名称</th>
								<th>菜式</th>
								<th>价格(RMB)</th>
								<th>图片</th>
								<th>销量</th>
								<th>库存</th>
								<th>描述</th>
								<th>操作</th>
							</tr>
						</thead>

						<tbody class="trs">

						</tbody>
					</table>

					<script>
						$(function () {
							getAjax();

							$("#btnSelect").click(function () {
								var  name = $("#name").val();
								if(name.toString().trim() !==null){
									//提交到
									$.ajax({
										type:"POST",
										url:"bookServlet?method=selectM",
										data:{"name":name.toString().trim()},
										dataType:"JSON",
										success:function (result) {
											if(result.length>0){
												$(".trs").empty();
												// // getAjax();
												var strs="";
												//解析数据
												$.each(result,function (i,obj) {
													strs="<tr><td>"+obj.id+"</td><td><a href='#'>"+ obj.bookname +" </a></td><td>"+obj.type+"</td><td>"+obj.price+"</td><td>"+obj.picture+"</td><td>"+obj.sale+"</td><td>"+obj.stock+"</td><td>"+obj.description+"</td>" +
															"<td><a href='bookServlet?method=update&name="+obj.bookname+"'>修改</a>|<a href='bookServlet?method=delete&name="+obj.bookname+"'>删除</a></td></tr>";
													$(".trs").append(strs);
												});//理解Java中for循环

											}else {
												window.alert("失败");
											}
											//console.log(result);
										},
										error:function(xth,errorMsg,error){

										}


									});
								}else {
									window.alert("输入框不能为空");
								}
							});

							function getAjax() {
								$.ajax({
									type:"POST",
									url:"bookServlet",
									data:{"method":"select"},
									dataType:"JSON",
									success:function (result) {
										console.log(result);
										if (result != null){
											var strs="";
											$.each(result,function(i,obj){
												console.log(i,obj.id+":"+obj.bookname);
												strs="<tr><td>"+obj.id+"</td><td><a href='#'>"+ obj.bookname +" </a></td><td>"+obj.type+"</td><td>"+obj.price+"</td><td>"+obj.picture+"</td><td>"+obj.sale+"</td><td>"+obj.stock+"</td><td>"+obj.description+"</td>" +
														"<td><a href='bookServlet?method=update&name="+obj.bookname+"'>修改</a>|<a href='bookServlet?method=delete&name="+obj.bookname+"'>删除</a></td></tr>";
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
									href="bookServlet?method=itemManageUI&pageNum=1"> <span
									aria-hidden="true">首页</span> </a>
							</li>

							<li class=" ${page.hasPrev == true?"":"disabled"}"><a
									href="bookServlet?method=itemManageUI&pageNum=${page.prevPage }"
									aria-label="Previous"> <span aria-hidden="true">&laquo;上一页</span>
							</a>
							</li>

							<li class="disabled"><a>第 ${page.pageNo } 页 共
								${page.totalPageNumber } 页</a>
							</li>
							<li class=" ${page.hasNext == true?"":"disabled"}"><a
									href="bookServlet?method=itemManageUI&pageNum=${page.nextPage}"
									aria-label="Next"> <span aria-hidden="true">下一页&raquo;</span>
							</a>
							</li>
							<li class=" ${page.hasNext == true?"":"disabled"}"><a
									href="bookServlet?method=itemManageUI&pageNum=${page.totalPageNumber}">
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
</html>
