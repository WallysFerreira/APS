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

    fun setNome(nome: String) {
        if (nome.isNullOrEmpty()) throw IllegalArgumentException("Nome inválido")
        this.nome = nome
    }

    fun getNome() : String {
        return nome
    }

    fun setPreco(preco: Float) {
        if (preco <= 0) throw IllegalArgumentException("Preço inválido")
        this.preco = preco
    }

    fun getPreco() : Float {
        return preco
    }
}