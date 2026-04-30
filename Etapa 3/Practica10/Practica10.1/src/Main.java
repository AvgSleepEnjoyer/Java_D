




import java.util.Scanner;
import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors

void main() {

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un texto para ser introducido a un archivo de texto.");

    String cadena = sc.nextLine();  // Read user input

    try {
        FileWriter myWriter = new FileWriter("filename.txt");
        myWriter.write(cadena);
        myWriter.close();  // must close manually
        System.out.println("Escrito en archivo correctamente.");
    } catch (IOException e) {
        System.out.println("Un error ocurrió");
        e.printStackTrace();
    }

}
