class Cliente(
    private var codigo: Int,
    private var nome: String,
    private var cpf: String,
) {
    fun setCodigo(codigo: Int) {
        this.codigo = codigo
    }
}