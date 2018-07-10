/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.OrdonezVivancosHector.model;

/**
 *
 * @author Hector Ordoñez
 */
public class Excepcio extends Exception {
    public static String MyMessage;
    
      /**
    * Constructor per defecte
    * 
    */
    public Excepcio(){ 
        super();
        MyMessage = "Error Desconegut";
    }
    
          /**
    * Constructor amb missatge
    * 
    */
    public Excepcio(String message){ 
        super(message);
    }
}