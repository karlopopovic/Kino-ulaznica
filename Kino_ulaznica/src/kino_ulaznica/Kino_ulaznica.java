/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kino_ulaznica;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Korisnik
 */
public class Kino_ulaznica extends Application{

    /**
     * @param args the command line arguments
     */
    @Override
    public void start(Stage stage) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Pocetna.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
