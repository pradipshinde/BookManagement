package com.pradip.books;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Pradip on 2/7/2015.
 */
public class BookTest extends CommonTest {

    //assertThat(actual,expected)

    @Test
    public void idShouldHaveSetterAndGetter() {
        int expected = 123;
        book.setId(expected);
        assertThat(book.getId(), is(equalTo(expected)));
    }

    @Test
    public void imageShouldHaveSetterAndGetter() {
        String expected = "new_path/image.png";
        book.setImage(expected);
        assertThat(book.getImage(), is(equalTo(expected)));
    }

    @Test
    public void titleShouldHaveSetterAndGetter() {
        String expected = "new title";
        book.setTitle(expected);
        assertThat(book.getTitle(), is(equalTo(expected)));
    }

    @Test
    public void authorShouldHaveSetterAndGetter() {
        String expected = "new author";
        book.setAuthor(expected);
        assertThat(book.getAuthor(), is(equalTo(expected)));
    }

    @Test
    public void priceShouldHaveSetterAndGetter() {
        double expected = 123.45;
        book.setPrice(expected);
        assertThat(book.getPrice(), is(equalTo(expected)));
    }

    @Test
    public void linkShouldHaveSetterAndGetter() {
        String expected = "new link";
        book.setLink(expected);
        assertThat(book.getLink(), is(equalTo(expected)));
    }

    @Test
    public void equalsShouldFailIfIdIsNotTheSame() {
        Book actual = new Book(123);
        actual.setImage(image);
        actual.setTitle(title);
        actual.setAuthor(author);
        actual.setPrice(price);
        assertThat(actual, is(not(equalTo(book))));
    }

    @Test
    public void equalsShouldReturnFalseIfImageIsNotTheSame() {
        Book actual = new Book(id);
        actual.setImage("pradip.jpg");
        actual.setTitle(title);
        actual.setAuthor(author);
        actual.setPrice(price);
        System.out.print(actual.equals(book));
        assertThat(actual, is(not(equalTo(book))));
    }

    @Test
    public void equalsShouldReturnFalseIfTitleIsNotTheSame() {
        Book actual = new Book(id);
        actual.setImage(image);
        actual.setTitle("My Attitude");
        actual.setAuthor(author);
        actual.setPrice(price);
        assertThat(actual, is(not(equalTo(book))));
    }

    @Test
    public void equalsShouldReturnFalseIfAuthorIsNotTheSame() {
        Book actual = new Book(id);
        actual.setImage(image);
        actual.setTitle(title);
        actual.setAuthor("Sayali");
        actual.setPrice(price);
        assertThat(actual, is(not(equalTo(book))));
    }

    @Test
    public void equalsShouldReturnFalseIfPriceIsNotTheSame() {
        Book actual = new Book(id);
        actual.setImage(image);
        actual.setTitle(title);
        actual.setAuthor(author);
        actual.setPrice(123.45);
        assertThat(actual, is(not(equalTo(book))));
    }
 /*
    because same link has multiple book */

    @Test
    public void equalsShouldReturnFalseIfLinkIsNotTheSame() {
        Book actual=new Book(10);
        actual.setTitle("Golmaal");
        actual.setAuthor("Rohit shetty");
        actual.setLink("/golmaal.com");
        actual.setImage("/ajay/ajay.png");
        actual.setPrice(125.12);
        Book expected=new Book(10);
        expected.setTitle("Golmaal");
        expected.setAuthor("Rohit shetty");
        expected.setLink("/golmaal2.com");
        expected.setImage("/ajay/ajay.png");
        expected.setPrice(125.12);
        System.out.print(actual.equals(expected));
        System.out.println(actual);
        System.out.println(expected);
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void equalShouldReturnTrueIfIdImageTitleAuthorAndPriceAreTheSame() {
        Book actual = new Book(id);
        actual.setImage(image);
        actual.setTitle(title);
        actual.setAuthor(author);
        actual.setPrice(price);
        assertThat(actual, is(equalTo(book)));
    }
}
