/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.OrdonezVivancosHector.model;

import edu.ub.prog2.utils.model.*;
import java.io.*;
import java.util.*;


/**
 *
 *@author Hector Ordonez
 * 
 *Classe usada com a distribuidor dins del paquet model
 * 
 */
public class DadesVisor implements Serializable {
    private int contadorID = 0;
    private LlistaImatges biblioteca;
    private ArrayList<Album> llistaAlbums;
    private boolean aleatori;

    
    /**
    * Constructor de la classe DadesVisor on es crea un LlistaFile
    * 
    */
    public DadesVisor(){
         biblioteca = new LlistaImatges();
         llistaAlbums = new ArrayList<Album>();
         aleatori = false;
    }
       
    /**
    * Funcio que elimina un fitxer segons la id.
    * 
    *@param int i, es la id de la imatge a borrar
    */
    public void eliminarImatge(int idima){
        Iterator itrLlistaAlbum = llistaAlbums.iterator();
        Album alb = null;
        while(itrLlistaAlbum.hasNext()){
            alb = (Album) itrLlistaAlbum.next();  
            alb.eliminarImatge(idima);
        }
        biblioteca.eliminarImatge(idima);
    }

    /**
    * Funcio que afegeix un fitxer a la llista amb el atribut f i una id.
    * 
    *@param File f, es passa el fitxer per afegirlo
    * 
    * @return: retorna un int que es a id
    */ 
    public int afegirImatge(File f){
        biblioteca.afegirImatge(f, contadorID);
        int x1 = contadorID;
        contadorID++;
        return x1;
    }
    
    /**
    * Funcio que busca el fitxer amb la mateixa id a la llista i afegeix el que falta
    * 
    *@param IFitxer fil, es passa el fitxer per afegir el que queda
    *@param int i, es passa la id
    */ 
    public void afegiFitxer(FitxerImatge fil, int i){
        biblioteca.afegiFitxer(fil, i);
    }
    

    
    /**
    * Funcio que guarda en un fitxer el DadesVisor
    * 
    *@param String nomarxiu, adreça on es vol guardar l'arxiu
    * 
    *@throws: FileNotFoundException, en cas de no trobar l'arxiu i IOException, en cas d'error IO
    */
    public void guardarFitxer(String nomarxiu) throws FileNotFoundException, IOException{
        File Llistfitxer = new File(nomarxiu);
        //F:\\PII\\Laboratori\\Visor\\Fitxers\\Fitxer.txt
        FileOutputStream fout= new FileOutputStream(Llistfitxer);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
        fout.close();
          /**oos.close();    */

    }
    
    /**
    * Funcio que recupera d'un fitxer un el DadesVisor
    * 
    *@param String nomarxiu, adreça on es vol recuperar l'arxiu
    * 
    *@throws: FileNotFoundException, en cas de no trobar l'arxiu i IOException, en cas d'error IO
    */
    public DadesVisor recuperarFitxer(String nomarxiu) throws FileNotFoundException, IOException, ClassNotFoundException{
        // F:\\PII\\Laboratori\\Visor\\Fitxers\\Fitxer.txt
        File Llistfitxer = new File(nomarxiu);
        FileInputStream fin=new FileInputStream(Llistfitxer);
        ObjectInputStream ois = new ObjectInputStream(fin);
        DadesVisor noudadesvisor = (DadesVisor) ois.readObject();
        fin.close();
        return noudadesvisor;
        }
    
        /**
    * Funcio que crea un nou album i lafageix a la llista
    * 
    *@param String nom, que es el nom de lalbum
    * 
    */
    public void crearAlbum(String nom){
        Album noualbum = new Album(nom);
        llistaAlbums.add(noualbum);
    }
            /**
    * Funcio que afegeix una imatge a lalbum
    * 
    *@param String nomalbum, que es el nom de lalbum,
    * 
    *@param int idimatge que es la id de la imatge
    */
    public void afegirImatgeAlbum(String nomalbum, int idimatge){
        FitxerImatge imatge_a_afegir = biblioteca.getImatgeperid(idimatge);
        Album album_on_safegeix = getAlbumperNom(nomalbum);
        if (album_on_safegeix != null){
            if(imatge_a_afegir != null){
                album_on_safegeix.afegirFitxerImatge(imatge_a_afegir);  
            }

        }

        
    }
               /**
    * Funcio que crea lalbum complet amb tots els parametres
    * 
    *@param String nom, que es el nom de lalbum,
    * 
    *@param String autor es el nom de lautor
    *@param String lloc es el nom del lloc
    *@param String tema es el tema de lalbum
    *@param String tipus es el tipus de lalbum
    */ 
    public void crearAlbumComplet(String nom, String autor, String lloc, String tema, String tipus){
        Iterator<Album> itrAlbums = llistaAlbums.iterator();
        while(itrAlbums.hasNext()){
            Album albumdintre = (Album) itrAlbums.next();        
            if(albumdintre.getNom().equals(nom)){
                albumdintre.setAutor(autor);
                albumdintre.setLloc(lloc);
                albumdintre.setTipus(tipus);
                albumdintre.setTema(tema);
                albumdintre.setData(Calendar.getInstance().getTime());
            }
        }
    }
                         /**
    * Metode que retorna la LListaImatges
     * @return biblioteca
    * 
    */   
    public LlistaImatges getBiblioteca() {
        return biblioteca;
    }
                         /**
    * Metode que guarda una LlistaImatges
     * @param LlistaImatges biblioteca
    * 
    */  
    public void setBiblioteca(LlistaImatges biblioteca) {
        this.biblioteca = biblioteca;
    }
                             /**
    * Metode que retorna l'array t'albums
     * @return ArrayList<Album> llistaAlbums
    * 
    */  
    public ArrayList<Album> getArrayAlbums() {
        return llistaAlbums;
    }
                         /**
    * Metode que retorna la el contador de les ID
     * @return int contadorID
    * 
    */   
    public int getContadorID() {
        return contadorID;
    }
                         /**
    * Metode que guarda el contador de les ID
     * @param int contadorID
    * 
    */  
    public void setContadorID(int contadorID) {
        this.contadorID = contadorID;
    }
                             /**
    *Metode que retorna un Fitxer passant-li la ID
     * @return FitxerImatge amb la mateixa id
    * 
    */   
    public FitxerImatge getFitxerperID(int fitxerid){
        return biblioteca.getImatgeperid(fitxerid);
    }
                                 /**
    *Metode que retorna un Fitxer passant-li el nom
     * @return FitxerImatge amb el mateix nom
    * 
    */   
    public FitxerImatge getImatgeperNom(String fitxernom){
        return biblioteca.getImatgeperNom(fitxernom);
    }
                             /**
    * Metode que guarda si l aleatoriesta activat
     * @param boolean noualeatori
    * 
    */  
    public void setAleatori(boolean noualeatori){
       this.aleatori = noualeatori;
    }
                                 /**
    *Metode que retorna si l aleatori esta activat
     * @return aleatori
    * 
    */   
    public boolean getAleatori(){
        return this.aleatori;
    }
    
                         /**
    * Metode que guarda una array d'Albums
     * @param ArrayList<Album> llistaAlbums
    * 
    */  
    public void setLlistaAlbums(ArrayList<Album> llistaAlbums) {
        this.llistaAlbums = llistaAlbums;
    }
                             /**
    * Metode que retorna luna llista de Ifitxers
     * @return IFitxer[]
    * 
    */   
    public IFitxer[] getLlistaFotos(){
        return biblioteca.getLlistaFotos();
    }
    /**
    * Funcio que agafa lalbum passantli un nom
    * 
    *@param String nomalbum, que es el nom de lalbum
    *@return: retorna un album
    */
    public Album getAlbumperNom(String nomalbum){
        Album alb;
        Iterator itrAlbum = llistaAlbums.iterator();
        while(itrAlbum.hasNext()){
            alb = (Album) itrAlbum.next();        
            if(alb.getNom().equals(nomalbum)){
                return alb;
            }
        }
        return null;
    }
        /**
    * Funcio que elimina lalbum amb el nom que li passes
    * 
    *@param String nomaborrar, que es el nom de lalbum a borrar
    */ 
    public void eliminarAlbum(String nomaborrar){
        Iterator itrAlbum = llistaAlbums.iterator();
        Album italbum;
        int cnt = 0;
        Boolean trobat = false;
        while(itrAlbum.hasNext() && !trobat){
            italbum = (Album) itrAlbum.next();
            if(italbum.getNom().equals(nomaborrar)){
                trobat = true;
            }
            else{
                cnt++;
            }
        }
        if(trobat){
            llistaAlbums.remove(cnt);
        }
    }
        /**
    * Funcio que agafa tots els noms dels albums
    * 
    *@return: linia que es on es guarden els noms dels albums
    */
    public String mostrarNomAlbums(){
        String linia = "";
        Iterator itrAlbum = llistaAlbums.iterator();
        Album italbum;
        while(itrAlbum.hasNext()){
            italbum = (Album) itrAlbum.next();
            linia = linia + italbum.getNom()+ "\n";    
        }
        return linia;
    }
            /**
    * Funcio que retorna una llista de Strings amb els noms dels albums
    * 
    *@return: linia que es on es guarden els noms dels albums
    */
      public String[] getLlistaAlbums(){
        String[] linia = new String[llistaAlbums.size()];
        Iterator itrAlbum = llistaAlbums.iterator();
        Album italbum;
        int i = 0;
        while(itrAlbum.hasNext()){
            italbum = (Album) itrAlbum.next();
            linia[i] = italbum.getNom();
            i++;
        }
        return linia;
    }
    
    /**
    * Funcio que elimina una imatge de lalbum
    * 
    *@param String nomaalbum, que es el nom de lalbum don vols borrar
    *@param int idalbum, es la ide de la imatge a eliminar
    */    
    public void eliminarImatgeAlbum(String nomalbum, int idalbum){
        Album nou = getAlbumperNom(nomalbum);
        nou.eliminarImatge(idalbum);
    }
    
    
}