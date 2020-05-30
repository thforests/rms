package com.dao.impl;

import com.bean.Book;
import com.dao.BookDao;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List <Book> findAllFood() {

        ResultSet resultSet =null;
        PreparedStatement statement =null;
        List<Book> books=new ArrayList <>();
        Book book=null;
        Connection conn = DBUtil.getConn();
        String sql="select * from books";
        try {
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if(resultSet !=null){
                while (resultSet.next()){
                    book=new Book();
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String type = resultSet.getString(3);
                    float price = resultSet.getFloat(4);
                    Integer sale = resultSet.getInt(6);
                    Integer stock = resultSet.getInt(7);
                    String description = resultSet.getString(8);

                    book.setId(id);
                    book.setBookname(name);
                    book.setType(type);
                    book.setPrice(price);
                    book.setSale(sale);
                    book.setDescription(description);
                    book.setStock(stock);

                    System.out.println(book);
                    books.add(book);
                }
                return books;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(resultSet,statement,conn);
        }
        return null;
    }

    @Override
    public int insertFood(Book book) {
        int num = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = DBUtil.getConn();
        String sql = "insert into books(name,type,price,  " +
                "sale,stock,description)   " +
                "values (?,?,?,?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1,book.getBookname());
            pstm.setObject(2,book.getType());
            pstm.setObject(3,book.getPrice());
            pstm.setObject(4,book.getSale());
            pstm.setObject(5,book.getStock());
            pstm.setObject(6,book.getDescription());

            num = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(null,pstm,conn);
        }
        return num;
    }

    @Override
    public Book updateSelect(String name) {

        ResultSet resultSet =null;
        PreparedStatement statement =null;
        List<Book> books=new ArrayList <>();
        Book book=null;
        Connection conn = DBUtil.getConn();
        String sql="select * from books where name=?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1,name);

            resultSet = statement.executeQuery();
            if(resultSet !=null){
                while (resultSet.next()){
                    book=new Book();
                    String bname = resultSet.getString(2);
                    String type = resultSet.getString(3);
                    float price = resultSet.getFloat(4);
                    Integer sale = resultSet.getInt(6);
                    Integer stock = resultSet.getInt(7);
                    String description = resultSet.getString(8);

                    book.setBookname(bname);
                    book.setType(type);
                    book.setPrice(price);
                    book.setSale(sale);
                    book.setDescription(description);
                    book.setStock(stock);

                    System.out.println(book);
                    books.add(book);
                }
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(resultSet,statement,conn);
        }
        return null;
    }

    @Override
    public int updateFoods(Object... foods) {
        int num =0;
        PreparedStatement statement =null;
        Connection conn = DBUtil.getConn();
        String sql="update books set type=?,price=?,sale=?,stock=?,description=? WHERE name=?";
        try {
            statement = conn.prepareStatement(sql);
            for(int i=0;i<foods.length;i++){
                statement.setObject((i+1),foods[i]);
            }
            num = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(null,statement,conn);
        }
        return num;
    }

    @Override
    public int deleteFood(String name) {

        int num =0;
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = DBUtil.getConn();

        String sql="delete from books where name=?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1,name);
            num= pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(null,pstm,conn);
        }
        return num;
    }

    @Override
    public List <Book> selectFoodM(Object... obj) {

        ResultSet resultSet =null;
        PreparedStatement statement =null;
        List<Book> books=new ArrayList<>();
        Book book=null;

        Connection conn = DBUtil.getConn();

        String sql="select * from books where name like ?";
        try {
            statement = conn.prepareStatement(sql);
            for(int i=0;i<obj.length;i++){
                statement.setObject(i+1,"%"+obj[i]+"%");
            }   resultSet = statement.executeQuery();
            if(resultSet !=null){
                while (resultSet.next()){
                    book=new Book();
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String type = resultSet.getString(3);
                    float price = resultSet.getFloat(4);
                    Integer sale = resultSet.getInt(6);
                    Integer stock = resultSet.getInt(7);
                    String description = resultSet.getString(8);

                    book.setId(id);
                    book.setBookname(name);
                    book.setType(type);
                    book.setPrice(price);
                    book.setSale(sale);
                    book.setDescription(description);
                    book.setStock(stock);

                    System.out.println(book);
                    books.add(book);
                }
                return books;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeDB(resultSet,statement,conn);
        }


        return null;

    }
}
