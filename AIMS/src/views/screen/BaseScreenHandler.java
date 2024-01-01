package views.screen;

import controller.BaseController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.screen.home.HomeScreenHandler;

import java.io.IOException;
<<<<<<< HEAD
import java.net.URL;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.ResourceBundle;

public abstract class BaseScreenHandler extends FXMLScreenHandler {

    protected final Stage stage;
    protected HomeScreenHandler homeScreenHandler;
    protected Hashtable<String, String> messages;
    private Scene scene;
    private BaseScreenHandler prev;
    private BaseController bController;

    private BaseScreenHandler(String screenPath) throws IOException {
        super(screenPath);
        this.stage = new Stage();
    }


    public BaseScreenHandler(Stage stage, String screenPath) throws IOException {
        super(screenPath);
        this.stage = stage;
    }

    /**
     * @return BaseScreenHandler
     */
    public BaseScreenHandler getPreviousScreen() {
        return this.prev;
    }

    /**
     * @param prev
     */
    public void setPreviousScreen(BaseScreenHandler prev) {
        this.prev = prev;
    }

    public void show() {
        if (this.scene == null) {
            this.scene = new Scene(this.content);
        }
        this.stage.setScene(this.scene);
        this.stage.show();
    }


    /**
     * @param string
     */
    public void setScreenTitle(String string) {
        this.stage.setTitle(string);
    }

    /**
     * @return BaseController
     */
    public BaseController getBController() {
        return this.bController;
    }

    /**
     * @param bController
     */
    public void setBController(BaseController bController) {
        this.bController = bController;
    }

    /**
     * @param messages
     */
    public void forward(Hashtable messages) {
        this.messages = messages;
    }


    /**
     * @param HomeScreenHandler
     */
=======
import java.util.Hashtable;

public class BaseScreenHandler extends FXMLScreenHandler {

    protected final Stage stage;
    protected HomeScreenHandler homeScreenHandler;
    protected Hashtable<String, String> messages;
    private Scene scene;
    private BaseScreenHandler prev;
    private BaseController bController;

    private BaseScreenHandler(String screenPath) throws IOException {
        super(screenPath);
        this.stage = new Stage();
    }


    public BaseScreenHandler(Stage stage, String screenPath) throws IOException {
        super(screenPath);
        this.stage = stage;
    }

    public BaseScreenHandler getPreviousScreen() {
        return this.prev;
    }
    
    public void setPreviousScreen(BaseScreenHandler prev) {
        this.prev = prev;
    }

    public void show() {
        if (this.scene == null) {
            this.scene = new Scene(this.content);
        }
        this.stage.setScene(this.scene);
        this.stage.show();
    }
    
    public void setScreenTitle(String string) {
        this.stage.setTitle(string);
    }
    
    public BaseController getBController() {
        return this.bController;
    }
    
    public void setBController(BaseController bController) {
        this.bController = bController;
    }

    public void forward(Hashtable messages) {
        this.messages = messages;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
        this.homeScreenHandler = HomeScreenHandler;
    }

}
