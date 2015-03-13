package com.pradip.books;

import javax.persistence.*;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Created by Pradip on 2/7/2015.
 */
@Entity
@Table(name = "book")
@XmlRootElement
public class Book {

    public Book() {    }

    public Book(int id) {
        setId(id);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "image")
    private String image;
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "author")
    private String author;
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "price")
    private double price;
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Column(name = "title")
    private String title;
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    private String link;
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object object)
    {
        if(this==object) return true;
        if (object==null || getClass()!=object.getClass()) return false;

        Book book=(Book)object;

        if (id!=book.id) return false;
        if (Double.compare(price,book.price) !=0) return false;
        if (author!=null ? !author.equals(book.author): book.author!=null) return false;
        if (image != null ? !image.equals(book.image) : book.image != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;


        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = id;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
