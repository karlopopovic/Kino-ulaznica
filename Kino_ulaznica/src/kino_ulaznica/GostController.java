/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kino_ulaznica;

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
public class GostController implements Initializable {

    @FXML
    private Button button1;
    @FXML
    private Button button2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handleCloseButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) button1.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handleButtonAction1(ActionEvent event) throws Exception
    {
        
            try {
                 FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Karta.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                 stage.setScene(new Scene(root1));
                 stage.show();
           
                }
            catch (Exception e) 
                {
                 e.printStackTrace();
                }
    }
    
    @FXML
    private void handleButtonAction2(ActionEvent event) throws Exception
    {
        
            try {
                 FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Pocetna.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage(); 
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
