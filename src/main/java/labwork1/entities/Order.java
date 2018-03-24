package labwork1.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order {

    private int id;

    private User user;

    private Date date;

    private List<Book> books = new ArrayList<>();

    public Order() {

    }

    public Order(User user, Date date, List<Book> books) {
        this.user = user;
        this.date = date;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
