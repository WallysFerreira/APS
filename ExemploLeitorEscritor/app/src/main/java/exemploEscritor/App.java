package exemploEscritor;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class App {
    public static void main(String[] args) {
        try {
            OutputStream output = new FileOutputStream("teste_escrever.txt");

            String s = "Testando 1 2 3";

            for (int i = 0; i < s.length(); i++) {
                output.write(s.charAt(i));
            }

            System.out.println("Escrito com sucesso");
            output.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}