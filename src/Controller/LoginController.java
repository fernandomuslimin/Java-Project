/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fernando M
 */
public class LoginController implements Initializable {

    @FXML
    private TextField fUsername;
    @FXML
    private PasswordField fPassword;
    Stage prevStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnLogin(ActionEvent event) throws IOException, SQLException {
        ActionMethod am = new ActionMethod();       
        am.Login(fUsername.getText(), fPassword.getText());                
        prevStage.close();       
    }
    
    @FXML
    private void btnCancel(ActionEvent event) {
        System.exit(0);
    }
    
    public void setPrevstage(Stage prevStage){
        this.prevStage = prevStage;
    }
    
}

