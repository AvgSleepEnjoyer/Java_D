
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

    public static void main(String[] args) {
        File myObj = new File("/home/guillo/Desktop/Java_D/Etapa 3/Practica10/Practica10.1/filename.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable: " + myObj.canRead());
            System.out.println("File size in bytes: " + myObj.length());

            try (Scanner reader = new Scanner(myObj)) {
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    System.out.println("Content: " + line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }


