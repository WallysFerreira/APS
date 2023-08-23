public class Cliente {
    int codigo;
    String nome;
    String cpf;
    public Cliente(int codigo, String nome, String cpf) throws IllegalArgumentException {
        setCodigo(codigo);
        setNome(nome);
        setCpf(cpf);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo < 0) throw new IllegalArgumentException("Codigo invalido");

        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome vazio");
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) throw new IllegalArgumentException("Quantidade de caracteres no CPF invalida");
        this.cpf = cpf;
    }
}
