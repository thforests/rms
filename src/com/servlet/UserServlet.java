package com.servlet;

import com.bean.User;
import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //0.设置编码格式
        req.setCharacterEncoding("UTF-8");
        //1.获取请求参数
        String method = req.getParameter("method");


        //添加
        if ("addUser".equals(method)){

//            int userid = Integer.parseInt(req.getParameter("id"));
            String username = req.getParameter("name");
            String password = req.getParameter("password");
            int usertype = Integer.parseInt(req.getParameter("type"));
            String usertell = req.getParameter("tell");

            User user = new User(username,password,usertype,usertell);

            int num = userService.addUser(user);
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            JSONObject jsonObject=new JSONObject();
            if (num == 1){
                jsonObject.put("msg",true);
                out.println(jsonObject);
                out.close();
                resp.sendRedirect("user/userManage.jsp");
            }else {
                jsonObject.put("msg",false);
                out.println(jsonObject);
                out.close();
            }
        }

        //获取所有用户
        if ("select".equals(method)){
            List<User> list = userService.selectAll();
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            if (list != null){
                JSONArray jsonArray = JSONArray.fromObject(list);
                out.println(jsonArray);
                out.flush();
                out.close();
            }else {
                JSONArray jsonArray = new JSONArray();
                out.println(jsonArray);
                out.flush();
                out.close();
            }
        }


        //修改前
        if ("update".equals(method)){
            req.setCharacterEncoding("UTF-8");
            //获取请求参数
            int userid = Integer.parseInt(req.getParameter("uid"));
            User user = userService.updateUser(userid);
            if (user != null){
                req.setAttribute("user",user);
                req.getRequestDispatcher("user/user-add.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("user/user-add.jsp").forward(req,resp);
            }
        }
        //修改后
        if ("updateUser".equals(method)){


            String username = req.getParameter("name");
            int usertype = Integer.parseInt(req.getParameter("type"));
            String usertell = req.getParameter("tell");
            int userid = Integer.parseInt(req.getParameter("id"));

            int i = userService.updateOneUser(username,usertype,usertell,userid);

            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            JSONObject jsonObject=new JSONObject();
            if (i == 1){
                jsonObject.put("msg",true);
                out.println(jsonObject);
                out.close();
            }else {
                jsonObject.put("msg",false);
                out.println(jsonObject);
                out.close();
            }

        }

        //删除
        if ("delete".equals(method)){
            int userid = Integer.parseInt(req.getParameter("uid"));
            System.out.println("delete====="+userid);
            //id交给service层
            int i = userService.deleteUser(userid);
            if (i == 1){
                req.setCharacterEncoding("UTF-8");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.println("<script>window.alert('删除成功')</script>");
                out.println("<script>window.location.href='user/userManage.jsp'</script>");
                out.close();
            }
        }


        if ("updatePwd".equals(method)) {
            HttpSession session = req.getSession();
            String name =(String) session.getAttribute("logname");

            req.setCharacterEncoding("UTF-8");
            String oldpwd = req.getParameter("oldPassword");
            String pwd1 = req.getParameter("pwd1");
            String pwd2 = req.getParameter("pwd2");


            System.out.println("dididiupdatePWD");
            if (pwd1.equals(pwd2)) {
                int i = userService.updatePwd(pwd1,oldpwd, name);

                JSONObject jsonObject = new JSONObject();
                if (i == 1) {
                    req.setAttribute("message", " 修改成功");
                } else {
                    req.setAttribute("message", "原来的密码错误");
                }

            }else {
                req.setAttribute("message", "两次输入密码不一样");
            }
            req.getRequestDispatcher("user/editPassword.jsp")
                    .forward(req, resp);
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
