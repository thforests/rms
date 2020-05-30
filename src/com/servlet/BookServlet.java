package com.servlet;

import com.bean.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("来到bookservlet");
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if ("select".equals(method)) {
            List <Book> list = bookService.findAllFood();
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            if (list != null) {
                JSONArray jsonArray = JSONArray.fromObject(list);
                out.println(jsonArray);
                out.flush();
                out.close();
            } else {
                JSONArray jsonArray = new JSONArray();
                out.println(jsonArray);
                out.flush();
                out.close();
            }
        }

        if ("add".equals(method)) {
            String bookname = req.getParameter("name");
            String type = req.getParameter("type");
            float price = Float.parseFloat(req.getParameter("price"));
            int sale = Integer.parseInt(req.getParameter("sale"));
            int stock = Integer.parseInt(req.getParameter("stock"));
            String description = req.getParameter("description");

            Book book = new Book();
            book.setBookname(bookname);
            book.setType(type);
            book.setPrice(price);
            book.setSale(sale);
            book.setStock(stock);
            book.setDescription(description);

            System.out.println(book);

            int num = bookService.insertFood(book);
            if (num != 0) {
                resp.sendRedirect("/book/itemManage.jsp");
            } else {
                resp.sendRedirect("/book/bookAdd.jsp");
            }

        }
        if ("update".equals(method)) {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");

            Book book = bookService.updateSelect(name);
            if (book != null) {
                req.setAttribute("book", book);
                req.getRequestDispatcher("/book/bookUpdate.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/book/bookUpdate.jsp").forward(req, resp);
            }


        }

        if ("updateBook".equals(method)) {
            String bookname = req.getParameter("name");
            String type = req.getParameter("type");
            float price = Float.parseFloat(req.getParameter("price"));
            int sale = Integer.parseInt(req.getParameter("sale"));
            int stock = Integer.parseInt(req.getParameter("stock"));
            String description = req.getParameter("description");


            int i = bookService.updateFoods(type, price, sale, stock,description,bookname);
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            JSONObject jsonObject = new JSONObject();
            if (i == 1) {
                jsonObject.put("msg", true);
                out.println(jsonObject);
                out.close();
            } else {
                jsonObject.put("msg", false);
                out.println(jsonObject);
                out.close();
            }


        }
        if("delete".equals(method)){
            String name = req.getParameter("name");
            System.out.println("===="+name);
            int i = bookService.deleteFood(name);
            if(i == 1){
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.println("<script>window.location.href='book/itemManage.jsp'</script>");
                out.close();
            }
        }

        if("selectM".equals(method)){
            String name = req.getParameter("name");
            System.out.println("name="+name);

            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();


            List<Book> list = bookService.selectFoodM(name);
            JSONArray jsonArray = JSONArray.fromObject(list);
            if(list !=null){
                out.println(jsonArray);
                out.flush();
                out.close();
            }else {

                out.println(jsonArray);
                out.flush();
                out.close();
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
