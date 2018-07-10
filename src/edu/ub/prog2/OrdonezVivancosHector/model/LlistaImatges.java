/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.OrdonezVivancosHector.model;

import edu.ub.prog2.utils.model.IFitxer;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Hector Ordonez
 */
public class LlistaImatges implements Serializable {
        protected ArrayList<FitxerImatge> llistadimatges;


        /**
    * Constructor de la classe LlistaImatges on es crea una llista d'imatges
    * 
    */
    public LlistaImatges() {
            llistadimatges = new ArrayList<FitxerImatge>();
    }
    /**
    * Get que retorna una array de FitxerImatge
     * @return llistadimatges
    * 
    */            
     public ArrayList<FitxerImatge> getLlistaImatge() {
        return llistadimatges;
    }
    /**
    * Set que guarda una array de FitxerImatge
     * @param  ArrayList<FitxerImatge> fitxerimatge, que es una Array De FitxerImatge
    * 
    */  
    public void setLlistadimatge(ArrayList<FitxerImatge> fitxerimatge) {
        this.llistadimatges = fitxerimatge;
    }
            /**
    * Metode afegeix un FitxerImatge a la llistadimatges
    * 
    *@param FitxerImatge fitxer_a_afegir, que es el fitxer a afegir
    */ 
    public void afegirFitxerImatge(FitxerImatge fitxer_a_afegir){
        this.llistadimatges.add(fitxer_a_afegir);
    }
        /**
    * Metode que elimina una imatge per la id
    * 
    *@param int idima, que es la id de la imatge
    */ 
    public void eliminarImatge(int idima){
        Iterator itrFitxer = llistadimatges.iterator();
        FitxerImatge fitima = null;
        Boolean trobat = false;
        int posicio = 0;
        while(itrFitxer.hasNext() && !trobat){
            fitima= (FitxerImatge) itrFitxer.next();        
            if(fitima.getId() == idima){
                trobat = true;
            }
            else{
                posicio++;
            }
        }
        if(trobat){
            llistadimatges.remove(posicio);
        }
    }
        /**
    * Funcio que agafa un fitxerImatge per la id.
    * 
    *@param int idimatge, es la id
    * 
    * @return: retornes un FitxerImatge
    */ 
    public FitxerImatge getImatgeperid(int idimatge){
        Iterator itrFitxer = llistadimatges.iterator();
        FitxerImatge fitima = null;
        while(itrFitxer.hasNext()){
            fitima= (FitxerImatge) itrFitxer.next();        
            if(fitima.getId() == idimatge){
                return fitima;
            }
        }
        return null;
    }
            /**
    * Funcio que agafa un fitxerImatge per el nom.
    * 
    *@param String nomimatge, es el nom
    * 
    * @return: retornes un FitxerImatge
    */ 
    public FitxerImatge getImatgeperNom(String nomimatge){
        Iterator itrFitxer = llistadimatges.iterator();
        FitxerImatge fitima = null;
        while(itrFitxer.hasNext()){
            fitima= (FitxerImatge) itrFitxer.next();        
            if(fitima.getCami().getName() == nomimatge){
                return fitima;
            }
        }
        return null;
    }
    
    /**
    * Funcio que afegeix un fitxer a la llista amb el atribut f i una id.
    * 
    *@param File f, es passa el fitxer per afegirlo
    * 
    * @return: retorna un int que es a id
    */ 
    public void afegirImatge(File f, int contaid){
        FitxerImatge fit = new FitxerImatge();
        fit.setCami(f);
        fit.setId(contaid);
        llistadimatges.add(fit);
    }
    
    /**
    * Funcio que busca el fitxer amb la mateixa id a la llista i afegeix el que falta
    * 
    *@param IFitxer fil, es passa el fitxer per afegir el que queda
    *@param int i, es passa la id
    */ 
    public void afegiFitxer(FitxerImatge fil, int i){
        Iterator itrFitxer = llistadimatges.iterator();
        FitxerImatge file;
        fil.setId(i);
        while(itrFitxer.hasNext()){
            file = (FitxerImatge) itrFitxer.next();        
            if(file.getId()== fil.getId()){
                file.setDataInsercio(fil.getData());
                file.setTipus(fil.getTipus());
                file.setAutor(fil.getAutor());
                file.setResolucio(fil.getResolucio());
                file.setPosicio(fil.getLatitud(),fil.getLongitud());
            }
        }
    }
    
                    /**
    * Funcio que mostra el tamany de la taula
    * 
     * @return tamany de llista imatgess
    */
    public int getTamany(){
        return llistadimatges.size();
    }
    
    
    /**
    * Funcio que retorna una Llista de Fotos
    * @return IFitxer[], retorna una llista de IFitxer[]
    */
    public IFitxer[] getLlistaFotos(){
        IFitxer[] linia = new FitxerImatge[llistadimatges.size()];
        Iterator itrimatge = llistadimatges.iterator();
        int i = 0;
        while(itrimatge.hasNext()){
            linia[i] = (FitxerImatge) itrimatge.next();
            i++;
        }
        return linia;  
    }
        
            /**
    * Funcio que modifica el metode d'impresio del LlistaImatges
    * 
    * @return: retorna el String a imprimir
    * 
    */
    @Override
    public String toString(){
        int contador = 1;
        Iterator itrFitxer = llistadimatges.iterator();
        Fitxer file;
        String linia = "";
        if(llistadimatges.isEmpty()){
            linia = "[Llista Buida]";
            return linia;
        }
        else{
            while(itrFitxer.hasNext()) {
            file = (Fitxer) itrFitxer.next();
            int pos = file.getCami().getName().lastIndexOf(".");
            if(pos != -1){
                linia = linia +"\n"+ "\nPosicio: " + contador + "\n" + "--------------------------\n" + "Nom: " + file.getCami().getName() + "\nExtensió: " + file.getCami().getName().substring(pos)  + "\nId: " + file.getId() + "\nCami: " + file.getCami().getParent() + "\nData: " + file.getData()+ "\n"+ "Tipus: " + file.getTipus() ;
            }
            else{
                linia = linia +"\n"+ "\nPosicio: " + contador + "\n" + "--------------------------\n" + "Nom: " + file.getCami().getName() + "\nExtensió:  "  + "\nId: " + file.getId() + "\nCami: " + file.getCami().getParent() + "\nData: " + file.getData()+ "\n"+ "Tipus: " + file.getTipus() ;
               }
            ++contador;
            }
            return linia;
        }
    }
    
        
}
