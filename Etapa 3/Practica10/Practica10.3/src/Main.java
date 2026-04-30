
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

    File myObj = new File("filename.txt");
    if (myObj.exists()) {
        System.out.println("File name: " + myObj.getName());
        System.out.println("Absolute path: " + myObj.getAbsolutePath());
        System.out.println("Writeable: " + myObj.canWrite());
        System.out.println("Readable " + myObj.canRead());
        System.out.println("File size in bytes " + myObj.length());
    } else {
        System.out.println("The file does not exist.");
    }

    try (BufferedReader br = new BufferedReader(new FileReader("filename.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println("Error reading file.");
    }

}
