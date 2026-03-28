/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Arrays;

/**
 *
 * @author diego
 */

class Actividades{
    
    public int longitud(String texto){
        return texto.length();
    }
    
    public boolean comparar(String a, String b){
        return a.equals(b);
    }
    
    public String[] ordenar(String[] arreglo) {
        Arrays.sort(arreglo);
        return arreglo;
    }
    
    public int mayorque2(int a, int b){
        if(a>b)
            return a;
        else
            return b;
    }
    
    public int mayorque3(int a, int b, int c){
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    public double calcularIVA(int cantidad, double precio) {
        double total = cantidad * precio;
        return total * 0.16;
    }
    
    public String[] dividir(String cadena, String caracter){
        return cadena.split(caracter);
    }
    
    public boolean existeDentro(String texto, String subtexto){
        return texto.contains(subtexto);
    }
    
}

public class Practica5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Actividades actividad = new Actividades();
        
        String texto = "Diego Murillo";
        System.out.println("Longitud de cadena: " + texto + " = " + actividad.longitud(texto));
        
        String a = "Jaime come piedras"; String b = "Jose come piedras";
        System.out.println("Las cadenas: " + a + " y " + b + " son iguales? " + actividad.comparar(a, b));
        
        // https://www.datacamp.com/doc/java/sort 
        String[] arreglo = {"Diego", "Carlos", "Juan" , "Television LG"};
        System.out.println("Ordenados: " + Arrays.toString(actividad.ordenar(arreglo)));
        
        int num1 = 40; int num2 = 50;
        System.out.println("Mayor de 2 numeros: " + num1 + ", " + num2 + ". El mayor es: " + actividad.mayorque2(num1, num2));
        
        int num3 = 10;
        System.out.println("Mayor de 3 numeros: " + num1 + ", " + num2 + ", " + num3 + ". El mayor es: " + actividad.mayorque3(num1, num2, num3));
        
        int cantidad = 18; double precio = 16.76;
        System.out.println("IVA de " + 18 + " articulos con precio " + precio + " es igual a: " + actividad.calcularIVA(cantidad, precio));
        
        // https://www.w3schools.com/java/ref_string_split.asp
        String cadena = "Mi television LG esta en la pared colgada";
        String caracter = "L";
        String[] partes = actividad.dividir(cadena, caracter);
        System.out.println(Arrays.toString(partes));
        
        // https://www.w3schools.com/java/ref_string_contains.asp
        String cadenota = "Camionetas"; String cadenita = "Camion";
        System.out.println("La palabra " + cadenita + " esta dentro de " + cadenota + "? " + actividad.existeDentro(cadenota, cadenita));
        
    }
    
}
