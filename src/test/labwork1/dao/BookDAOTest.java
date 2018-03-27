package labwork1.dao;

import labwork1.entities.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookDAOTest {

    private BookDAO bookDAO = new BookDAO();
    private static int id;


    @Test
    public void create() {
        Book testBook = new Book(4,"The Picture of Dorian Gray", "Oscar Wilde", 1890,
                500, 250, "Some description", true,  "dorianGray.jpeg");
        bookDAO.create(testBook);
        id = testBook.getId();
        Book book = bookDAO.findByKey(id);
        assertEquals(testBook, book);
    }

    @Test
    public void update() {
        Book testBook = bookDAO.findByKey(id);
        testBook.setPrice(443);
        bookDAO.update(testBook);
        Book book = bookDAO.findByKey(id);
        bookDAO.deleteByKey(id);
        assertEquals(testBook, book);
    }
}
