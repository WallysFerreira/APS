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
                2 -> consultarConta(s)
                3 -> menuAlterarConta(s)
                4 -> removerConta(s)
                5 -> exibirContas(s)
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

fun consultarConta(s: Statement) {
    var codigo: Int
    println("Digite o codigo da conta que quer consultar: ")

    codigo = readLine()!!.toInt()

    try {
        var result: ResultSet = s.executeQuery("SELECT codigo, nome, saldo FROM Conta WHERE codigo = ${codigo}")

        if (!result.next()) {
            println("Conta não encontrada")
        } else {
            println(
                "Codigo: ${result.getInt("codigo")} | " +
                "Nome: ${result.getString("nome")} | " +
                "Saldo: ${result.getFloat("saldo")}"
            )
        }
    } catch (e: Exception) {
        println("Erro generico ao consultar conta")
        println(e)
    }
}

fun menuAlterarConta(s: Statement) {
    var opcao: Int
    var codigo: Int

    println("Digite o codigo da conta que deseja alterar:")
    codigo = readLine()!!.toInt()

    var check: ResultSet = s.executeQuery("SELECT * FROM Conta WHERE codigo = ${codigo}")

    if (check.next()) {
        do {
            println("O que você quer alterar?")
            println("1 - Alterar nome")
            println("2 - Alterar saldo")

            opcao = readLine()!!.toInt()

            if (!listOf(1, 2).contains(opcao)) println("Opção inválida")
        } while (!listOf(1, 2).contains(opcao))

        alterarConta(codigo, opcao, s)
    } else {
        println("Nenhum usuário encontrado com o código ${codigo}")
    }
}

fun alterarConta(codigo: Int, opcao: Int, s: Statement) {
    try {
        when (opcao) {
            1 -> {
                println("Digite o novo nome:")
                val valor = readLine().toString()
                s.executeQuery("UPDATE Conta SET nome = '${valor}' where codigo = ${codigo}")
            }

            2 -> {
                println("Digite o novo saldo:")
                val valor = readLine()!!.toFloat()
                s.executeQuery("UPDATE Conta SET saldo = ${valor} where codigo = ${codigo}")
            }
        }
    } catch (e: Exception) {
        println("Erro ao alterar conta")
        println(e)
    }
}

fun removerConta(s: Statement) {
    var codigo: Int
    var check: ResultSet

    println("Digite o código da conta que deseja remover")
    codigo = readLine()!!.toInt()

    check = s.executeQuery("SELECT * FROM Conta WHERE codigo = ${codigo}")
    if (!check.next()) {
        println("Nenhuma conta encontrada")
    } else {
        try {
            s.executeQuery("DELETE FROM Conta WHERE codigo = ${codigo}")
        } catch (e: Exception) {
            println("Erro generico ao deletar conta")
            println(e)
        }
    }
}

fun exibirContas(s: Statement) {
    try {
        var result: ResultSet = s.executeQuery("SELECT * FROM Conta")

        while (result.next()) {
            println(
                "Codigo: ${result.getInt("codigo")} | " +
                        "Nome: ${result.getString("nome")} | " +
                        "Saldo: ${result.getFloat("saldo")}"
            )
        }
    } catch (e: Exception) {
        println("Erro generico ao consultar contas")
        println(e)
    }
}
