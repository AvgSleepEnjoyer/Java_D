/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3.pkg1;

/**
 *
 * @author diego
 */


class Calculadora{
    int sumar(int a, int b){
        return a + b;
    }

    int restar(int a, int b){
        return a - b;
    }
}


public class Practica31 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("Suma: " + calc.sumar(10, 5));
        System.out.println("Resta: " + calc.restar(12, 5));

    }
    
}
