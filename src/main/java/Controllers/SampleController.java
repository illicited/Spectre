package Controllers;

import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SampleController implements Initializable{

    private PaneFactory pf;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private MaterialIconView sampleBackBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pf = new PaneFactory(contentPane);
        sampleBackBtn.setOnMouseClicked(event -> {
                pf.setPane("default");
        });
    }
}
