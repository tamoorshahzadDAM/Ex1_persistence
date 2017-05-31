/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Usuari;
import Persistence.ConfiguracioConnexio;
import Persistence.PersistUsuari;
import Vista.VistaText;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Tamoor
 */
public class GestioUsuaris {

    //Intancias de clases
    ConfiguracioConnexio conConf = new ConfiguracioConnexio();
    Connection con = conConf.getConnexio();
    Usuari user;
    PersistUsuari puser = new PersistUsuari(con);
    VistaText vista = new VistaText();

    /**
     * Methodo que muestra mensaje si ha anadi el usuario o no
     *
     * @param user
     */
    public void afegir(Usuari user) {

        boolean arregar = puser.afegir(user);
        if (arregar == true) {
            System.out.println("Arregado");
        } else {
            System.err.println("No se ha podido arregar");
        }
    }

    /**
     * MEthodo que muestra mensaje de si ha anadirdo una lista o no
     *
     * @param lista
     */
    public void afegirLlista(List<Usuari> lista) {
        boolean arregar = puser.afegirArray(lista);
        if (arregar == true) {
            System.out.println("Arregado La lista");
        } else {
            System.err.println("No se ha podido arregar la lista");
        }
    }

    /**
     * MEthodo que muestra mensaje de si ha borrado el usuario o no
     *
     * @param nif
     */
    public void eliminar(String nif) {
        boolean eliminar = puser.esborrar(nif);
        if (eliminar == true) {
            System.out.println("Eliminado");
        } else {
            System.err.println("No se ha podido eliminar");
        }
    }

    /**
     * MEthodo que muestra mensaje de si ha modificado los datos de usuarios o
     * no
     *
     * @param user
     */
    public void modficar(Usuari user) {
        boolean modificado = puser.modificar(user);
        if (modificado == true) {
            System.out.println("Modificado");
        } else {
            System.err.println("No se ha podido Modificar");
        }
    }

    /**
     * MEthodo que muestra el usuario buscado por el dni
     *
     * @param dni
     */
    public void cercarNif(String dni) {
        Usuari user = puser.Cercar(dni);
        System.out.println(user.toString());
    }

    /**
     * MEthodo que muestra todos los usarios existentes.
     */
    public void cercaTots() {
        List<Usuari> user = puser.cercarTots();
        for (int i = 0; i < user.size(); i++) {
            user.get(i).toString();
        }
    }

}
