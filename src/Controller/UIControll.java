/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * 
 * @author Fernando M 
 */
public class UIControll {
    
    public void CallUI(String fxml){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxml));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fail to load stage!");
            e.printStackTrace();
        }        
    }
    
    public void closeStage(Stage prevStage){
        prevStage.close();
    }
}
