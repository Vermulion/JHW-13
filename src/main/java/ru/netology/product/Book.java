package ru.netology.product;
public class Book extends Product {
    private String title;
    private String author;

    public Book(int id, String name, int price, String title, String author) {
        super(id, name, price);
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

