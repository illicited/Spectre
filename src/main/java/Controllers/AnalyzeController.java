package Controllers;

import com.jfoenix.controls.JFXComboBox;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AnalyzeController implements Initializable {
    private PaneFactory pf;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private MaterialIconView batchAnalyzerBackBtn;

    @FXML
    private JFXComboBox<String> ddNoCoarse;

    @FXML
    private JFXComboBox<String> ddNoFine;

    @FXML
    private JFXComboBox<String> ddSpecification;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Analysis Controller Initialized");

        ddNoCoarse.getItems().addAll("0", "1", "2", "3", "4");
        ddNoFine.getItems().addAll("0", "1", "2", "3", "4");
        ddSpecification.getItems().addAll("ASTM C33", "CALTRANS 2015");


        pf = new PaneFactory(contentPane);

        batchAnalyzerBackBtn.setOnMouseClicked(event -> {
            pf.setPane("default");
        });
    }
}
