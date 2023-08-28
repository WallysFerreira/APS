class Cliente(
    private var codigo: Int,
    private var nome: String,
    private var cpf: String,
) {
    fun setCodigo(codigo: Int) {
        if (codigo <= 0) throw IllegalArgumentException("Código inválido")
        this.codigo = codigo
    }
}