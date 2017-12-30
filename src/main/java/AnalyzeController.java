import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnalyzeController implements Initializable {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private MaterialIconView batchAnalyzerBackBtn;

    @FXML
    void handleAction(MouseEvent event) {
        if(event.getSource() == batchAnalyzerBackBtn) {
            contentPane.getChildren().clear();
            try {
                contentPane.getChildren().add(FXMLLoader.load(getClass().getResource("/xml/contentBlank.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
