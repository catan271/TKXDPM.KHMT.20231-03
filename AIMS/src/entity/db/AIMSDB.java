package entity.db;

import utils.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class AIMSDB {
<<<<<<< HEAD

=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
    private static Connection connect;


    /**
     * @return Connection
     */
    public static Connection getConnection() {
        if (connect != null) {
            return connect;
        }
        try {
            Class.forName("org.sqlite.JDBC");
      String url = "jdbc:sqlite:assets/db/aims.db";
            connect = DriverManager.getConnection(url);
            LOGGER.info("Connect database successfully");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return connect;
    }
<<<<<<< HEAD


    /**
     * @param args
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public static void main(String[] args) {
        AIMSDB.getConnection();
    }
}
