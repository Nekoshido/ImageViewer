/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.OrdonezVivancosHector.controlador;

import edu.ub.prog2.OrdonezVivancosHector.model.*;
import edu.ub.prog2.utils.ctrl.BasicController;
import edu.ub.prog2.utils.ctrl.ImagePanel;
import edu.ub.prog2.utils.model.IFitxer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


/**
 *
 * @author Hector Ordonez
 * 
 * Controlador del VisorUB
 * 
 */
public class CtrlVisorUB extends BasicController{
    
    private DadesVisor dadvis;
    private int posicio;
    private boolean engegat;
    private boolean espotreprendre;
    private String nomalbumvisualitzar;
    private int[] vector;
    
    public CtrlVisorUB(){
         dadvis = new DadesVisor();
         posicio = 0;
         engegat = false;
         espotreprendre = false;
         nomalbumvisualitzar = null;
    }
               /**
    * Metode que enllaça amb el crearAlbum de DadesVisor
    * 
    *  @param String string, nom de lalbum
    */
    @Override
    public void crearAlbum(String string) {
        dadvis.crearAlbum(string);
    }
    
               /**
    * Metode que enllaça amb el eliminarAlbum de DadesVisor
    * 
    *  @param String string, nom del fitxer a eliminar
    */
    @Override
    public void eliminarAlbum(String string) {
        dadvis.eliminarAlbum(string);
    }
               /**
    * Metode que enllaça amb el afegirImatge de DadesVisor
    * 
    *  @param File file, fitxer a afegir
    */
    @Override
    public int afegirImatge(File file) {
        return dadvis.afegirImatge(file);
    }

               /**
    * Metode que enllaça amb el afegirImatgeAlbum de DadesVisor
    * 
    *@param String string, nom de lalbum
    *@param int i, id de la imatge
    */
    @Override
    public void afegirImatgeAlbum(String string, int i) {
        dadvis.afegirImatgeAlbum(string, i);
    }


               /**
    * Metode que retorna del DadesVisor la biblioteca per poderla imprimir
    * @return getBiblioteca(), es a dir, retorna la biblioteca per poderla imprimir
    */
    public LlistaImatges visualitzarBiblioteca(){
        return dadvis.getBiblioteca();
    }
    
                   /**
    * Metode que sobreescriu el visualitzarTot() i serveix per visualitzar la biblioteca
    * 
    */
    @Override
    public void visualitzarTot() {
        posicio =0;
        vector = new int[dadvis.getBiblioteca().getTamany()];
        for(int i= 0; i < vector.length; i++) vector[i] = i;
        if(dadvis.getAleatori()){
            shuffleLlista(vector);
            for(int i= 0; i < vector.length; i++) System.out.println((vector[i]));
        }
        engegat = true;
        espotreprendre = true;
        
    }
    
                       /**
    * Metode que desordena un vector
    * @param int[] vector, vector de posicions d'imatges
    */
    public void shuffleLlista(int[] vector) {
        int tamany = vector.length;
	Random random = new Random();
	random.nextInt();
	for (int i = 0; i < tamany; i++) {
		int canvi = i + random.nextInt(tamany - i);
		intercanviar(vector, i, canvi);
		}
	}
    
                       /**
    * Metode que secundari que intercanvia posicions en un vector
    * 
    * @param int[] vector, vector de posicions d'imatges
    * @param int i, posicio del vector
    * @param int canvi, posicio a la que canvia
    */
    private void intercanviar(int[] vector, int i, int canvi) {
        int ajudant = vector[i];
	vector[i] = vector[canvi];
	vector[canvi] = ajudant;
	}
    
                       /**
    * Metode que sobreescriu el visualitzarAlbum() i serveix per visualitzar un album en concret
    * @param String string, nom de lalbum a visualitzar
    */
    @Override
    public void visualitzarAlbum(String string) {
        nomalbumvisualitzar = string;
        posicio = 0;
        vector = new int[dadvis.getAlbumperNom(string).getTamany()];
        for(int i= 0; i < vector.length; i++) vector[i] = i;
        if(dadvis.getAleatori()){
            shuffleLlista(vector);
            for(int i= 0; i < vector.length; i++) System.out.println((vector[i]));
        }
        engegat = true;
        espotreprendre  = true;
        
    }
                    /**
    * get que retorna una llista de IFitxers
    * 
     * @return IFitxer[], amb les Fotos
    */
    @Override
    public IFitxer[] getLlistaFotos() {
       return dadvis.getLlistaFotos();
    }

    @Override
    public IFitxer[] getLlistaFotosAlbum(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
                    /**
    * get que retorna una llista de Strings amb el nom dels albums
    * 
     * @return String[], amb el nom dels albums
    */
    @Override
    public String[] getLlistaAlbums() {
        return dadvis.getLlistaAlbums();
    }
                    /**
    * get que retorna una llista de Strings amb el nom dels albums
    * 
     * @return String[], amb el nom dels albums
    */
    @Override
    public IFitxer getImatge(int id) {
        return dadvis.getFitxerperID(id);
    } 
                        /**
    * Metode que elimina una imatge per la id
    * 
    */
    @Override
    public void eliminarImatge(int i) {
        dadvis.eliminarImatge(i);
    }
                            /**
    * Metode que elimina una imatge per la id en un album buscat per nom
     * @param String string amb el nom de lalbum
     * @param  int i amb la id de lalbum
    * 
    */
    @Override
    public void eliminarImatgeAlbum(String string, int i){
        dadvis.eliminarImatgeAlbum(string, i);
    }
    
                           /**
    * Metode que sobreescriu el onTimer, que mostra cada cert temps el que sigui, en aquest cas, mostra FitxerImatge
    * 
    */  
    public void onTimer(){
        if(espotreprendre){
                if(engegat){
                    if(nomalbumvisualitzar == null){
                        LlistaImatges novallista = dadvis.getBiblioteca();
                        FitxerImatge fitima= novallista.getLlistaImatge().get(vector[posicio]);
                        visualitzarImatge(fitima.getCami());
                        if(posicio < novallista.getTamany() - 1){
                            posicio++;
                        }
                        else{
                            posicio = 0;
                            engegat = false;
                            espotreprendre  = false;
                        }    
                    }
                    else{
                        LlistaImatges noualbum = dadvis.getAlbumperNom(nomalbumvisualitzar);
                        FitxerImatge fitima= noualbum.getLlistaImatge().get(vector[posicio]);
                        visualitzarImatge(fitima.getCami());
                        if(posicio < noualbum.getTamany() - 1){
                            posicio++;
                        }
                        else{
                            posicio = 0;
                            nomalbumvisualitzar = null;
                            engegat = false;
                            espotreprendre  = false;
                        }    
                    }

                } 
        }

        
    }
        /**
    * Metode que primer crida el afegirImatge, on li retorna la id que serveix per enllaçar amb el addFit de DadesVisor
    * 
    * @param IFitxer  fitxer, fitxer que es vol afegir
    */
    public void addFitxer(FitxerImatge fitxer){
        dadvis.afegiFitxer(fitxer, afegirImatge(fitxer.getCami()));   
        
    }
            /**
    * Metode que enllaça amb el RecuperarFitxer de DadesVisor
    * 
    * @param String nomarxiu, adreça on es vol recuperar l'arxiu
    * 
    * @throws: FileNotFoundException, en cas de no trobar l'arxiu i IOException, en cas d'error IO
    */
    public void recuperarFitxer(String nomarxiu) throws FileNotFoundException, IOException, ClassNotFoundException{
        this.dadvis = dadvis.recuperarFitxer(nomarxiu);
    }
                /**
    * Metode que enllaça amb el GuardarFitxer de DadesVisor
    * 
    * @param String nomarxiu, adreça on es vol guardar l'arxiu
    * 
    * @throws: FileNotFoundException, en cas de no trobar l'arxiu i IOException, en cas d'error IO
    */
    public void guardarFitxer(String nomarxiu) throws FileNotFoundException, IOException{
        dadvis.guardarFitxer(nomarxiu);
    }
                            /**
    * Metode que llança crearAlbums i despres enllaça amb el crearAlbumCompet() de DadesVisor
    * @param String nom, nom de lalbum
    * @param String autor, nom de lautor
    * @param String lloc, nom del lloc de lalbum
    * @param String tema, tema de lalbum
    * @param String tipus, tipus dalbum
    */
    public void crearAlbumComplet(String nom, String autor, String lloc, String tema, String tipus){
        crearAlbum(nom);
        dadvis.crearAlbumComplet(nom, autor, lloc, tema, tipus);
    }
    
                        /**
    * Metode enllaça amb el MostrarNomAlbums de Dades Visor
    * 
    * @return Album, amb el mateix nom
    * 
    */
    public Album veureAlbum(String nomalbum){
        return dadvis.getAlbumperNom(nomalbum);
     }
    
                    /**
    * Metode enllaça amb el MostrarNomAlbums de Dades Visor
    * 
    * @return String, amb el nom dels albums
    * 
    */
    public String mostrarnomAlbums(){
        return dadvis.mostrarNomAlbums();
    }
    
                /**
    * Metode gestiona els errors i crida a visualitzarImatge()
    * 
    * @param IFitxer imageFile, Fitxer a visualitzar
    * 
    * @throws: Excepcio, en cas de que l'arxiu no tingui el format especificat
    */
    public void visualitzarException(IFitxer imageFile) throws Excepcio{
        int pos = imageFile.getCami().getName().lastIndexOf(".");
        String tipo = imageFile.getCami().getName().substring(pos);
        if(tipo.equals(".gif") || tipo.equals(".jpg")||tipo.equals(".bmp")||tipo.equals(".png")){
            if(imageFile!=  null){
                visualitzarImatge(imageFile); 
            }
            else{
                throw new Excepcio("ID no trobada");    
            }
        }
        else{
            throw new Excepcio("Format no compatible");
        }

    }
    
                        /**
    * get que retorna un boolea que diu si es pot reprendre o sa de parar
    * 
     * @return boolean, espotreprendre
    */
    public boolean isEspotreprendre() {
        return espotreprendre;
    }
                         /**
    * Metode que guarda si esta espotreprendre
     * @param boolean espotreprendre
    * 
    */
    public void setEspotreprendre(boolean espotreprendre) {
        this.espotreprendre = espotreprendre;
    }
                           /**
    * Metode que activa/desactiva la visualitzacio de manera aleatoria
    * 
    */
    public void activarVisualitzacioAleatoria(){
        if(!dadvis.getAleatori()){
            dadvis.setAleatori(true);    
        }
        else{
            dadvis.setAleatori(false);      
        }

    }
                               /**
    * Metode que activa/desactiva la visualitzacio de manera sequencial
    * 
    */
    public void activarVisualitzarSequencial(){
                dadvis.setAleatori(false); 
    }
                                 /**
    *  Metode que para la reproduccio
    * 
    */
    public void pararReproduccio(){
        espotreprendre = false;
}
                        /**
    * get que retorna una imatge amb el mateix nom
    * 
     * @return el Fitxer amb el nom passat
    */
    public FitxerImatge getImatgeperNom(String nom) {
        return dadvis.getImatgeperNom(nom);
    } 

                                 /**
    * Metode que retorna l'array t'albums
     * @return ArrayList<Album> llistaAlbums
    * 
    */  
    public ArrayList<Album> getArrayAlbums() {
        return dadvis.getArrayAlbums();
    }
                                     /**
    * Metode que retorna si el reproductor està engegat
     * @return boolean engegat
    * 
    */  
    public boolean isEngegat() {
        return engegat;
    }
                         /**
    * Metode que guarda si esta engegat
     * @param boolean engegat
    * 
    */
    public void setEngegat(boolean engegat) {
        this.engegat = engegat;
    }
    
}
