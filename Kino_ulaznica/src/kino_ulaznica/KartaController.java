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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Filmovi;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class KartaController implements Initializable {

    ObservableList list = FXCollections.observableArrayList();
    ObservableList list_dv = FXCollections.observableArrayList();
    ObservableList list_sj = FXCollections.observableArrayList();
    ObservableList list_tr = FXCollections.observableArrayList();
    
    @FXML
    private ChoiceBox<String> list1;
    @FXML
    private ChoiceBox<String> list2;
    @FXML
    private ChoiceBox<String> list3;
    @FXML
    private ChoiceBox<String> list4;
    @FXML
    private Button button1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            try {
                try {
                    try {
                        // TODO
                        ucitaj_naziv();
                    } catch (SQLException ex) {
                        Logger.getLogger(KartaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ucitaj_dvoranu();
                } catch (SQLException ex) {
                    Logger.getLogger(KartaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                ucitaj_sjedalo();
            } catch (SQLException ex) {
                Logger.getLogger(KartaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ucitaj_termin();
            
        } catch (SQLException ex) {
            Logger.getLogger(KartaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    
    
    private void ucitaj_naziv() throws SQLException
    {
        list.removeAll(list);
        list1.getItems().clear();
        PreparedStatement stmnt = null;
        try {
            stmnt = Database.CONNECTION.prepareStatement(
                    "SELECT naziv FROM filmovi"
            );
            ResultSet result = stmnt.executeQuery();
            while(result.next())
            {
                list.add(result.getString("naziv"));
                list1.getItems().add(result.getString("naziv"));
                
            }
        }
        catch(SQLException e)
        {
            System.out.print("Greska");
        }
    }
    
    private void ucitaj_dvoranu() throws SQLException
    {
        list_dv.removeAll(list_dv);
        list2.getItems().clear();
        PreparedStatement stmnt = null;
        try {
            stmnt = Database.CONNECTION.prepareStatement(
                    "SELECT id FROM dvorana"
            );
            ResultSet result = stmnt.executeQuery();
            while(result.next())
            {
                list_dv.add(result.getString("id"));
                list2.getItems().add(result.getString("id"));
                
            }
        }
        catch(SQLException e)
        {
            System.out.print("Greska");
        }
    }
    
    private void ucitaj_sjedalo() throws SQLException
    {
        list_sj.removeAll(list_sj);
        list3.getItems().clear();
        PreparedStatement stmnt = null;
        try {
            stmnt = Database.CONNECTION.prepareStatement(
                    "SELECT id FROM sjedala"
            );
            ResultSet result = stmnt.executeQuery();
            while(result.next())
            {
                list_sj.add(result.getString("id"));
                list3.getItems().add(result.getString("id"));
                
            }
        }
        catch(SQLException e)
        {
            System.out.print("Greska");
        }
    }
    
    private void ucitaj_termin() throws SQLException
    {
        list_tr.removeAll(list_tr);
        //list4.getItems().clear();
        PreparedStatement stmnt = null;
        try {
            stmnt = Database.CONNECTION.prepareStatement(
                    "SELECT vrijeme_prikazivanja FROM rezervacija"
            );
            ResultSet result = stmnt.executeQuery();
            while(result.next())
            {
                list_tr.add(result.getString("vrijeme_prikazivanja"));
                list4.getItems().add(result.getString("vrijeme_prikazivanja"));
                
            }
        }
        catch(SQLException e)
        {
            System.out.print("Greska");
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception
    {
        String naziv = list1.getSelectionModel().getSelectedItem();
        String id = list2.getSelectionModel().getSelectedItem();
        String sjedalo = list3.getSelectionModel().getSelectedItem();
        String termin = list4.getSelectionModel().getSelectedItem();
        
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement(
                    "INSERT INTO rezervacija VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmnt.setString(1, id);
            stmnt.setString(2, naziv);
            stmnt.setString(3, sjedalo);
            stmnt.setString(4, termin);
            stmnt.executeUpdate();

            ResultSet generatedKeys = stmnt.getGeneratedKeys();
            generatedKeys.next();
            id = generatedKeys.getString(1);    
            System.out.println("Unijeli ste vrjednosti");
        }
        
        catch (SQLException e) {
            System.out.println("Greska"
                    + e.getMessage());
        }
    }
    
}
