import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("xml/main.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("CSS/style.css");
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.show();
    }


}
