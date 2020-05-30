<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/28
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>餐饮管理系统</title>
    <style type="text/css">
      .index-middle div {
        line-height: 30px;
        marging: 0;
        margin-top: 12px;
        color: #330000;
      }
      .index-middle-padding {
        height: 110px;
      }
    </style>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
    <link rel="stylesheet" href="sources/grumble.js-master/css/grumble.min.css" type="text/css"></link>
    <script type="text/javascript" src="sources/bootstrap-3.3.4/js/unslider.min.js"></script>
    <script type="text/javascript" src="sources/grumble.js-master/js/jquery.grumble.min.js"></script>
  </head>
  <body>
    <div class="panel panel-default inner-form"
         style="position: absolute;float:right;z-index: 3000;width:300px;height:300px;left:999px;top:20px; border:1px solid black; background-color: #333333;color:white;">
      <div>
        <form id="myform">
          <div class="form-group">
            <label for="name">账号</label>
            <input type="text" name="name" id="name" placeholder="输入账户名..." class="form-control" required="required"/>
          </div>

          <div class="form-group">
            <label for="password">密码</label>
            <input type="password" name="password" id="password" placeholder="******" class="form-control"
                   required="required" />
          </div>

          <div><%-- 验证码 --%> </div>

          <input type="button" id="loginbutton" data-loading-text="登录中..." value="登 录"
                  class="btn btn-primary btn-block" autocomplete="off"/>
        </form>
      </div>
    </div>

  <%-- 背景滚动条 --%>
    <div class="banner">
      <ul>
        <li style="background-image: url('sources/images/banner4.jpg');"></li>
        <li style="background-image: url('sources/images/banner1.jpg');"></li>
        <li style="background-image: url('sources/images/banner3.jpg');"></li>
        <li style="background-image: url('sources/images/banner2.jpg');"></li>
      </ul>
    </div>

  <%-- 底部标签 --%>
    <div class="container">
      <div class="row index-middle">
        <div class="col-md-3">
          <div class="panel panel-dafult">
            <div class="panel-heading">
              <h3 class="panel-title">
                <i class='glyphicon glyphicon-book'></i> 方便的点餐功能
              </h3>
            </div>
            <div class="panel-body index-middle-padding">
              <p>客户可以根据自己的要求去选择菜品，厨师部会收到你点的菜单。你可以看到菜单的时时状况。</p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="panel panel-waring">
            <div class="panel-heading">
              <h3 class="panel-title">
                <i class='glyphicon glyphicon-comment'></i> 便捷的通讯功能
              </h3>
            </div>
            <div class="panel-body index-middle-padding">
              <p>工作人员之间可以互相进行内部通讯，及时得到最新信息。经理可以群发通知、消息给每位员工。</p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="panel panel-waring">
            <div class="panel-heading">
              <h3 class="panel-title">
                <i class='glyphicon glyphicon-alert'></i> 安全的预警功能
              </h3>
            </div>
            <div class="panel-body index-middle-padding">
              <p>系统会对所有菜品进行监视，当有菜品库存缺乏时，系统会自动提醒管理员。</p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="panel panel-waring">
            <div class="panel-heading">
              <h3 class="panel-title">
                <i class='glyphicon glyphicon-apple'></i> 智能的分析功能
              </h3>
            </div>
            <div class="panel-body index-middle-padding">
              <p>管理员可以查看到餐厅的近期运营状况。包括最近的营业额，各个菜品的销售情况等。</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <%@ include file="/WEB-INF/jsp/public/foot.jspf"%>

  </body>


  <script type="text/javascript">
    $(function () {
      var wid = $(window).width();
      $('.inner-form').css("opacity", 0.9).offset({
        top : 20,
        left : wid - 350
      });

      $('.banner').unslider({
        speed : 500,
        delay : 8000,
        complete : function() {},
        keys : true,
        dots : true,
        fluid : false
      });

      //登录
      $(".btn").click(function () {
        var userIdValue = $("#name").val();
        var passwordValue = $("#password").val();
        if (userIdValue.toString().trim() != "" && passwordValue.toString().trim() != "") {
          $.ajax({
            type:"POST",
            url:"loginServlet",
            data:$("#myform").serialize(),
            dataType:"JSON",
            success:function (result) {
              if (result.flag) {
                window.alert("登录成功");
                window.location.href = "user/userindex.jsp";
              } else {
                window.alert("用户名密码输入错误！");
                window.location.href = "login.jsp";
              }
            },
            error:function (xhr, errorMsg, error) {

            }
          });
        }else {
          window.alert("请完整填写用户名和密码")
        }
      });

    })


  </script>
</html>
