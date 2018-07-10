/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.OrdonezVivancosHector.model;

import edu.ub.prog2.utils.model.GeoPosition;
import edu.ub.prog2.utils.model.IFitxer;
import java.io.*;
import java.util.*;

/**
 *
 * @author Hector Ordonez
 * 
 * La classe Fitxer, amb atributs nom, cami, extensio, data, tipus i id
 */
public class Fitxer implements IFitxer, Serializable{
    protected File nce;
    protected Date data;
    protected FileType tipus;
    protected int id;
    protected GeoPosition coordenades;
    
    
    
    /**
    * Constructor buit
    * 
    */
    public Fitxer(){
        this.nce = null;
        this.coordenades = null;
        this.data = Calendar.getInstance().getTime();
        this.tipus = null;
    }
        /**
    * Constructor on es passa la variable de tipus File
    *
    * @param File s, es larxiu a assignar
    */
    public Fitxer(File s){
        this.nce = s;
    }
    
        /**
    * Constructor on es passa la variable de tipus File, de tipus Date i de tipus FileType
    *
    * @param File n, es larxiu a assignar
    * @param Date d, es la data a assignar
    * @param FileType t, es el tipus a assignar
    */
        public Fitxer(File n, Date d, FileType t){
        this.nce = n;
        this.data = d;
        this.tipus = t;
    }
    
        
        /**
    * Set on es passa la id
    *
    * @param int i, es la id que es vol assignar
    */
    @Override
    public void setId(int i) {
       this.id = i;
    }
        /**
    * Set on es passa un atribut tipus File
    *
    * @param File file, es el file que es vol assignar
    */
    @Override
    public void setCami(File file) {
        this.nce = file;
    }
    
        /**
    * Set on es passa el tipus del Fitxer
    *
    * @param Filetype ft, es el tipus del fitxer
    */
    @Override
    public void setTipus(FileType ft) {
        this.tipus = ft;
    }

            /**
    * Set on es passa un atribut de tipus Date
    *
    * @param Date date, es la data que es vol assignar
    */
    @Override
    public void setDataInsercio(Date date) {
        this.data = date;
    }
            /**
    * Set on es passen dos atributs del tipus doubl
    *
    * @param double d, es una de les cordenades que es vol assignar
    * @param double d1, es una altra de les cordenades que es vol assignar
    */
    @Override
    public void setPosicio(double d, double d1) {
        this.coordenades = new GeoPosition(d,d1);
    }

                /**
    * Get on es retorna el camí en un tipus File
    *
    * @return this.nce tipus File
    */
    @Override
    public File getCami() {
        return this.nce;
    }
    
    /**
    * Get que retorna la data del fitxer
    * @return Date, data
    */
    @Override
    public Date getData() {
        return this.data;
    }
    
    /**
    * Get que retorna el tipus del fitxer
    * @return FileType, tipus
    */
    @Override
    public FileType getTipus() {
        return this.tipus;
    }
    /**
    * Get que retorna la latitud del fitxer
    * @return double, latitud
    */
    @Override
    public double getLatitud() {
        return this.coordenades.getLatitude();
    }
    /**
    * Get que retorna la longitud del fitxer
    * @return double, longitud
    */
    @Override
    public double getLongitud() {
        return this.coordenades.getLongitude();
    }
    /**
    * Get que retorna la id del fitxer
    * @return int, id
    */
    @Override
    public int getId() {
        return this.id;
    }
}
