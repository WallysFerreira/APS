import java.sql.Connection
import java.sql.Statement

fun main(args: Array<String>) {
    try {
        var continuar = true
        var conn: Connection = Conexao.abrir()
        var s: Statement = conn.createStatement()

        while (continuar) {
            when (menuPrincipal()) {
                1 -> cadastrarConta()
                2 -> consultarConta()
                3 -> alterarConta()
                4 -> removerConta()
                5 -> exibirContas()
                9 -> continuar = false
            }
        }

        s.close()
        conn.close()
    } catch (e: Exception) {
        println("Deu erro")
        println(e)
    }
}

fun menuPrincipal() : Int {
    val opcoes = listOf(1, 2, 3, 4, 5, 9)
    var opcao: Int = 0

    println("Digite sua opção ")
    println("1 - Cadastrar conta")
    println("2 - Consultar conta")
    println("3 - Alterar conta")
    println("4 - Remover conta")
    println("5 - Exibir todas as contas")
    println("9 - Sair do sistema")

    while (!opcoes.contains(opcao)) {
        println("Sua opção:")
        opcao = readLine()!!.toInt()

        if (!opcoes.contains(opcao)) {
            println("Opção inválida")
        }
    }

    return opcao
}

fun cadastrarConta() {
}

fun consultarConta() {
}

fun alterarConta() {
}

fun removerConta() {
}

fun exibirContas() {
}
