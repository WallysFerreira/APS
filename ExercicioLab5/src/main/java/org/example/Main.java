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

            System.out.println("Como quer a saida?\n1 - Decimal\n2 - Hexadecimal\n3 - Binario");
            int opcao = scanner.nextInt();

            for (int i = 0; i < data.length; i += 8) {

                for (int j = 0; j < comecoLinha.length(); j++) {
                    output.write(comecoLinha.charAt(j));
                }

                String meioLinha = "";

                for (int c = 0; c < 8; c++) {
                    if (c + i < data.length) {
                        if (opcao == 1) {
                            int dec = data[c + i];

                            if (c == 7) {
                                meioLinha += String.format("%d ", dec);
                            } else {
                                meioLinha += String.format("%d, ", dec);
                            }
                        } else if (opcao == 2) {
                            int hex = data[c + i] & 0xFF;

                            if (c == 7) {
                                meioLinha += String.format("%s ", Integer.toHexString(hex));
                            } else {
                                meioLinha += String.format("%s, ", Integer.toHexString(hex));
                            }
                        } else if (opcao == 3) {
                            int bin = data[c + i];

                            if (c == 7) {
                                meioLinha += String.format("%s ", Integer.toBinaryString(bin));
                            } else {
                                meioLinha += String.format("%s, ", Integer.toBinaryString(bin));
                            }
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