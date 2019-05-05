/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Korisnik
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prijava {
    
    
    
    public static boolean logiraj (String name, String password) throws SQLException 
    {
         Database db = new Database();
        PreparedStatement ps = db.CONNECTION.prepareStatement("SELECT * FROM korisnici WHERE id =? AND "
                + "lozinka=?");
        try {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Nastala je greška: "+ex.getMessage());
            return false;
    }
  }
}
