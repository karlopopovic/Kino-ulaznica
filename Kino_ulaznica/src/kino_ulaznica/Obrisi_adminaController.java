/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kino_ulaznica;

import Database.Database;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class Obrisi_adminaController implements Initializable {

    @FXML
    private TextField field1;
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
    private void obrisi() throws Exception
    {
        String id = field1.getText();
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement(
                    "DELETE FROM korisnici WHERE id=?"
            );
            stmnt.setString(1, id);
            stmnt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Greska "
                    + e.getMessage());
        }
    }
    
}
