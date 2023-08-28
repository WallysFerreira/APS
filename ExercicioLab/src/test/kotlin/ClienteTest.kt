import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ClienteTest {
    private val codigo: Int = 23
    private val nome: String = "Teste Silva"
    private val cpf: String = "12345678900"
    private val clienteTeste: Cliente = Cliente(codigo, nome, cpf)

    @Test
    fun testSetCodigoNegativo() {
        assertThrows<IllegalArgumentException> {
            clienteTeste.setCodigo(-2)
        }
    }

    @Test
    fun testSetCodigoValido() {
        val novoCodigo = 33

        assertDoesNotThrow {
            clienteTeste.setCodigo(novoCodigo)
        }

        assertEquals(novoCodigo, clienteTeste.getCodigo())
    }

    @Test
    fun testGetCodigo() {
        assertEquals(codigo, clienteTeste.getCodigo())
    }

    @Test
    fun testSetNomeInvalido() {
        assertThrows<IllegalArgumentException> {
            clienteTeste.setNome("")
        }
    }

    @Test
    fun testSetNomeValido() {
        val novoNome = "Teste Dois"

        assertDoesNotThrow {
            clienteTeste.setNome(novoNome)
        }

        assertEquals(novoNome, clienteTeste.getNome())
    }

    @Test
    fun testGetNome() {
        assertEquals(nome, clienteTeste.getNome())
    }

    @Test
    fun testSetCpfInvalido() {
        assertThrows<IllegalArgumentException> {
            clienteTeste.setCpf("")
        }
    }

    @Test
    fun testeSetCpfValido() {
        val novoCpf = "98765432100"

        assertDoesNotThrow { clienteTeste.setCpf(novoCpf) }

        assertEquals(novoCpf, clienteTeste.getCpf())
    }

    @Test
    fun testGetCpf() {
        assertEquals(cpf, clienteTeste.getCpf())
    }

}