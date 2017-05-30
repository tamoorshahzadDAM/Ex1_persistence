/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.GestioUsuaris;
import Model.Usuari;
import Persistence.ConfiguracioConnexio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ALUMNEDAM
 */
public class VistaText {

    Scanner lector = new Scanner(System.in);

    ConfiguracioConnexio con = new ConfiguracioConnexio();

     
    public void menuPrincipal() {

        System.out.println("Elige un opcion: \n"
                + "1. Afegir. \n"
                + "2. Afegir Llista. \n"
                + "3. Esborrar. \n"
                + "4. Modificar. \n"
                + "5. Cerca per nif. \n"
                + "6. Cerca Tots. \n"
                + "7. Sortir. \n");

        int op = lector.nextInt();
        GestioUsuaris gu = new GestioUsuaris();
        switch (op) {
            case 1:
                //Afegir

                System.out.println("Introduce el dni");
                String dni = lector.next();
                System.out.println("Introduce el nombre");
                String nombre = lector.next();
                System.out.println("Introduce el apellido");
                String apellido = lector.next();
                Usuari user = new Usuari(dni, nombre, apellido);
                gu.afegir(user);
                break;
            case 2:

                //Afegir una lista
                int numUsers= 4;
                List<Usuari> lista = new ArrayList<Usuari>();
                for (int i = 0; i <= numUsers; i++) {
                    System.out.println("Introduce el dni");
                    String dniLlista = lector.next();
                    System.out.println("Introduce el nombre");
                    String nombreLlista = lector.next();
                    System.out.println("Introduce el apellido");
                    String apellidoLlista = lector.next();

                    Usuari userLlista = new Usuari(dniLlista, nombreLlista, apellidoLlista);
                    lista.add(0, userLlista);
                }

                gu.afegirLlista(lista);

                break;
            case 3:

                //Borrar el usuario
                System.out.println("Introduce el dni para borar: ");
                String nif = lector.next();
                gu.eliminar(nif);

                break;
            case 4:

                //Modificar datos de usuario
                System.out.println("Introduce el dni del usuario que quieres modificar");
                String dniMod = lector.next();
                System.out.println("Introduce el nombre");
                String nombreMod = lector.next();
                System.out.println("Introduce el apellido");
                String apellidoMod = lector.next();

                Usuari userMod = new Usuari(dniMod, nombreMod, apellidoMod);
                gu.modficar(userMod);

                break;
            case 5:

                //Busquedo por dni
                System.out.println("Introduce el dni para buscar");
                String dniBuscar = lector.next();
                gu.cercarNif(dniBuscar);

                break;
            case 6:
                //Muestra todos los usuarios
                 gu.cercaTots();

                break;
            case 7:

                //Cierra conexion
                if (con.esOberta()) {
                    con.tancarCon();
                    System.out.println("Conexion cerrado.");
                }

                //Sale de applicaion
                System.exit(0);

        }

    }

}
