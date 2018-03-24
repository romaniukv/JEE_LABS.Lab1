package labwork1.dao;

import labwork1.entities.Category;

public class CategoryDAO extends AbstractDAO<Category> {

    public CategoryDAO() {
        super("SELECT * FROM categories;",
                "INSERT INTO categories (category) VALUES(?);",
                "UPDATE categories SET category = ? WHERE id = ?;",
                "SELECT * FROM categories WHERE id = ?",
                "DELETE FROM categories WHERE id = ?",
                new String[] {"categoryName"},
                Category.class);
    }

}
