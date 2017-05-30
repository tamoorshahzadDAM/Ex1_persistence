/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ALUMNEDAM
 */
public class Usuari {
    
    //Atributos
    private String nif;
    private String nom;
    private String cognoms;

    /**
     * Constructor vacio
     */
    public Usuari() {
    }

    /**
     * Constructor
     * @param nif
     * @param nom
     * @param cognoms 
     */
    public Usuari(String nif, String nom, String cognoms) {
        this.nif = nif;
        this.nom = nom;
        this.cognoms = cognoms;
    }

    //MEthodos get y sets de las variables.
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    /**
     * MEthodo to string para mostrar usuarios.
     * @return 
     */
    @Override
    public String toString() {
        return "Usuari{" + "nif=" + nif + ", nom=" + nom + ", cognoms=" + cognoms + '}';
    }
    
    
    
    
}
