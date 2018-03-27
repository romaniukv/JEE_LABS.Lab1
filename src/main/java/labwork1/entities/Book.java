package labwork1.entities;

import java.util.List;

public class Book {

    private int id;

    private int categoryId;

    private String name;

    private String author;

    private int year;

    private int numOfPages;

    private float price;

    private String description;

    private boolean available;

    private String image;

    private List<Order> orders;

    public Book() {

    }

    public Book(int category, String name, String author, int year, int numOfPages,
                float price, String description, boolean available, String image) {
        this.categoryId = category;
        this.name = name;
        this.author = author;
        this.year = year;
        this.numOfPages = numOfPages;
        this.price = price;
        this.description = description;
        this.available = available;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Order> getOrders() {
        return orders;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id && year == book.year &&
                numOfPages == book.numOfPages && Float.compare(book.price, price) == 0 &&
                available == book.available && name.equals(book.name) &&
                author.equals(book.author) && description.equals(book.description) &&
                image.equals(book.image);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", numOfPages=" + numOfPages +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", availability=" + available +
                ", image='" + image + '\'' +
                '}';
    }
}
