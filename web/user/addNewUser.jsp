<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/29
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
    <script type="text/javascript">
        $(function() {
            //显示当前导航
            $("#left-nav").find("a").eq(2).addClass("active");

            var nowSelect = $("#select-value").val();
            var selectLenth = $("#dish-select option").length;
            var $select = $("#dish-select");
            for ( var i = 0; i < selectLenth; i++) {

                if ($select.find("option").eq(i).val() == nowSelect) {
                    $select.find("option").eq(i).attr("selected", true);
                    break;
                }
            }

        });

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
                <div class="panel-heading">修改账户</div>
                <div class="panel-body">
                    <form id='rform' class="form-horizontal" >
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" name="name" id="name" class="form-control" id="inputEmail3" placeholder="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="text" name="password" id="password" class="form-control" id="inputEmail3" placeholder="password">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">类型</label>
                            <div class="col-sm-10">
                                <input type="text" id="type" name="type" class="form-control" placeholder="type">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">联系方式</label>
                            <div class="col-sm-10">
                                <input type="text" id="tell" name="tell" class="form-control" id="inputEmail3" placeholder="tell">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="button" id="btn" class="btn btn-primary" value="提交"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/public/foot.jspf"%>
</body>
<script type="text/javascript">
    $(function () {
        $("#btn").click(function () {
            var userName = $("#name").val().toString().trim();
            if (userName != ""){
                $.ajax({
                    type:"POST",
                    url:"userServlet?method=addUser",
                    data:$("#rform").serialize(),
                    dataType:"JSON",
                    success:function (result) {
                        if (result.msg) {
                            window.alert("添加成功");
                            window.location.href="user/userManage.jsp"
                        }else {
                            window.alert("添加失败");
                        }
                    },
                    error:function (xth,errorMsg,error) {

                    }
                })
            }else {
                window.alert("输入框不能为空！");
            }
        })
    })
</script>
</html>

