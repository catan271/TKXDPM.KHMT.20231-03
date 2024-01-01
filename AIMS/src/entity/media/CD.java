package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CD extends Media {

    String artist;
    String recordLabel;
    String musicType;
    Date releasedDate;

    public CD() throws SQLException {

    }

<<<<<<< HEAD
    public CD(int id, String title, String category, int price, int value, int quantity, String type, String artist,
              String recordLabel, String musicType, Date releasedDate) throws SQLException {
        super(id, title, category, price, value, quantity, type);
=======
    public CD(int id, String title, String category, int price, int quantity, String type, String artist,
              String recordLabel, String musicType, Date releasedDate) throws SQLException {
        super(id, title, category, price, quantity, type);
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
        this.artist = artist;
        this.recordLabel = recordLabel;
        this.musicType = musicType;
        this.releasedDate = releasedDate;
    }


    /**
     * @return String
     */
    public String getArtist() {
        return this.artist;
    }


    /**
     * @param artist
     * @return CD
     */
    public CD setArtist(String artist) {
        this.artist = artist;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public String getRecordLabel() {
        return this.recordLabel;
    }


    /**
     * @param recordLabel
     * @return CD
     */
    public CD setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getMusicType() {
        return this.musicType;
    }


    /**
     * @param musicType
     * @return CD
     */
=======
    
    public String getMusicType() {
        return this.musicType;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public CD setMusicType(String musicType) {
        this.musicType = musicType;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return Date
     */
    public Date getReleasedDate() {
        return this.releasedDate;
    }


    /**
     * @param releasedDate
     * @return CD
     */
=======
    
    public Date getReleasedDate() {
        return this.releasedDate;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public CD setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }


    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" + super.toString() + " artist='" + artist + "'" + ", recordLabel='" + recordLabel + "'"
                + "'" + ", musicType='" + musicType + "'" + ", releasedDate='"
                + releasedDate + "'" + "}";
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
                "aims.CD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = CD.id " +
                "where Media.id = " + id + ";";
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {

            // from media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            int value = res.getInt("value");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from CD table
            String artist = res.getString("artist");
            String recordLabel = res.getString("recordLabel");
            String musicType = res.getString("musicType");
            Date releasedDate = res.getDate("releasedDate");
<<<<<<< HEAD

            return new CD(id, title, category, price, value, quantity, type,
                    artist, recordLabel, musicType, releasedDate);

        } else {
            throw new SQLException();
        }
    }


    /**
     * @return List
     */
=======

            return new CD(id, title, category, price, quantity, type,
                    artist, recordLabel, musicType, releasedDate);

        } else {
            throw new SQLException();
        }
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    @Override
    public List getAllMedia() {
        return null;
    }

}
