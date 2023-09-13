package threads;

public class MinhaThreadRunnable implements Runnable {
    private String nome;

    public MinhaThreadRunnable(String nome) {
        this.nome = nome;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + nome + ": " + i);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println("Thread " + nome + " concluida!");
    }
}