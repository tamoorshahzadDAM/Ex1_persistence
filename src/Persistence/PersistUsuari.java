/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Usuari;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ALUMNEDAM
 */
public class PersistUsuari {
    
    Usuari u = new Usuari();
    Connection con;
    
    public PersistUsuari (Connection con){
        this.con = con;
    }
    
    
    public boolean afegir (Usuari u) throws SQLException{
        boolean afegit = true;
        Statement st = null;
        String sentencia= "INSERT INTO Usuaris(nif, nom, cognoms)"
                + "VALUES('" + u.getNif() + "','" + u.getNom() + "','" + 
                u.getCognoms() + ")";
        
        try {
            st = con.createStatement();
            if (st.executeUpdate(sentencia) == 0){
                afegit = false;
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            afegit = false;
        }
        
        return afegit;
    }
    
    
    
    
}
