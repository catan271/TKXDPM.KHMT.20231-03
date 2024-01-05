package views.screen.manage;

import controller.ManageOrderController;
import controller.MediaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.home.HomeScreenHandler;
import views.screen.manage.media.MediaManageScreenHandler;
import views.screen.manage.order.OrderManageScreenHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageScreenHandler extends BaseScreenHandler implements Initializable {
    @FXML
    protected Button mediaManage;

    @FXML
    protected Button orderManage;

    @FXML
    protected Button backHome;

    protected HomeScreenHandler home;

    public ManageScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mediaManage.setOnAction(e -> {
            openMediaManage();
        });

        orderManage.setOnAction(e -> {
            openOrderManage();
        });

        backHome.setOnAction(e -> {
            System.out.println("back home");
            backToHome();
        });
    }

    protected void openMediaManage() {
        try {
            MediaManageScreenHandler mediaManageScreen = new MediaManageScreenHandler(this.stage, Configs.MEDIA_MANAGE_SCREEN_PATH);
            mediaManageScreen.setHomeScreenHandler(this.home);
            mediaManageScreen.setBController(new MediaController());
            mediaManageScreen.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void openOrderManage() {
        try {
            OrderManageScreenHandler orderManageScreen = new OrderManageScreenHandler(this.stage, Configs.ORDER_MANAGE_SCREEN_PATH);
            orderManageScreen.setHomeScreenHandler(this.home);
            orderManageScreen.setBController(new ManageOrderController());
            orderManageScreen.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void backToHome() {
        try {
            HomeScreenHandler homeHandler = new HomeScreenHandler(stage, Configs.HOME_PATH);
            homeHandler.setScreenTitle("Home Screen");
            homeHandler.setImage();
            homeHandler.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
