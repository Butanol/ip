package shaniqua.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shaniqua.Shaniqua;
import shaniqua.ui.Ui;

/**
 * A GUI for Duke using FXML.
 */
public class GuiController extends Application {
    private static Shaniqua shaniqua;
    public static void launch(Shaniqua s) {
        shaniqua = s;
        Application.launch(GuiController.class);
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Shaniqua.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            fxmlLoader.<MainWindow>getController().setUi(shaniqua.getUi());  // inject the Duke instance
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


