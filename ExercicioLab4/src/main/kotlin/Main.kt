import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLIntegrityConstraintViolationException
import java.sql.Statement

private var quantidade = 1

fun main(args: Array<String>) {
    try {
        var continuar = true
        var conn: Connection = Conexao.abrir()
        var s: Statement = conn.createStatement()

        while (continuar) {
            when (menuPrincipal()) {
                1 -> cadastrarConta(s)
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

fun cadastrarConta(s: Statement) {
    var nome: String
    var deuErro = false

    println("Digite seu nome: ")
    nome = readLine().toString()

    try {
        var rs: ResultSet =
            s.executeQuery("INSERT INTO Conta(nome, saldo, codigo) VALUES ('${nome}', 0, ${quantidade})")
    } catch(e: SQLIntegrityConstraintViolationException) {
        println("Já existe uma conta com o código ${quantidade}")
        deuErro = true
    } catch (e: Exception) {
        println("Erro generico ao tentar cadastrar conta")
        println(e)
        deuErro = true
    }

    if (!deuErro) {
        println("Usuario cadastrado com sucesso!")
        quantidade++
    }
}

fun consultarConta() {
}

fun alterarConta() {
}

fun removerConta() {
}

fun exibirContas() {
}
