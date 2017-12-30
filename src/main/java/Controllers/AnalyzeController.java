package Controllers;

import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnalyzeController implements Initializable {
    private PaneFactory pf;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private MaterialIconView batchAnalyzerBackBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pf = new PaneFactory(contentPane);

        batchAnalyzerBackBtn.setOnMouseClicked(event -> {
            pf.setPane("default");
        });
    }
}
