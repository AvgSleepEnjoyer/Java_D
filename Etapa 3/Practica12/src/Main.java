import java.io.*;
import java.util.*;

class DispositivoElectronico implements Serializable {
    private String marca;
    private String modelo;

    public DispositivoElectronico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
}

class Telefono extends DispositivoElectronico implements Serializable {
    private String precio;

    public Telefono(String marca, String modelo, String precio) {
        super(marca, modelo);
        this.precio = precio;
    }

    public String getPrecio() { return precio; }
}

class Contacto implements Serializable {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contacto> contactos = new ArrayList<>();
        List<Telefono> telefonos = new ArrayList<>();

        // Leer si hay archivo ya

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.dat"))) {
            contactos = (List<Contacto>) ois.readObject();
            telefonos = (List<Telefono>) ois.readObject();
            System.out.println("Datos cargados desde archivo binario.");
        } catch (Exception e) {
            System.out.println("No se encontraron datos previos, iniciando vacío.");
        }


        System.out.print("Ingrese la cantidad de contactos nuevos: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Contacto " + (i+1) + " ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Teléfono: ");
            String tel = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            contactos.add(new Contacto(nombre, tel, email));

            System.out.println("--- Teléfono " + (i+1) + " ---");
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            System.out.print("Precio: ");
            String precio = sc.nextLine();
            telefonos.add(new Telefono(marca, modelo, precio));
        }


        System.out.println("\nResumen:");
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            Telefono t = telefonos.get(i);
            System.out.println("[" + (i+1) + "] " + c.getNombre() + " - " + c.getTelefono() +
                    " - " + c.getEmail() + " | " + t.getMarca() + " " + t.getModelo() +
                    " " + t.getPrecio());
        }

        // guardar en archivo, agarra lo pasado y guarda junto con lo nuevo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.dat"))) {
            oos.writeObject(contactos);
            oos.writeObject(telefonos);
            System.out.println("Datos guardados en archivo binario.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}
