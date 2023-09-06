/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package exemploleitor;

import java.io.*;

public class App {
    public static void main(String[] args) {
        InputStream inputStream;

        try {
            inputStream = new FileInputStream("teste.txt");
            int data = inputStream.read();

            System.out.println("Conteudo do arquivo:");

            while (data != -1) {
                System.out.println((char) data);
                data = inputStream.read();
            }

            inputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
