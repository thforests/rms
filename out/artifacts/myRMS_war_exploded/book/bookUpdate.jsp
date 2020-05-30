<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf"%>

    <link rel="stylesheet"
          href="sources/bootstrap-3.3.4/css/webuploader.css" type="text/css">
    <script type="text/javascript" src="sources/webuploader/webuploader.js"></script>
    <script type="text/javascript">
        $(function() {
            //显示当前导航
            $("#left-nav").find("a").eq(3).addClass("active");
        });
    </script>
    <link rel="stylesheet" href="sources/webuploader/upload-style.css"
          type="text/css"></link>
</head>

<body>
<%@ include file="/WEB-INF/jsp/public/head.jspf"%>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <ul class="list-group">
                <%@ include file="/WEB-INF/jsp/public/left-nav.jspf"%>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    修改菜单</div>
                <div class="panel-body">
                    <form id="myForm" class="form-horizontal">
                        <input name="id" value="" type="hidden">
                        <input name="pageNum" value="${param.pageNum }" type="hidden">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name"  required="required"
                                       id="name" value="${requestScope.book.bookname}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="type" class="col-sm-2 control-label">所属菜式</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="type"  required="required"
                                       id="type" value="${requestScope.book.type}" />
                            </div>
                        </div>



                        <div class="form-group">
                            <label for="price" class="col-sm-2 control-label">价格</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="price" required="required"
                                       id="price" value="${requestScope.book.price}">
                            </div>
                        </div>



                        <div class="form-group">
                            <label for="picture" class="col-sm-2 control-label">图片</label>
                            <div class="col-sm-10">
                                <input type="hidden" name="picture" id="picture"
                                       value="${dish.picture }">
                                <!--dom结构部分-->

                                <div id="filePicker">选择图片</div>
                            </div>

                        </div>


                        <div class="form-group">
                            <label for="sale" class="col-sm-2 control-label">销量</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="sale"
                                       id="sale"value="${requestScope.book.sale}"/>
                            </div>

                        </div>

                        <div class="form-group">
                            <label for="stock" class="col-sm-2 control-label">库存</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="stock"
                                       id="stock"value="${requestScope.book.stock}"/>
                            </div>

                        </div>


                        <div class="form-group">
                            <label for="description" class="col-sm-2 control-label">描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="description"
                                       id="description" value="${requestScope.book.description}"/>
                            </div>

                        </div>



                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="button" id="btn" class="btn btn-primary" value="提交"/>
                            </div>
                        </div>

                    </form>

                    <script>
                        $(function () {

                            $("#btn").click(function () {
                                var name=$("#name").val().toString().trim();
                                if(name !==""){
                                    $.ajax({
                                        type:"POST",
                                        url:"bookServlet?method=updateBook",
                                        data:$("#myForm").serialize(),
                                        dataType:"JSON",
                                        success:function (result) {
                                            /*window.alert(result.msg);*/
                                            if(result.msg){
                                                window.alert("修改成功");
                                                window.location.href="/book/itemManage.jsp"
                                            }else {
                                                window.alert("修改失败");
                                            }
                                        },
                                        error:function (xth,errorMsg,error) {

                                        }
                                    });
                                }else {
                                    window.alert("输入框不能为空！！！")
                                }

                            });

                        });
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/public/foot.jspf"%>




</body>
</html>

