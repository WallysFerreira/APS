import org.junit.jupiter.api.Assertions.*

class ProdutoTest {
    val codigo = 2
    val nome = "Televisão"
    val preco = 2300.0f
    val produtoTeste: Produto = Produto(codigo, nome, preco)
}