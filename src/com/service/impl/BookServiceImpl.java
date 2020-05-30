package com.service.impl;

import com.bean.Book;
import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public List <Book> findAllFood() {
        List<Book> books = bookDao.findAllFood();
        if(books !=null){
            return books;
        }
        return null;
    }

    @Override
    public int insertFood(Book book) {
        if (book!=null){
            int num = bookDao.insertFood(book);
            return num;
        }
        return 0;
    }

    @Override
    public Book updateSelect(String name) {
        Book book = bookDao.updateSelect(name);
        if(book !=null){
            //调用Dao 返回结果
            return  book;
        }
        return null;
    }

    @Override
    public int updateFoods(Object... foods) {
        int i = bookDao.updateFoods(foods);
        if(i !=0){
            return  i;
        }
        return 0;
    }

    @Override
    public int deleteFood(String name) {
        int i = bookDao.deleteFood(name);
        if(i !=0){
            return  i;
        }
        return 0;
    }

    @Override
    public List <Book> selectFoodM(Object... obj) {
        if(obj.length>0){
            List<Book> list = bookDao.selectFoodM(obj);
            System.out.println(list.toString());
            return list;
        }
        return null;
    }
}
