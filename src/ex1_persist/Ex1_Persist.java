/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1_persist;

import Persistence.ConfiguracioConnexio;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author ALUMNEDAM
 */
public class Ex1_Persist {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        
        ConfiguracioConnexio con = new ConfiguracioConnexio();
        
        //con.getCon();
        
        try {
            con.getCon();
        } catch(Exception ex){
            System.out.println("Error al conectar");
        }
        
        System.out.println("Elige un opcion: \n"
                + "1. Afegir. \n"
                + "2. Afegir Llista. \n"
                + "3. Esborrar. \n"
                + "4. Modificar. \n"
                + "5. Cerca per nif. \n"
                + "6. Cerca Tots. \n"
                + "7. Sortir. \n");

        int op = lector.nextInt();
        
        switch (op) {
            case 1:
                

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                
                break;
            case 7:
                
                con.tancarCon();
                System.exit(0);

        }

    }

}
