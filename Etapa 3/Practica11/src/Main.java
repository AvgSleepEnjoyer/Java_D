import java.io.*;
import java.util.*;

class DispositivoElectronico {
    private String marca;
    private String modelo;

    public DispositivoElectronico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
}

class Telefono extends DispositivoElectronico {
    private String precio;

    public Telefono(String marca, String modelo, String precio) {
        super(marca, modelo);
        this.precio = precio;
    }

    public String getPrecio() { return precio; }

    public String toCSV() {
        return getMarca() + "," + getModelo() + "," + precio;
    }

    public static Telefono fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new Telefono(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}

class Contacto {
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

    public String toCSV() {
        return nombre + "," + telefono + "," + email;
    }

    public static Contacto fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new Contacto(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contacto> contactos = new ArrayList<>();
        List<Telefono> telefonos = new ArrayList<>();


        File archivoContactos = new File("contactos.txt");
        if (archivoContactos.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivoContactos))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Contacto c = Contacto.fromCSV(line);
                    if (c != null) contactos.add(c);
                }
                System.out.println("Contactos cargados desde archivo.");
            } catch (IOException e) {
                System.out.println("Error al leer contactos: " + e.getMessage());
            } finally {
                System.out.println("Accion de cargar concluida");
            }
        }
        File archivoTelefonos = new File("telefonos.txt");
        if (archivoTelefonos.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivoTelefonos))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Telefono t = Telefono.fromCSV(line);
                    if (t != null) telefonos.add(t);
                }
                System.out.println("Teléfonos cargados desde archivo.");
            } catch (IOException e) {
                System.out.println("Error al leer teléfonos: " + e.getMessage());
            } finally {
                System.out.println("Accion de cargar concluida");
            }
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
            System.out.println("[" + (i+1) + "] " + c.getNombre() + " - " + c.getTelefono() + " - " + c.getEmail() +
            " | " + t.getMarca() + " " + t.getModelo() + " " + t.getPrecio());
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoContactos))) {
            for (Contacto c : contactos) {
                bw.write(c.toCSV());
                bw.newLine();
            }
            System.out.println("Contactos guardados en archivo de texto.");
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos: " + e.getMessage());
        } finally {
            System.out.println("Accion de terminado concluida");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTelefonos))) {
            for (Telefono t : telefonos) {
                bw.write(t.toCSV());
                bw.newLine();
            }
            System.out.println("Teléfonos guardados en un archivo de texto.");
        } catch (IOException e) {
            System.out.println("Error al guardar los telefonos: " + e.getMessage());
        } finally {
            System.out.println("Accion de terminado concluida");
        }
    }
}
