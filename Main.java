import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mensagem;
        int opcao;

        System.out.println("Insira a mensagem: ");
        mensagem = scanner.nextLine();

        mensagem = mensagem.toUpperCase();

        do {
            System.out.println("1 - Encriptar\n2 - Decriptar");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println(encriptar(mensagem));
                    break;
                case 2:
                    System.out.println(decriptar(mensagem));
            }
        } while (opcao != 0);
    }

    public static String encriptar(String mensagem_original) {
        Scanner scanner = new Scanner(System.in);
        int rotacao;
        String mensagem_encriptada = "";

        System.out.println("Qual rotação você quer usar? ");
        rotacao = scanner.nextInt();

        for (int i = 0; i < mensagem_original.length(); i++) {
            int char_original = mensagem_original.charAt(i);
            char char_encriptado;


            if (char_original + rotacao > 90) {
                char_encriptado = (char) (char_original + rotacao - 26);
            } else {
                char_encriptado = (char) (char_original + rotacao);
            }

            if (char_original == 32) {
                char_encriptado = ' ';
            }

            mensagem_encriptada = mensagem_encriptada + char_encriptado;
        }

        return mensagem_encriptada;
    }

    public static String decriptar(String mensagem_encriptada) {
        Scanner scanner = new Scanner(System.in);
        int rotacao;
        String mensagem_decriptada = "";
        System.out.println("Qual rotação foi usada? ");
        rotacao = scanner.nextInt();

        for (int i = 0; i < mensagem_encriptada.length(); i++) {
            int char_original = mensagem_encriptada.charAt(i);
            char char_decriptado;


            if (char_original - rotacao < 65) {
                char_decriptado = (char) (char_original - rotacao + 26);
            } else {
                char_decriptado = (char) (char_original - rotacao);
            }

            if (char_original == ' ') {
                char_decriptado = ' ';
            }

            mensagem_decriptada = mensagem_decriptada + char_decriptado;
        }

        return mensagem_decriptada;
    }
}
