package views.screen.payment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;

import java.io.IOException;

public class ResultScreenHandler extends BaseScreenHandler {

    private String result;
    private String message;
    @FXML
    private Label pageTitle;
    @FXML
    private Label resultLabel;
    @FXML
    private Button okButton;
    @FXML
    private Label messageLabel;

    public ResultScreenHandler(Stage stage, String screenPath, String result, String message) throws IOException {
        super(stage, screenPath);
        resultLabel.setText(result);
        messageLabel.setText(message);
    }
<<<<<<< HEAD

    /**
     * @param event
     * @throws IOException
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    @FXML
    void confirmPayment(MouseEvent event) throws IOException {
        homeScreenHandler.show();
    }

}
