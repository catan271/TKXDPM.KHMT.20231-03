package controller;

import entity.media.Media;

import java.sql.SQLException;
import java.util.List;

/**
 * This class controls the flow of events in homescreen
 *
 */
public class HomeController extends BaseController {

    /**
     * this method gets all Media in DB and return back to home to display
<<<<<<< HEAD
     *
     * @return List[Media]
     * @throws SQLException
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public List getAllMedia() throws SQLException {
        return new Media().getAllMedia();
    }

}
