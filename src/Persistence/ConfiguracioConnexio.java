/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.*;

/**
 *
 * @author ALUMNEDAM
 */
public class ConfiguracioConnexio {

    private Connection con;
    private String cadenaConnection = "jdbc:oracle:thin:@192.168.180.10:1521:INSLAFERRERI";
    private String usuari = "Tamoor";
    private String contrasenya = "1234";

    public ConfiguracioConnexio() {

        ConfiguracioConnexio(cadenaConnection, usuari, contrasenya);
    }

    public void ConfiguracioConnexio(String cadenaConnection, String usuari, String contrasenya) {
        this.cadenaConnection = cadenaConnection;
        this.usuari = usuari;
        this.contrasenya = contrasenya;
    }

    public Connection getCon() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(cadenaConnection, usuari, contrasenya);
            System.out.println("Conexion oberta");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return con;
    }
    
    public void tancarCon(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con.close();
            System.out.println("Conexion Tancat");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
