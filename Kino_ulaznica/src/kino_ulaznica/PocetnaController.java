/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kino_ulaznica;

import Database.Connection;
import Database.Prijava;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class PocetnaController implements Initializable {

    @FXML
    private Button button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void handleCloseButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handleButtonAction1(ActionEvent event) throws Exception
    {
        
            try {
                 FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Prijava.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Prijavite se"); 
                 stage.setScene(new Scene(root1));
                 stage.show();
                ActionEvent event1 = event.copyFor(stage, stage);
                handleCloseButtonAction(event1);
           
                }
            catch (Exception e) 
                {
                 e.printStackTrace();
                }
    }
       
        
      
    
}
