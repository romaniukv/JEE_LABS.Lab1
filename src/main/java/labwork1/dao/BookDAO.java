package labwork1.dao;

import labwork1.entities.Book;

public class BookDAO extends AbstractDAO<Book> {

    public BookDAO() {
        super("SELECT * FROM books;",
                "INSERT INTO books (categoryId, name, author, year, numOfPages, price, description, available, image)" +
                        " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);",
                "UPDATE books SET categoryId = ?, name = ?, author = ?, year = ?, numOfPages = ?, price = ?," +
                        " description = ?, available = ?, image = ? WHERE id = ?;",
                "SELECT * FROM books WHERE id = ?",
                "DELETE FROM books WHERE id = ?",
                new String[] {"categoryId", "name", "author", "year", "numOfPages", "price", "description", "available", "image"},
                Book.class);
    }
}
