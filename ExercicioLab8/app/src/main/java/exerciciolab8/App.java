/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package exerciciolab8;

interface Repositorio {
    public void salvarConta(int codigo, String nome, double saldo);
}

class RepositorioMYSQL implements Repositorio {
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/banco_muita_grana";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public void salvarConta(int codigo, String nome, double saldo) {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO CONTA (codigo, nome, saldo) VALUES(" + codigo + " , '" + nome + "' , " + saldo + ")";
            stmt.executeUpdate(query);
            stmt.close();
            System.out.println(" Conta cadastrada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Conta {
    private int codigo;
    private String nome;
    private double saldo;
    private Repositorio rep;

    public Conta(int numero, String nome, double saldo) {
        this.codigo = numero;
        this.nome = nome;
        this.saldo = saldo;
        rep = new RepositorioMYSQL();
    }

    public void salvar() {
        rep.salvarConta(codigo, nome, saldo);
    }

    public double calculaSaldoJurosCompostos(int meses, double taxa) {
        double montante = saldo * Math.pow((1 + taxa), meses);
        return montante;
    }

    public double calculaSaldoJurosSimples(int meses, double taxa) {
        double montante = saldo * (1 + (taxa * meses));
        return montante;
    }

    public int getNumero() {
        return codigo;
    }

    public void setNumero(int numero) {
        this.codigo= numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome= nome;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo= saldo;
    }
}