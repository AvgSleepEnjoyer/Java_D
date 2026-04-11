/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9.pkg2;

/**
 *
 * @author diego
 */
public class Practica92 {

    /**
     * @param args the command line arguments
     */
    
    enum Meses{
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE;
    }
    
    public static void main(String[] args) {
        for(Meses m : Meses.values()) {
            System.out.println(m);
        }
    }
}
    
