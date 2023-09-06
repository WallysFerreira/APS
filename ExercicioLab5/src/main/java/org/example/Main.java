package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Arquivo de entrada: ");
        String arquivoEntrada = scanner.nextLine();
        System.out.println("Arquivo saida: ");
        String arquivoSaida = scanner.nextLine();

        try {
            InputStream input = new FileInputStream(arquivoEntrada);
            OutputStream output = new FileOutputStream(arquivoSaida);

            byte[] data = input.readAllBytes();
            int contagemLinhas = 1;
            String comecoLinha = "db ";

            for (int i = 0; i < data.length; i += 8) {

                for (int j = 0; j < comecoLinha.length(); j++) {
                    output.write(comecoLinha.charAt(j));
                }

                String meioLinha = "";

                for (int c = 0; c < 8; c++) {
                    if (c + i < data.length) {
                        int hex = data[c + i] & 0xFF;

                        if (c == 7) {
                            meioLinha += String.format("%s ", Integer.toHexString(hex));
                        } else {
                            meioLinha += String.format("%s, ", Integer.toHexString(hex));
                        }
                    }
                }

                for (int j = 0; j < meioLinha.length(); j++) {
                    output.write(meioLinha.charAt(j));
                }

                String finalLinha = String.format("; linha %d\n", contagemLinhas);
                for (int j = 0; j < finalLinha.length(); j++) {
                    output.write(finalLinha.charAt(j));
                }

                contagemLinhas++;
            }
        } catch (Exception e) {
            System.out.println("Deu erro");
            System.out.println(e);
        }

    }
}