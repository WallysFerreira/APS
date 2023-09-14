package org.example;

public class Thread implements Runnable {
    private String nome;
    private int valorInicial;
    private int valorFinal;

    public Thread(String nome, int valorInicial, int valorFinal) {
        this.nome = nome;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;

        if (valorFinal < valorInicial) {
            System.out.println("Aviso na thread " + nome + ": valor final menor que o valor inicial");
        }
    }

    public void run() {
        for (int i = valorInicial; i < valorFinal; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Thread " + nome + ": " + i);
            }
        }
    }
}
