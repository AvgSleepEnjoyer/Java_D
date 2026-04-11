/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

/**
 *
 * @author diego
 */

 class DispositivoElectronico{
    private String marca;
    private String modelo;

    public DispositivoElectronico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    String encender(){
        return ("Dispositivo Enciende");
    }

    String apagar(){
        return "Dispositivo Apagado";
    }
    
}


interface IWifiConexion{
    String cambioCanal();
    String volumen();
}


class Telefono extends DispositivoElectronico implements IWifiConexion {
    private String precio;

    public Telefono(String marca, String modelo, String precio) {
        super(marca, modelo);
        this.precio = precio;
    }

    public String iniciarLlamada(String numero) {
    System.out.println("Llamando al número: " + numero);
    return numero;
    }


    public String iniciarLlamada(Contacto contacto) {
    return contacto.getTelefono();
    }


    public String finalizarLlamada(){
        return "Llamada finalizada";
    }

    @Override
    public String cambioCanal(){
        return "Cambio de canal WiFi realizado";
    }

    @Override
    public String volumen(){
        return "Volumen ajustado";
    }
}


class Contacto{
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email){
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre(){
        return nombre; 
    }
    public String getTelefono(){
        return telefono; 
    }
    public String getEmail(){
        return email;
    }
}


public class Practica6 {
    public static void main(String[] args) {

        Contacto c1 = new Contacto("Diego", "12345", "diego@mail.com");
        Contacto c2 = new Contacto("Ana", "12345", "ana@mail.com");
        Contacto c3 = new Contacto("Luis", "12121", "luis@mail.com");
        Contacto c4 = new Contacto("Sofía", "12312", "sofia@mail.com");
        Contacto c5 = new Contacto("Carlos", "098761", "carlos@mail.com");

        Contacto[] contactos = {c1, c2, c3, c4, c5};

        Telefono t1 = new Telefono("Samsung", "S24", "$1200");
        Telefono t2 = new Telefono("Apple", "iPhone 15", "$1500");
        Telefono t3 = new Telefono("Xiaomi", "Redmi Note 13", "$800");
        Telefono t4 = new Telefono("Motorola", "Edge 40", "$900");
        Telefono t5 = new Telefono("Huawei", "P60", "$1100");

        Telefono[] telefonos = {t1, t2, t3, t4, t5};


        for(int i = 0; i < telefonos.length; i++){
            Telefono tel = telefonos[i];
            Contacto con = contactos[i];
            System.out.println("Contacto [" + (i+1) + "]" );
            System.out.println("Teléfono: " + tel.cambioCanal());
            System.out.println(tel.volumen());
            System.out.println(tel.encender());
            System.out.println("Llamando a: " + con.getNombre() + " (" + con.getTelefono() + ")");
            System.out.println(tel.finalizarLlamada());
            System.out.println(tel.finalizarLlamada());
            System.out.println(tel.apagar());
            System.out.println("--------");
        }
    }
}
