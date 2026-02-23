/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author diego
 */

class DispositivoElectronico {
    String marca;
    String modelo;
    String color;

    String encender() {
        return ("Dispositivo Enciende");
    }

    String apagar() {
        return "Dispositivo Apagado";
    }
    
    void cambiarCanal(){
        System.out.println("Cambiaste de canal");
    }
    
    void menu(){
        System.out.println("Configuracion del menu");
    }
}


public class Practica4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DispositivoElectronico d = new DispositivoElectronico();
        d.marca = "Samsung";
        d.modelo = "QLED";
        d.color = "negro";

        System.out.println("Marca: " + d.marca + ", Modelo: " + d.modelo + ", Color: " + d.color);
        System.out.println(d.encender());
        d.cambiarCanal();
        d.menu();
        System.out.println(d.apagar());

 
    }
    
}
