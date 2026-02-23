/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputoutput;
import java.util.Scanner;
/**
 *
 * @author diego
 */
public class InputOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese su edad: ");
        String edad = sc.nextLine();
        
       System.out.println("Ingrese su telefono: ");
       String telefono = sc.nextLine();
        
        System.out.println("Hola " + nombre + ", tu edad es " + edad  + " años" + " y su telefono es: " + telefono);
        
        sc.close();    }
    
}
