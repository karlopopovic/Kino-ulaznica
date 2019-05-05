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
public class Database {
    public static java.sql.Connection CONNECTION = null;

    static {
        try {
            CONNECTION = new Connection().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
