package com.dao;

import com.bean.Book;

import java.util.List;

public interface BookDao {
    public List <Book> findAllFood();

    public int insertFood(Book book);

    public Book updateSelect(String name);

    public  int updateFoods(Object... foods);

    public int deleteFood(String name);

    public List<Book> selectFoodM(Object... obj);
}
