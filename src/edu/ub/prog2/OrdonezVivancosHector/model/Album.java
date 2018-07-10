/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.OrdonezVivancosHector.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Héctor
 */
public class Album extends LlistaImatges implements Serializable  {
    private String nom;
    private String tipus;
    private Date data;
    private String lloc;
    private String tema;
    private String autor;
   
    
    /**
    * Constructor buit
    * 
    */
    public Album() {
        this.nom = "";
        this.tema = "";
        this.tipus = "";
        this.lloc = "";
        this.autor = "";
        this.llistadimatges = new ArrayList<FitxerImatge>();
        
    }
    
            /**
    * Constructor on es passa la variable de tipus String
    *
    * @param String noom, es el nom de lalbum
    */
    public Album(String noom) {
        this.nom = noom;
    }

                         /**
    * Metode que retorna del nom de l'autor
     * @return String autor
    * 
    */   
    public String getAutor() {
        return autor;
    }
                         /**
    * Metode que retorna la data de Lalbum
     * @return Date data
    * 
    */   
    public Date getData() {
        return data;
    }
                         /**
    * Metode que retorna el lloc de l'Album
     * @return String lloc
    * 
    */   
    public String getLloc() {
        return lloc;
    }
                         /**
    * Metode que retorna el nom de l'Album
     * @return String nom
    * 
    */    
    public String getNom() {
        return nom;
    }
                         /**
    * Metode que retorna el tema de l'Album
     * @return String tema
    * 
    */  
    public String getTema() {
        return tema;
    }
                         /**
    * Metode que retorna el tipus de l'Album
     * @return String tipus
    * 
    */  
    public String getTipus() {
        return tipus;
    }

                         /**
    * Metode que guarda el nom d'Album
     * @param String autor
    * 
    */  
    public void setAutor(String autor) {
        this.autor = autor;
    }
                         /**
    * Metode que guarda la data de l'Album
     * @param Date data
    * 
    */  
    public void setData(Date data) {
        this.data = data;
    }
                         /**
    * Metode que guarda el lloc de l'Album
     * @param String lloc
    * 
    */  
    public void setLloc(String lloc) {
        this.lloc = lloc;
    }
                         /**
    * Metode que guarda el nom de l'Album
     * @param String nom
    * 
    */  
    public void setNom(String nom) {
        this.nom = nom;
    }
                         /**
    * Metode que guarda el tema d'Album
     * @param String tema
    * 
    */  
    public void setTema(String tema) {
        this.tema = tema;
    }
                         /**
    * Metode que guarda tipus d'Album
     * @param String tipus
    * 
    */  
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
            
            /**
    * Funcio que modifica el metode d'impresio del Album
    * 
    * @return: retorna el String a imprimir
    * 
    */
    @Override
    public String toString(){
        return nom;
    }

}
