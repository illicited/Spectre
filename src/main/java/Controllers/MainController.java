package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private PaneFactory pf;

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
        pf = new PaneFactory(contentPane);

        btnAnalysis.setOnMouseClicked(event -> {
            pf.setPane("analysis");
        });

        btnSample.setOnMouseClicked(event -> {
            pf.setPane("samples");
        });
    }

    public void handleNavigation(ActionEvent event) {
        System.out.println(event.getSource().toString());
    }

}
