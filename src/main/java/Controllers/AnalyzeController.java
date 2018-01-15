package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
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

    @FXML
    private JFXButton analysisGoBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ddNoCoarse.getItems().addAll("0", "1", "2", "3", "4");
        ddNoFine.getItems().addAll("0", "1", "2", "3", "4");
        ddSpecification.getItems().addAll("ASTM C33", "CALTRANS 2015");


        pf = new PaneFactory(contentPane);

        batchAnalyzerBackBtn.setOnMouseClicked(event -> {
            pf.setPane("default");
        });

        analysisGoBtn.setOnMouseClicked(event -> {
            int coarse = 0;
            int fine = 0;
            String spec = "";

            if(ddNoCoarse.getValue() != null && ddNoFine.getValue() != null && ddSpecification.getValue() != null) {
                coarse = Integer.parseInt(ddNoCoarse.getValue());
                fine = Integer.parseInt(ddNoFine.getValue());
                spec = ddSpecification.getValue();
                setupAnalysisPane(coarse, fine, spec);

                ddNoCoarse.setValue(null);
                ddNoFine.setValue(null);
                ddSpecification.setValue(null);

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Values not provided");
                alert.setHeaderText("No options were selected");
                alert.setContentText("Please select a number of coarse and fine aggregates and a specification");

                ddNoCoarse.setValue(null);
                ddNoCoarse.setValue(null);
                ddSpecification.setValue(null);

                alert.showAndWait();
            }

        });
    }

    private void setupAnalysisPane(int numOfCoarse, int numOfFine, String specification) {
        Node checkGP = contentPane.lookup("#batchValuesGrid");
        if(checkGP != null) {
            contentPane.getChildren().remove(checkGP);
        }

        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<JFXTextField> textFieldsTarget = new ArrayList<>();
        ArrayList<JFXTextField> textFieldActual = new ArrayList<>();

        GridPane gp = new GridPane();
        gp.setId("batchValuesGrid");
        gp.setPadding(new Insets(5));
        gp.setHgap(10.0);
        gp.setVgap(10.0);
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(100);
        ColumnConstraints column3 = new ColumnConstraints(100);
        gp.getColumnConstraints().addAll(column1, column2, column3);


        labels.add(new Label("Target"));
        labels.add(new Label("Actual"));
        labels.add(new Label("Cement #1"));
        labels.add(new Label("Cement #2"));
        labels.add(new Label("Cementitious #1"));
        labels.add(new Label("Cementitious #2"));
        labels.add(new Label("Water #1"));
        labels.add(new Label("Water #2"));


        for(int i = 0; i < numOfCoarse; i++ ) {
            labels.add(new Label("Coarse Agg #" + (i + 1)));
        }
        for(int i = 0; i < numOfFine; i++ ) {
            labels.add(new Label("Fine Agg #" + (i + 1)));
        }

        //populate textfields for the two columns containing input
        for(int i = 0; i < labels.size() - 2; i++) {
            textFieldsTarget.add(new JFXTextField());
        }
        for(int i = 0; i < labels.size() - 2; i++) {
            textFieldActual.add(new JFXTextField());
        }

        //generate the first column of the gridpane
        for(int i = 0; i < labels.size()-2; i++) {
            gp.add(labels.get(i+2), 0, i+1);
        }
        //generate the second column of the gridpane
        gp.add(labels.get(0), 1, 0);
        for(int i = 0; i < labels.size() - 2; i++) {
            gp.add(textFieldsTarget.get(i), 1, i+1);
        }
        //generate the third column of the gridpane
        gp.add(labels.get(1), 2, 0);
        for(int i = 0; i < labels.size() - 2; i++) {
            gp.add(textFieldActual.get(i), 2, i+1);
        }

        AnchorPane.setLeftAnchor(gp, 100.0);
        AnchorPane.setTopAnchor(gp, 300.0);
        contentPane.getChildren().add(gp);

    }
}
