/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fernando M
 */
public class AddNewBooksController implements Initializable {

    @FXML
    private TextField fBookName;
    @FXML
    private TextField fBookId;
    @FXML
    private TextField fPublisher;
    @FXML
    private TextField fWriter;
    @FXML
    private TextField fYear;
    @FXML
    private TextField fQty;
    Stage stage;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SaveBook(ActionEvent event) {
        ActionMethod am = new ActionMethod();
        int year = Integer.parseInt(fYear.getText());
        int qty = Integer.parseInt(fQty.getText());
        am.insertBooksQuery(fBookId.getText(), fBookName.getText(), fPublisher.getText(), fWriter.getText(), year, qty);
        stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Cancel(ActionEvent event) {
        stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
}
