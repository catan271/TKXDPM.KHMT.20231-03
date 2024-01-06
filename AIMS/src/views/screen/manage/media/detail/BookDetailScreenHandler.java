package views.screen.manage.media.detail;

import controller.MediaController;
import entity.media.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.manage.media.MediaManageScreenHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class BookDetailScreenHandler extends BaseScreenHandler implements Initializable {
    protected int id;

    public void setId(int id) {
        this.id = id;
    }

    @FXML
    protected Button exitButton;

    @FXML
    protected Label authorText;

    @FXML
    protected Label coverTypeText;

    @FXML
    protected Label publisherText;

    @FXML
    protected Label pubDateText;

    @FXML
    protected Label numPageText;

    @FXML
    protected Label languageText;

    @FXML
    protected Label bookCatText;

    @FXML
    protected ImageView imageField;

    public BookDetailScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public MediaController getBController() {
        return (MediaController) super.getBController();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exitButton.setOnAction(e -> {
            try {
                backScreen();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void showDetailBook(int id) throws SQLException {
//        System.out.println(id);
        Book book = getBController().getBookMediaById(id);
        authorText.setText(book.getAuthor());
        coverTypeText.setText(book.getCoverType());
        publisherText.setText(book.getPublisher());
        pubDateText.setText(String.valueOf(book.getPublishDate()));
        numPageText.setText(String.valueOf(book.getNumOfPages()));
        languageText.setText(book.getLanguage());
        bookCatText.setText(book.getBookCategory());

        File file = new File(book.getImageURL());
        Image image = new Image(file.toURI().toString());
        imageField.setImage(image);
    }

    protected void backScreen() throws IOException {
        MediaManageScreenHandler mediaScreen = new MediaManageScreenHandler(this.stage, Configs.MEDIA_MANAGE_SCREEN_PATH);
        mediaScreen.setBController(new MediaController());
        mediaScreen.show();
    }
}
