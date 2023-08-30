class Pilha<E>(quantidade: Int) {
    private var conteudo = MutableList<E?>(quantidade) { null }
    private var index = 0

    fun push(elemento: E) {
        if (conteudo.last() != null) {
            throw PilhaCheiaException()
        } else {
            conteudo.set(index, elemento)
            index++
        }
    }

    fun pop() : E? {
        if (conteudo.first() == null) throw PilhaVaziaException()
        return conteudo.removeAt(--index)
    }
}

class PilhaVaziaException(mensagem: String = "Pilha está vazia") : Exception(mensagem)
class PilhaCheiaException(mensagem: String = "Pilha está cheia") : Exception(mensagem)