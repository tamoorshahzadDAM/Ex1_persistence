/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_persist;

import Persistence.ConfiguracioConnexio;
import Vista.VistaText;

/**
 *
 * @author Tamoor
 */
public class Ex1_Persist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConfiguracioConnexio con = new ConfiguracioConnexio();

        VistaText vista = new VistaText();
        //Abrir conexion
        if (!con.getCon()) {
            con.getCon();

        }
        //Llamar a methodo de menu principal
        vista.menuPrincipal();
    }
}
