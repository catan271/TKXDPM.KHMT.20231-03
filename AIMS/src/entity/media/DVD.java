package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DVD extends Media {

    String discType;
    String director;
    int runtime;
    String studio;
    String subtitles;
    Date releasedDate;
    String filmType;

    public DVD() throws SQLException {

    }

<<<<<<< HEAD
    public DVD(int id, String title, String category, int price, int value, int quantity, String type, String discType,
               String director, int runtime, String studio, String subtitles, Date releasedDate, String filmType) throws SQLException {
        super(id, title, category, price, value, quantity, type);
=======
    public DVD(int id, String title, String category, int price, int quantity, String type, String discType,
               String director, int runtime, String studio, String subtitles, Date releasedDate, String filmType) throws SQLException {
        super(id, title, category, price, quantity, type);
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
        this.discType = discType;
        this.director = director;
        this.runtime = runtime;
        this.studio = studio;
        this.subtitles = subtitles;
        this.releasedDate = releasedDate;
        this.filmType = filmType;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getDiscType() {
        return this.discType;
    }


    /**
     * @param discType
     * @return DVD
     */
=======
    
    public String getDiscType() {
        return this.discType;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public DVD setDiscType(String discType) {
        this.discType = discType;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getDirector() {
        return this.director;
    }


    /**
     * @param director
     * @return DVD
     */
=======
    
    public String getDirector() {
        return this.director;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public DVD setDirector(String director) {
        this.director = director;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return int
     */
    public int getRuntime() {
        return this.runtime;
    }


    /**
     * @param runtime
     * @return DVD
     */
=======
    
    public int getRuntime() {
        return this.runtime;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public DVD setRuntime(int runtime) {
        this.runtime = runtime;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getStudio() {
        return this.studio;
    }


    /**
     * @param studio
     * @return DVD
     */
=======
    
    public String getStudio() {
        return this.studio;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public DVD setStudio(String studio) {
        this.studio = studio;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getSubtitles() {
        return this.subtitles;
    }


    /**
     * @param subtitles
     * @return DVD
     */
=======
    
    public String getSubtitles() {
        return this.subtitles;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public DVD setSubtitles(String subtitles) {
        this.subtitles = subtitles;
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
     * @return DVD
     */
=======
    
    public Date getReleasedDate() {
        return this.releasedDate;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public DVD setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }
<<<<<<< HEAD


    /**
     * @return String
     */
    public String getFilmType() {
        return this.filmType;
    }


    /**
     * @param filmType
     * @return DVD
     */
=======
    
    public String getFilmType() {
        return this.filmType;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public DVD setFilmType(String filmType) {
        this.filmType = filmType;
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
        return "{" + super.toString() + " discType='" + discType + "'" + ", director='" + director + "'" + ", runtime='"
                + runtime + "'" + ", studio='" + studio + "'" + ", subtitles='" + subtitles + "'" + ", releasedDate='"
                + releasedDate + "'" + ", filmType='" + filmType + "'" + "}";
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
                "aims.DVD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = DVD.id " +
                "where Media.id = " + id + ";";
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {

            // from media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
<<<<<<< HEAD
            int value = res.getInt("value");
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from DVD table
            String discType = res.getString("discType");
            String director = res.getString("director");
            int runtime = res.getInt("runtime");
            String studio = res.getString("studio");
            String subtitles = res.getString("subtitle");
            Date releasedDate = res.getDate("releasedDate");
            String filmType = res.getString("filmType");

<<<<<<< HEAD
            return new DVD(id, title, category, price, value, quantity, type, discType, director, runtime, studio, subtitles, releasedDate, filmType);
=======
            return new DVD(id, title, category, price, quantity, type, discType, director, runtime, studio, subtitles, releasedDate, filmType);
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669

        } else {
            throw new SQLException();
        }
    }
<<<<<<< HEAD


    /**
     * @return List
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    @Override
    public List getAllMedia() {
        return null;
    }
}
