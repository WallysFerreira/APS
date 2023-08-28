import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ClienteTest {
    private val clienteTeste: Cliente = Cliente(23, "Teste Silva", "12345678900")

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
        assertEquals(23, clienteTeste.getCodigo())
    }

}