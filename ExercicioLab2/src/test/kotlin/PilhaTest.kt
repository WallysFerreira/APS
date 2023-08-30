import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PilhaTest {
    private val pilha = Pilha<Int>(2)

    @Test
    fun testPilhaCheia() {
        assertThrows<PilhaCheiaException> {
            pilha.push(1)
            pilha.push(1)
            pilha.push(1)
        }
    }

    @Test
    fun testPilhaVazia() {
        assertThrows<PilhaVaziaException> {
            pilha.pop()
        }
    }

    @Test
    fun testPush() {
        assertDoesNotThrow { pilha.push(12) }

        assertEquals(12, pilha.pop())
    }

    @Test
    fun testPop() {
        pilha.push(23)

        assertDoesNotThrow {
            pilha.pop()
        }
    }
}