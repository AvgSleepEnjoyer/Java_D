/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8.pkg1;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author diego
 */

abstract class Transporte{
    public abstract void encender();
    public void apagagar(){
        System.out.println("Se apagó el transporte");
    }
}

interface Avanzar{
    String avanzar(int gasolina);
}

interface Frenar{
    void frenar();
}

class Automovil extends Transporte implements Avanzar, Frenar{
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    
    public Automovil(String marca, String modelo, String color, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }
    
    public void vuelta(String cadena){
        System.out.println("Vuelta " + cadena);
    }
    
    
    @Override
    public void encender(){
        System.out.println("Enciende");
    }
    
    @Override
    public String avanzar(int gasolina){
        if (gasolina > 0) {
            return "Avanza";
        } else {
            return "No puede avanzar, no tiene gasolina";
        }
    }
    
    @Override
    public void frenar(){
        System.out.println("Frenando");
    }
    
    public void mostrarInfo(){
        System.out.println("***** Automovil " + marca +  " *****");
        System.out.println("Modelo: " + modelo);
        System.out.println("Color: " + color);
        System.out.println("Precio: " + precio);
    }
    
}

public class Practica81 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        // https://www.w3schools.com/java/ref_arraylist_add.asp
        ArrayList<Automovil> autos = new ArrayList<>();
        
        autos.add(new Automovil("Toyota", "Corolla", "Rojo", 250000));
        autos.add(new Automovil("Honda", "Civic", "Azul", 300000));
        autos.add(new Automovil("Ford", "Focus", "Negro", 280000));
        autos.add(new Automovil("Chevrolet", "Onix", "Blanco", 220000));
        autos.add(new Automovil("Nissan", "Sentra", "Gris", 270000));
        autos.add(new Automovil("Mazda", "3", "Rojo", 310000));
        autos.add(new Automovil("Volkswagen", "Jetta", "Azul", 290000));
        autos.add(new Automovil("Hyundai", "Elantra", "Negro", 260000));
        autos.add(new Automovil("Kia", "Rio", "Blanco", 210000));
        autos.add(new Automovil("BMW", "Serie 3", "Gris", 600000));
        
        for (Automovil auto : autos){
            auto.mostrarInfo();
            auto.encender();
            System.out.println(auto.avanzar(10));
            
            System.out.println("Ingrese direccion a girar: ");
            String direccion = myObj.nextLine();
            auto.vuelta(direccion);
            System.out.println();
        }
    }
    
}
