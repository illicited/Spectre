package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PaneFactory {
    private AnchorPane contentPane;
    private final String DEFAULT_VIEW = "/xml/contentBlank.fxml";
    private final String SAMPLE_VIEW = "/xml/samples.fxml";
    private final String ANALYSIS_VIEW = "/xml/analysis.fxml";

    PaneFactory(AnchorPane ap) {
        this.contentPane = ap;
    }

    public void setPane(String pane) {
        if(pane.equals("default")) {
            contentPane.getChildren().clear();
            try {
                contentPane.getChildren().add(FXMLLoader.load(getClass().getResource(DEFAULT_VIEW)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (pane.equals("analysis")) {
            contentPane.getChildren().clear();
            try {
                contentPane.getChildren().add(FXMLLoader.load(getClass().getResource(ANALYSIS_VIEW)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (pane.equals("samples")) {
            contentPane.getChildren().clear();
            try {
                contentPane.getChildren().add(FXMLLoader.load(getClass().getResource(SAMPLE_VIEW)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
