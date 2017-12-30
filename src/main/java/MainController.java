import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    AnchorPane leftBar;

    @FXML
    private JFXButton btnAnalysis;

    @FXML
    private JFXButton btnSample;

    @FXML
    private AnchorPane contentPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAnalysis.setOnMouseClicked(event -> {
            contentPane.getChildren().clear();
            try {
                contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/xml/moisture.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void handleNavigation(ActionEvent event) {
        System.out.println(event.getSource().toString());
    }

}
