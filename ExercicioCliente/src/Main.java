public class Main {
    public static void main(String[] args) {
        Cliente cli1 = new Cliente(11, "Teste", "12345678900");

        try {
            cli1.setCpf(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}