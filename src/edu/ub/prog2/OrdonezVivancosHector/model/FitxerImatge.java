/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.OrdonezVivancosHector.model;

import java.io.File;

/**
 *
 * @author mat.aules
 */
public class FitxerImatge extends Fitxer{
    private String nom;
    private String autor;
    private double resolucio;

    
        /**
    * Constructor buit
    * 
    */
    public FitxerImatge() {
        this.nom = "";
        this.autor = "";
        this.resolucio = 0.0;
    }
    
    public FitxerImatge(File file) {
        this.nce = file;
    }  
        /**
    * Get que retorna el nom de lautor del fitxer
    * @return String, autor
    */
    public String getAutor() {
        return autor;
    }
            /**
    * Set on es passa un atribut de tipus String
    *
    * @param String autor, es el nom lautor de la imatge
    */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
    * Get que retorna el nom del fitxer
    * @return String, nom
    */
    public String getNom() {
        return nom;
    }
    
            /**
    * Set on es passa un atribut de tipus String
    *
    * @param String nom, es el nom de la imatge
    */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
    * Get que retorna la resolucio del fitxer
    * @return double, resolucio
    */
    public double getResolucio() {
        return resolucio;
    }
            /**
    * Set on es passa un atribut de tipus double
    *
    * @param double resolucio, es la resolucio de la imatge
    */
    public void setResolucio(double resolucio) {
        this.resolucio = resolucio;
    }
            /**
    * Funcio que modifica el metode d'impresio del Fitxer Imatge
    * 
    * @return: retorna el String a imprimir amb el nom
    * 
    */
    @Override
    public String toString(){
        return nce.getName();
    }

}
