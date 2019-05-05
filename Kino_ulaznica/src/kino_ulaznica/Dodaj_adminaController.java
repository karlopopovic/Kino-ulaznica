/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kino_ulaznica;

import Database.Database;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class Dodaj_adminaController implements Initializable {

    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private Button button1;
    @FXML
    private TextField field3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleButtonAction1(ActionEvent event) throws Exception
    {
        String id =field1.getText();
        String lozinka =field2.getText();
        String id_uloga= field3.getText();
        
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement(
                    "INSERT INTO korisnici VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmnt.setString(1, id);
            stmnt.setString(2, lozinka);
            stmnt.setString(3, id_uloga);
            stmnt.executeUpdate();

            ResultSet generatedKeys = stmnt.getGeneratedKeys();
            generatedKeys.next();
            String i = generatedKeys.getString(1);            
        }
        
        catch (SQLException e) {
            System.out.println("Greska"
                    + e.getMessage());
        }
    }
    public void handleCloseButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) button1.getScene().getWindow();
        stage.close();
    }
    
    private void handleButtonAction2(ActionEvent event) throws Exception
    {
        
            try {
                 FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Popis_admina.fxml"));
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
