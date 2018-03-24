package labwork1.dao;

import labwork1.entities.Book;
import labwork1.utils.DBConnection;

import java.sql.*;
import java.util.List;

public class BookDAOs {

    private static final String CREATE = "INSERT INTO books (categoryId, name, author, year, numOfPages, price," +
            " description, available, image) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String UPDATE = "UPDATE books SET categoryId = ?, name = ?, author = ?, year = ?," +
            " numOfPages = ?, price = ?, description = ?, available = ?, image = ? WHERE id = ?;";

    private static final String FIND_BY_ID = "SELECT * FROM books WHERE id = ?";

    private static final String DELETE_BY_ID = "DELETE FROM books WHERE id = ?";


    public List<Book> findAll() {
        return null;
    }

    public void create(Book book) {
        try(Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, book.getCategoryId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getYear());
            ps.setInt(5, book.getNumOfPages());
            ps.setFloat(6, book.getPrice());
            ps.setString(7, book.getDescription());
            ps.setBoolean(8, book.isAvailable());
            ps.setString(9, book.getImage());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
                book.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(Book book) {
        try(Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, book.getCategoryId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getYear());
            ps.setInt(5, book.getNumOfPages());
            ps.setFloat(6, book.getPrice());
            ps.setString(7, book.getDescription());
            ps.setBoolean(8, book.isAvailable());
            ps.setString(9, book.getImage());
            ps.setInt(10, book.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public Book findByKey(Integer id) {
        Book book = new Book();
        try(Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new Book(rs.getInt("categoryId"), rs.getString("name"),
                        rs.getString("author"), rs.getInt("year"), rs.getInt("numOfPages"),
                        rs.getFloat("price"), rs.getString("description"),
                        rs.getBoolean("available"), rs.getString("image"));
                book.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }


    public void deleteByKey(Integer id) {
        try(Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
