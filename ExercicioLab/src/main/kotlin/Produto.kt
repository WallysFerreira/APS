class Produto (
    private var codigo: Int,
    private var nome: String,
    private var preco: Float,
) {
    fun setCodigo(codigo : Int) {
        if (codigo <= 0) throw IllegalArgumentException("Código inválido")
        this.codigo = codigo
    }

    fun getCodigo() : Int {
        return codigo
    }
}