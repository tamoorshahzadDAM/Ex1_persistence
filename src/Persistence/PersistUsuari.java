/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.Usuari;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tamoor
 */
public class PersistUsuari {

    Usuari u = new Usuari();
    Connection con;

    public PersistUsuari(Connection con) {
        this.con = con;
    }

    /**
     * Methodo booleano que por parametros le paso un objeto usuario y tiene una
     * sentencia sql, para inserta ese usuario en base de datos, si lo consigue
     * devuelve un true en caso contrario de vuelve un fals.
     *
     * @param u
     * @return
     */
    public boolean afegir(Usuari user) {
        boolean afegit;

        String sentencia = "INSERT INTO usuaris(nif, nom, cognoms) values "
                + "('" + user.getNif() + "','" + user.getNom() + "','" + user.getCognoms() + "')";

        try {
            Statement st = con.createStatement();

            System.out.println("UPDATE: " + st.executeUpdate(sentencia));

            st.close();//tanca el recurs 
            afegit = true;
        } catch (SQLException ex) {
            System.err.println("error" + ex.getMessage());
            afegit = false;
        }
        return afegit;
    }

    /**
     * Methodo booleano que por parametros le paso una lista de usuario y tiene
     * una sentencia sql, para inserta ese lista de usuario en base de datos, si
     * lo consigue devuelve un true en caso contrario devuelve un fals.
     *
     * @param llista
     * @return
     */
    public boolean afegirArray(List<Usuari> llista) {
        boolean afegit = true;
        try {
            for (int i = 0; i < llista.size(); i++) {
                try (Statement st = con.createStatement()) {
                    String sentencia = "INSERT INTO USUARIS(nif, nom, cognoms) values "
                            + "('" + llista.get(i).getNif() + "','" + llista.get(i).getNom() + "','" + llista.get(i).getCognoms() + "')";
                    System.out.println("UPDATE: " + st.executeUpdate(sentencia));
                    //tanca el recurs 
                }
                afegit = true;
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex.getMessage());
            afegit = false;
        }
        return afegit;
    }

    /**
     * Methodo para borrar en usuario, por parametros le pasao un nif de usuario
     * y los busca en base de datos y lo borra a ese usuario. Devuelvo un true
     * si lo consigue sino devuelve un false.
     *
     * @param nif
     * @return
     */
    public boolean esborrar(String nif) {
        boolean eliminat = false;

        try {
            try (Statement st = con.createStatement()) {
                st.executeUpdate("DELETE FROM USUARIS WHERE nif='" + nif + "'");
                eliminat = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return eliminat;
    }

    /**
     * Methodo booleano que por parametros le paso un objeto usuario y tiene una
     * sentencia sql, que lo busca al usuario de dni que le pasamos y nos deja
     * modificar su nombre y apellido. devuelvo un true se consigue modificar si
     * no devuelve un fals
     *
     * @param user
     * @return
     */
    public boolean modificar(Usuari user) {
        boolean modificat = false;
        PreparedStatement ps;

        try {
            String sentencia = "UPDATE USUARIS SET nom = ? , cognoms = ? WHERE nif = ?";
            ps = con.prepareStatement(sentencia);
            ps.setString(1, user.getNom());
            ps.setString(2, user.getCognoms());
            ps.setString(3, user.getNif());
            ps.executeUpdate();
            modificat = true;
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modificat;
    }

    /**
     * Methodo que por parametros le paso un nif y este methodo busca el usaurio
     * de este nif, y lo muestra.
     *
     * @param nif
     * @return
     */
    public Usuari Cercar(String nif) {

        Usuari user = null;
        ResultSet rs;
        try {
            try (Statement st = con.createStatement()) {
                rs = st.executeQuery("SELECT * FROM USUARIS WHERE nif='" + nif + "'");
                if (rs.next()) {
                    user = new Usuari(rs.getString(1), rs.getString(2), rs.getString(3));
                    System.out.println("Nom: " + user.getNom() + " Cognoms: " + user.getCognoms());
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    /**
     * Methodo que crea una lista de usuarios, con un bucle while mientras hay
     * filas en base de datos va anadiendo los usuario en la lista y lo va
     * mostrando.
     *
     * @return
     */
    public List<Usuari> cercarTots() {

        ArrayList<Usuari> llista = new ArrayList();
        ResultSet rs;

        try {
            try (Statement st = con.createStatement()) {
                rs = st.executeQuery("SELECT * FROM USUARIS");
                int num = 0;
                while (rs.next()) {
                    llista.add(new Usuari(rs.getString(1), rs.getString(2), rs.getString(3)));

                    System.out.println(" Dni:" + llista.get(num).getNif() + " Noms: " + llista.get(num).getNom() + " Cognoms:" + llista.get(num).getCognoms());
                    num++;

                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return llista;
    }

}
