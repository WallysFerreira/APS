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
        assertDoesNotThrow {
            clienteTeste.setCodigo(33)
        }

        assertEquals(33, clienteTeste.getCodigo())
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
        assertDoesNotThrow {
            clienteTeste.setNome("Teste Dois")
        }

        assertEquals("Teste Dois", clienteTeste.getNome())
    }

    @Test
    fun testGetNome() {
        assertEquals(nome, clienteTeste.getNome())
    }

    @Test
    fun testGetCpf() {
        assertEquals(cpf, clienteTeste.getCpf())
    }

}