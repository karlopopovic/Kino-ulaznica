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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class Popis_adminaController implements Initializable {
    
    ObservableList list = FXCollections.observableArrayList();
    
    @FXML
    private ListView<String> listview;
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
        dodaj_admine();
    }

    private void dodaj_admine()
    {
        listview.getItems().clear();
        PreparedStatement stmnt = null;
        try {
            stmnt = Database.CONNECTION.prepareStatement(
                    "SELECT id FROM korisnici"
            );
            ResultSet result = stmnt.executeQuery();
            while(result.next())
            {
                list.add(result.getString("id"));
                listview.getItems().add(result.getString("id"));
                
            }
        }
        catch(SQLException e)
        {
            System.out.print("Greska");
        }
    }
    
    @FXML
    private void handleButtonAction2(ActionEvent event) throws Exception
    {
        
            try {
                 FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Dodaj_admina.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Prijavite se"); 
                 stage.setScene(new Scene(root1));
                 stage.show();
           
                }
            catch (Exception e) 
                {
                 e.printStackTrace();
                }
        }
    
}
