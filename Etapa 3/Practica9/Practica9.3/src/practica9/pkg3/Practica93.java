/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9.pkg3;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Practica93 {
    
    
    enum Rol {
        ADMIN, EDITOR, VISITANTE
    }
    
    public static void mostrarPermisos(Rol rol) {
        switch (rol) {
            case ADMIN:
                System.out.println("Acceso total al sistema.");
                break;
            case EDITOR:
                System.out.println("Puede modificar contenido.");
                break;
            case VISITANTE:
                System.out.println("Solo puede visualizar contenido.");
                break;
        }
    }
    
    public static boolean existeRol(String permiso) {
    for (Rol r : Rol.values()) {
        if (r.name().equalsIgnoreCase(permiso)) {
            return true;
        }
    }
    return false;
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("Diga su nivel de permisos.\n\n1. ADMIN\n2. EDITOR\n3. VISITANTE\n\nIngrese: ");

        String permiso = myObj.nextLine().toUpperCase();

        
        if (existeRol(permiso)) {
            Rol rol = Rol.valueOf(permiso);
            mostrarPermisos(rol);
        } else {
            System.out.println("Permiso invalido. No existe ese rol");
        }   
        
        
    }
}

