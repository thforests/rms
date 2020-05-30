package com.servlet;

import com.bean.User;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //关联业务层
        IUserService userService = new UserServiceImpl();

        //1、设置请求编码格式
        req.setCharacterEncoding("UTF-8");
        //2、获取请求参数
        String username =req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println(username+":"+password);
        //3、
        //4、
        resp.setCharacterEncoding("UTF-8");
        //5.响应浏览器
        PrintWriter out = resp.getWriter();
        //6.打印数据到浏览器
        JSONObject json = new JSONObject();
        User user = userService.isLogin(username,password);
        if (user != null){
            User one = userService.getOneMessage(username);
            System.out.println("这是登录者的信息======"+one);
            HttpSession session = req.getSession();

            session.setAttribute("logid",one.getId());
            session.setAttribute("logname",one.getName());
            session.setAttribute("logtype",one.getType());
            session.setAttribute("logtell",one.getTell());


            json.put("flag",true);
            out.println(json);
            //7.关闭打印数据
            out.flush();
            out.close();
        }else {
            json.put("flag", false);
            out.println(json);
            //7.关闭打印数据
            out.flush();
            out.close();
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}