/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Filmovi implements model{
     private int id_filma;
    private String naziv;
    private int trajanje;
    private String zarn;

    public Filmovi() {
    }

    public Filmovi(int id_filma, String naziv, int trajanje, String zarn) {
        this.id_filma = id_filma;
        this.naziv = naziv;
        this.trajanje = trajanje;
        this.zarn = zarn;
    }

    public void setId_filma(int id_filma) {
        this.id_filma = id_filma;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public void setZarn(String zarn) {
        this.zarn = zarn;
    }

    public int getId_filma() {
        return id_filma;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public String getZarn() {
        return zarn;
    }
    
    @Override
    public void create() {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement(
                    "INSERT INTO filmovi VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmnt.setInt(1, this.id_filma);
            stmnt.setString(2, this.naziv);
            stmnt.setInt(3, this.trajanje);
            stmnt.setString(4, this.zarn);
            stmnt.executeUpdate();

            ResultSet generatedKeys = stmnt.getGeneratedKeys();
            generatedKeys.next();
            this.id_filma = generatedKeys.getInt(1);
        } catch (SQLException e) {
            System.out.println("Greska prilikom stvaranja filmova u bazi:"
                    + e.getMessage());
        }
    }
    
    @Override
    public void update() {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement(
                    "UPDATE filmovi SET naziv=?, trajanje=?, zarn=? WHERE id_filma=?"
            );
            stmnt.setString(1, this.naziv);
            stmnt.setInt(2, this.trajanje);
            stmnt.setString(3, this.zarn);
            stmnt.setInt(4, this.id_filma);
            stmnt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Greska prilikom brisanja filmova iz baze:"
                    + e.getMessage());
        }
    }

    @Override
    public void delete() {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement(
                    "DELETE FROM filmovi WHERE id_filma=?"
            );
            stmnt.setInt(1, this.id_filma);
            stmnt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Greska prilikom brisanja filmova iz baze:"
                    + e.getMessage());
        }
    }

    public static Filmovi read (int id) {
        PreparedStatement stmnt = null;
        try {
            stmnt = Database.CONNECTION.prepareStatement(
                    "SELECT * FROM filmovi WHERE id=?"
            );
            stmnt.setInt(1, id);
            ResultSet result = stmnt.executeQuery();
            result.next();
            return new Filmovi(
                    result.getInt(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getString(4)
            );
        } catch (SQLException e) {
            System.out.println("Greska kod dohvacanja filmova iz baze:"
                    + e.getMessage());
            return null;
        }
    }

    public static List<Filmovi> readAll() {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement(
                    "SELECT * FROM filmovi"
            );
            List<Filmovi> Filmovi = new ArrayList<Filmovi>();
            ResultSet result = stmnt.executeQuery();
            while (result.next()) {
                Filmovi.add(new Filmovi(
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getString(4)
                ));
            }
            return Filmovi;
        } catch (SQLException e) {
            System.out.println("Greska kod dohvacanja filmova iz baze:"
                    + e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id_filma +
                ", naziv='" + naziv + '\'' +
                ", trajanje='" + trajanje + '\'' +
                ", zarn='" + zarn + '\'' +
                '}';
    }
}
