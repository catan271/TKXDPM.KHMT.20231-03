package entity.media;

import entity.db.AIMSDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends Media {

    String author;
    String coverType;
    String publisher;
    Date publishDate;
    int numOfPages;
    String language;
    String bookCategory;

    public Book() throws SQLException {

    }

<<<<<<< HEAD
    public Book(int id, String title, String category, int price, int value, int quantity, String type, String author,
                String coverType, String publisher, Date publishDate, int numOfPages, String language,
                String bookCategory) throws SQLException {
        super(id, title, category, price, value, quantity, type);
=======
    public Book(int id, String title, String category, int price, int quantity, String type, String author,
                String coverType, String publisher, Date publishDate, int numOfPages, String language,
                String bookCategory) throws SQLException {
        super(id, title, category, price, quantity, type);
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
        this.author = author;
        this.coverType = coverType;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.numOfPages = numOfPages;
        this.language = language;
        this.bookCategory = bookCategory;
    }


    /**
     * @return int
     */
    // getter and setter
    public int getId() {
        return this.id;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getAuthor() {
        return this.author;
    }


    /**
     * @param author
     * @return Book
     */
=======
    
    public String getAuthor() {
        return this.author;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getCoverType() {
        return this.coverType;
    }


    /**
     * @param coverType
     * @return Book
     */
=======
    
    public String getCoverType() {
        return this.coverType;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Book setCoverType(String coverType) {
        this.coverType = coverType;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getPublisher() {
        return this.publisher;
    }


    /**
     * @param publisher
     * @return Book
     */
=======
    
    public String getPublisher() {
        return this.publisher;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }


<<<<<<< HEAD
    /**
     * @return Date
     */
    public Date getPublishDate() {
        return this.publishDate;
    }


    /**
     * @param publishDate
     * @return Book
     */
=======
    public Date getPublishDate() {
        return this.publishDate;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Book setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return int
     */
    public int getNumOfPages() {
        return this.numOfPages;
    }


    /**
     * @param numOfPages
     * @return Book
     */
=======
    
    public int getNumOfPages() {
        return this.numOfPages;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Book setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getLanguage() {
        return this.language;
    }


    /**
     * @param language
     * @return Book
     */
=======
    
    public String getLanguage() {
        return this.language;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Book setLanguage(String language) {
        this.language = language;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public String getBookCategory() {
        return this.bookCategory;
    }


    /**
     * @param bookCategory
     * @return Book
     */
    public Book setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
        return this;
    }
<<<<<<< HEAD


    /**
     * @param id
     * @return Media
     * @throws SQLException
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM " +
                "aims.Book " +
                "INNER JOIN aims.Media " +
                "ON Media.id = Book.id " +
                "where Media.id = " + id + ";";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {

            // from Media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            int value = res.getInt("value");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from Book table
            String author = res.getString("author");
            String coverType = res.getString("coverType");
            String publisher = res.getString("publisher");
            Date publishDate = res.getDate("publishDate");
            int numOfPages = res.getInt("numOfPages");
            String language = res.getString("language");
            String bookCategory = res.getString("bookCategory");
<<<<<<< HEAD

            return new Book(id, title, category, price, value, quantity, type,
                    author, coverType, publisher, publishDate, numOfPages, language, bookCategory);

        } else {
            throw new SQLException();
        }
    }


    /**
     * @return List
     */
=======

            return new Book(id, title, category, price, quantity, type,
                    author, coverType, publisher, publishDate, numOfPages, language, bookCategory);

        } else {
            throw new SQLException();
        }
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    @Override
    public List getAllMedia() throws SQLException {
        String sql = "SELECT * FROM " +
                "Book " +
                "INNER JOIN Media " +
                "ON Media.id = Book.id " + ";";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        ArrayList bookList = new ArrayList<>();
        while (res.next()) {

            // from Media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            int value = res.getInt("value");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from Book table
            String author = res.getString("author");
            String coverType = res.getString("coverType");
            String publisher = res.getString("publisher");
            Date publishDate = res.getDate("publishDate");
            int numOfPages = res.getInt("numOfPages");
            String language = res.getString("language");
            String bookCategory = res.getString("bookCategory");

            Book book = new Book(id, title, category, price, value, quantity, type,
                    author, coverType, publisher, publishDate, numOfPages, language, bookCategory);
            bookList.add(book);
        }
        return bookList;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    @Override
    public String toString() {
        return "{" +
                super.toString() +
                " author='" + author + "'" +
                ", coverType='" + coverType + "'" +
                ", publisher='" + publisher + "'" +
                ", publishDate='" + publishDate + "'" +
                ", numOfPages='" + numOfPages + "'" +
                ", language='" + language + "'" +
                ", bookCategory='" + bookCategory + "'" +
                "}";
    }
}
