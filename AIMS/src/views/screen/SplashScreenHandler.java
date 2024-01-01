package views.screen;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenHandler implements Initializable {

    @FXML
    ImageView logo;
<<<<<<< HEAD


    /**
     * @param location
     * @param resources
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("assets/images/Logo.png");
        Image image = new Image(file.toURI().toString());
        logo.setImage(image);
    }
}