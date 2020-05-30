<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<script charset="gb2312" language="javascript" type="text/javascript" src="ntkoocx.js"></script>
<head>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<script type="text/javascript">
	$(function() {
		//显示当前导航
		$("#left-nav").find("a").eq(1).addClass("active");
	});
</script>
</head>

<body>
	<%@ include file="/WEB-INF/jsp/public/head.jspf"%>
	<div class="container ">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="/WEB-INF/jsp/public/left-nav.jspf"%>
			</div>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">密码修改</div>
					<div class="panel-body">


						<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<form id='myform' class="form-horizontal" action="userServlet?method=updatePwd" method="post">
									<div class="form-group">
										<label for="oldPassword" class="col-sm-2 control-label"
											required="required">原来的密码</label>
										<div class="col-sm-10">
											<input type="password" name="oldPassword"
												class="form-control" id="oldPassword" required="required"
												placeholder="Password">
										</div>
									</div>
									<div class="form-group">
										<label for="pwd1" class="col-sm-2 control-label">新的密码</label>
										<div class="col-sm-10">
											<input type="password" name="pwd1" class="form-control"
												required="required" id="pwd1"
												placeholder="Password">
										</div>
									</div>
									<div class="form-group">
										<label for="pwd2" class="col-sm-2 control-label">确认新密码</label>
										<div class="col-sm-10">
											<input type="password" name='pwd2' class="form-control"
												required="required" id="pwd2"
												placeholder="Password">
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<input type="submit" class="btn btn-primary" value="提交"/>
										</div>
									</div>
								</form>

								<center><label><font color="red">
									<%
										if(request.getAttribute("message")!= null){
											out.print(request.getAttribute("message"));
										}
									%></font></label>
								</center>

							</div>
							<div class="col-md-2"></div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/public/foot.jspf"%>
</body>



</html>

