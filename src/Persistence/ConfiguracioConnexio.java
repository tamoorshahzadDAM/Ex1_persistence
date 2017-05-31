package Persistence;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tamoor
 */
public class ConfiguracioConnexio {

    private Connection con = null;
    private String driver = "oracle.jdbc.driver.OracleDriver";//Classe Driver
    private String cadenaConnexio = "jdbc:oracle:thin:@192.168.180.10:1521:INSLAFERRERI";
    private String usuari = "TAMOOR";
    private String contrasenya = "1234";

    public ConfiguracioConnexio() {
    }

    public ConfiguracioConnexio(String driver, String cadenaConnexio, String usuari, String contrasenya) {
        this.driver = driver;
        this.cadenaConnexio = cadenaConnexio;
        this.usuari = usuari;
        this.contrasenya = contrasenya;
    }

    /**
     * Carrega la classe Driver de la llibreria jdbc per a Oracle, obté una
     * instància de la classe Connection, amb la connexió oberta amb el SGBD a
     * la BD indicada a la cadena de connexió.
     *
     * @return torna true si s'estableix la connexió i false en cas contrari.
     */
    public boolean getCon() {
        boolean comprova = false;

        try {
            Class.forName(driver); //es carrega la classe Driver
            con = DriverManager.getConnection(cadenaConnexio, usuari, contrasenya);
            comprova = true;
            System.out.println("Connexió establerta");

            System.out.println(con.getMetaData().getDatabaseProductVersion());
            System.out.println(con.getMetaData().getDriverName());
            System.out.println(con.getMetaData().getUserName());

        } catch (SQLException e) {
            System.out.println("Problemes amb la connexió: \n" + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfiguracioConnexio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comprova;
    }

    /**
     * Comprova si l'objecte Connection s'ha creat i es troba oberta, en aquest
     * cas tanca la connexió.
     *
     * @return true si la connexió estava oberta i es tanca, false en cas de no
     * estar creat l'objecte Connection o que ja estava tancada.
     */
    public boolean tancarConnexio() {
        boolean comprova = false;
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                comprova = true;
                System.out.println("Connexió tancada.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return comprova;
    }

    public Connection getConnexio() {
        if (con == null) {
            this.getCon();
        }
        return con;
    }

//    public boolean esOberta() {
//        return esOberta;
//    }
}
