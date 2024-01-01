package views.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;

public class FXMLScreenHandler {

    protected FXMLLoader loader;
    protected AnchorPane content;

    public FXMLScreenHandler(String screenPath) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource(screenPath));
        // Set this class as the controller
        this.loader.setController(this);
        this.content = (AnchorPane) loader.load();
    }
<<<<<<< HEAD


    /**
     * @return AnchorPane
     */
    public AnchorPane getContent() {
        return this.content;
    }


    /**
     * @return FXMLLoader
     */
    public FXMLLoader getLoader() {
        return this.loader;
    }

    /**
     * This is a set image operation.
     *
     * @param imv  Link image
     * @param path Path of image
=======
    
    public AnchorPane getContent() {
        return this.content;
    }
    
    public FXMLLoader getLoader() {
        return this.loader;
    }

    /**
     * This is a set image operation.
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
     */
    public void setImage(ImageView imv, String path) {
        File file = new File(path);
        Image img = new Image(file.toURI().toString());
        imv.setImage(img);
    }
}
