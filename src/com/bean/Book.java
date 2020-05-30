package com.bean;

public class Book {
    private Integer id;
    private String bookname;
    private String type;
    private float price;
    private String picture;
    private Integer sale;
    private Integer stock;
    private String description;


    public Book() {

    }

    public Book(Integer id, String bookname, String type, float price, String picture, Integer sale, Integer stock, String description) {
        this.id = id;
        this.bookname = bookname;
        this.type = type;
        this.price = price;
        this.picture = picture;
        this.sale = sale;
        this.stock = stock;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", sale=" + sale +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
