/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9.pkg1;

/**
 *
 * @author diego
 */



public class Practica91 {

    /**
     * @param args the command line arguments
     */
    
    enum Dias{
        LUNES,
        MARTES,
        MIERCOLES,
        JUEVES,
        VIERNES,
        SABADO,
        DOMINGO;
    }
    
    public static void main(String[] args) {
        for(Dias d : Dias.values()) {
            System.out.println(d);
        }
    }
    
}
