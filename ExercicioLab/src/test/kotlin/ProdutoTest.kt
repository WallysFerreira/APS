import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow

class ProdutoTest {
    val codigo = 2
    val nome = "Televisão"
    val preco = 2300.0f
    val produtoTeste: Produto = Produto(codigo, nome, preco)

    @Test
    fun testSetCodigoInvalido() {
        assertThrows<IllegalArgumentException> {
            produtoTeste.setCodigo(-2)
        }
    }

    @Test
    fun testSetCodigoValido() {
        val codigoNovo = 33
        assertDoesNotThrow { produtoTeste.setCodigo(codigoNovo) }

        assertEquals(codigoNovo, produtoTeste.getCodigo())
    }

    @Test
    fun testGetCodigo() {
        assertEquals(codigo, produtoTeste.getCodigo())
    }

    @Test
    fun testSetNomeInvalido() {
        assertThrows<IllegalArgumentException> { produtoTeste.setNome("") }
    }
    @Test
    fun testSetNomeValido() {
        val nomeNovo = "Teste"

        assertDoesNotThrow { produtoTeste.setNome(nomeNovo) }

        assertEquals(nomeNovo, produtoTeste.getNome())
    }

    @Test
    fun testGetNome() {
        assertEquals(nome, produtoTeste.getNome())
    }
}

