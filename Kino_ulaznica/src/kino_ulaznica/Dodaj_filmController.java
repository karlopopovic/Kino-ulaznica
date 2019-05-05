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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class Dodaj_filmController implements Initializable {

    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private Button button1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void dodaj() throws Exception
    {
        String naziv = field1.getText();
        String trajanje = field2.getText();
        String zarn = field3.getText();
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement(
                    "INSERT INTO filmovi VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmnt.setString(1, naziv);
            stmnt.setString(2, trajanje);
            stmnt.setString(3, zarn);
            stmnt.executeUpdate();

            ResultSet generatedKeys = stmnt.getGeneratedKeys();
            generatedKeys.next();
            int i = generatedKeys.getInt(1);
        } catch (SQLException e) {
            System.out.println("Greska prilikom stvaranja filmova u bazi: "
                    + e.getMessage());
        }
    }
    
}
