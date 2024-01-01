package entity.media;

import entity.db.AIMSDB;
import utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * The general media class, for another media it can be done by inheriting this class
<<<<<<< HEAD
 *
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
 */
public class Media {

    protected static boolean isSupportedPlaceRushOrder = new Random().nextBoolean();
    private static Logger LOGGER = Utils.getLogger(Media.class.getName());
    protected Statement stm;
    protected int id;
    protected String title;
    protected String category;
    protected int value; // the real price of product (eg: 450)
    protected int price; // the price which will be displayed on browser (eg: 500)
    protected int quantity;
    protected String type;
    protected String imageURL;

    public Media() throws SQLException {
        stm = AIMSDB.getConnection().createStatement();
    }

<<<<<<< HEAD
    public Media(int id, String title, String category, int price, int value, int quantity, String type) throws SQLException {
=======
    public Media(int id, String title, String category, int price, int quantity, String type) throws SQLException {
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.value = value;
        this.quantity = quantity;
        this.type = type;

        //stm = AIMSDB.getConnection().createStatement();
    }
    
    public static boolean getIsSupportedPlaceRushOrder() {
        return Media.isSupportedPlaceRushOrder;
    }

    /**
<<<<<<< HEAD
     * @return boolean
     */
    public static boolean getIsSupportedPlaceRushOrder() {
        return Media.isSupportedPlaceRushOrder;
    }

    /**
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     * @return int
     * @throws SQLException
     */
    public int getQuantity() throws SQLException {
        int updated_quantity = getMediaById(id).quantity;
        this.quantity = updated_quantity;
        return updated_quantity;
    }
<<<<<<< HEAD

    /**
     * @param quantity
     * @return Media
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Media setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * @param id
     * @return Media
     * @throws SQLException
     */
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM Media ;";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {

            return new Media()
                    .setId(res.getInt("id"))
                    .setTitle(res.getString("title"))
                    .setQuantity(res.getInt("quantity"))
                    .setCategory(res.getString("category"))
                    .setMediaURL(res.getString("imageUrl"))
                    .setPrice(res.getInt("price"))
                    .setType(res.getString("type"));
        }
        return null;
    }
<<<<<<< HEAD

    /**
     * @return List
     * @throws SQLException
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public List getAllMedia() throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery("select * from Media");
        ArrayList medium = new ArrayList<>();
        while (res.next()) {
            Media media = new Media()
                    .setId(res.getInt("id"))
                    .setTitle(res.getString("title"))
                    .setQuantity(res.getInt("quantity"))
                    .setCategory(res.getString("category"))
                    .setMediaURL(res.getString("imageUrl"))
                    .setPrice(res.getInt("price"))
<<<<<<< HEAD
                    .setValue(res.getInt("value"))
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
                    .setType(res.getString("type"));
            medium.add(media);
        }
        return medium;
    }
<<<<<<< HEAD

    /**
     * @param tbname
     * @param id
     * @param field
     * @param value
     * @throws SQLException
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public void updateMediaFieldById(String tbname, int id, String field, Object value) throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        if (value instanceof String) {
            value = "\"" + value + "\"";
        }
        stm.executeUpdate(" update " + tbname + " set" + " "
                + field + "=" + value + " "
                + "where id=" + id + ";");
    }

<<<<<<< HEAD
    /**
     * @return int
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    // getter and setter
    public int getId() {
        return this.id;
    }
<<<<<<< HEAD

    /**
     * @param id
     * @return Media
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    private Media setId(int id) {
        this.id = id;
        return this;
    }
<<<<<<< HEAD

    /**
     * @return String
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @param title
     * @return Media
     */
=======
    
    public String getTitle() {
        return this.title;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Media setTitle(String title) {
        this.title = title;
        return this;
    }
<<<<<<< HEAD

    /**
     * @return String
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * @param category
     * @return Media
     */
=======
    
    public String getCategory() {
        return this.category;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Media setCategory(String category) {
        this.category = category;
        return this;
    }
<<<<<<< HEAD

    /**
     * @return int
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * @param price
     * @return Media
     */
=======
    
    public int getPrice() {
        return this.price;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Media setPrice(int price) {
        this.price = price;
        return this;
    }
<<<<<<< HEAD

    public int getValue() { return this.value; }

    public Media setValue(int value) {
        this.value = value;
        return this;
    }

    /**
     * @return String
     */
    public String getImageURL() {
        return this.imageURL;
    }

    /**
     * @param url
     * @return Media
     */
=======
    
    public String getImageURL() {
        return this.imageURL;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public Media setMediaURL(String url) {
        this.imageURL = url;
        return this;
    }
<<<<<<< HEAD

    /**
     * @return String
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public String getType() {
        return this.type;
    }

    /**
     * @param type
     * @return Media
     */
    public Media setType(String type) {
        this.type = type;
        return this;
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
                " id='" + id + "'" +
                ", title='" + title + "'" +
                ", category='" + category + "'" +
<<<<<<< HEAD
                ", value='" + value + "'" +
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
                ", price='" + price + "'" +
                ", quantity='" + quantity + "'" +
                ", type='" + type + "'" +
                ", imageURL='" + imageURL + "'" +
                "}";
    }

}