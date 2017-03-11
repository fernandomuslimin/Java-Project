/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import Controller.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando M
 */
public class Main extends Application {
    
    Stage primaryStage;
    public static EntityManagerFactory emf;
    
    @Override
    public void start(Stage primaryStage) {
        emf = Persistence.createEntityManagerFactory("LibrarySystemPU");
        this.primaryStage = primaryStage;
        showLogin();
    }
    
    public void showLogin(){
        String fxml = "/librarysystem/Login.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        try {
            Scene scene = new Scene(loader.load());
            primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
            
            primaryStage.setOnCloseRequest(e->{
                emf.close();
                Platform.exit();
                System.exit(0);
            });
            //setPrevStage
            LoginController controller = loader.getController();
            controller.setPrevstage(primaryStage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fail To load Scene");
            e.getCause();
        }               
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
