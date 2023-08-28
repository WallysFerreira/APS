import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ClienteTest {
    private val clienteTeste: Cliente = Cliente(23, "Teste Silva", "12345678900")

    @Test
    fun testSetCodigoNegativo() {
        assertThrows<IllegalArgumentException> {
            clienteTeste.setCodigo(-2)
        }
    }
}