fun main() {
    var saldo = 150.00 // Saldo inicial
    var nome: String? // Variável para armazenar o nome do usuário
    var extrato = "Histórico:\n- Compra: R$ 30.00\n- Depósito: R$ 100.00\n- Compra: R$ 50.00\n" // Extrato fictício
    val senhaCorreta = 3589 // Senha fixa para validação

    println("Digite o seu nome:")
    nome = readLine()
    println("Olá $nome, é um prazer ter você por aqui!\n")

    var opcao: Int
    var senha: Int

    do {
        // Exibir o menu de opções
        println("\nEscolha uma opção:")
        println("1. Ver saldo")
        println("2. Ver extrato")
        println("3. Fazer saque")
        println("4. Fazer depósito")
        println("5. Fazer transferência")
        println("6. Sair")
        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> {
                println("Digite sua senha:")
                senha = readLine()?.toIntOrNull() ?: 0
                if (senha == senhaCorreta) {
                    println("Seu saldo atual é: R$ $saldo\n")
                } else {
                    println("Senha incorreta. Tente novamente.\n")
                }
            }
            2 -> {
                println("Digite sua senha:")
                senha = readLine()?.toIntOrNull() ?: 0
                if (senha == senhaCorreta) {
                    println("Extrato da conta:\n$extrato")
                } else {
                    println("Senha incorreta. Tente novamente.\n")
                }
            }
            3 -> {
                println("Digite sua senha:")
                senha = readLine()?.toIntOrNull() ?: 0
                if (senha == senhaCorreta) {
                    saldo = fazerSaque(saldo, extrato)
                } else {
                    println("Senha incorreta. Tente novamente.\n")
                }
            }
            4 -> saldo = fazerDeposito(saldo, extrato)
            5 -> {
                println("Digite sua senha:")
                senha = readLine()?.toIntOrNull() ?: 0
                if (senha == senhaCorreta) {
                    saldo = fazerTransferencia(saldo, extrato)
                } else {
                    println("Senha incorreta. Tente novamente.\n")
                }
            }
            6 -> println("$nome, foi um prazer ter você por aqui!\nPrograma encerrado.")
            else -> println("Opção inválida. Tente novamente.\n")
        }
    } while (opcao != 6)
}

fun fazerDeposito(saldo: Double, extrato: String): Double {
    println("Qual o valor para depósito?")
    val deposito = readLine()?.toDoubleOrNull() ?: 0.0
    if (deposito <= 0) {
        println("Operação não autorizada. O valor deve ser maior que zero.\n")
    } else {
        println("Depósito realizado com sucesso!\n")
        println("Seu saldo atualizado é: R$ ${saldo + deposito}\n")
        return saldo + deposito
    }
    return saldo
}

fun fazerSaque(saldo: Double, extrato: String): Double {
    println("Qual o valor para saque?")
    val saque = readLine()?.toDoubleOrNull() ?: 0.0
    if (saque <= 0) {
        println("Operação não autorizada. O valor deve ser maior que zero.\n")
    } else if (saque > saldo) {
        println("Operação não autorizada. Saldo insuficiente.\n")
    } else {
        println("Saque realizado com sucesso!\n")
        println("Seu saldo atualizado é: R$ ${saldo - saque}\n")
        return saldo - saque
    }
    return saldo
}

fun fazerTransferencia(saldo: Double, extrato: String): Double {
    println("Digite o número da conta para transferência:")
    val conta = readLine()?.toIntOrNull() ?: 0
    println("Digite o valor para transferência:")
    val transferencia = readLine()?.toDoubleOrNull() ?: 0.0
    if (transferencia <= 0) {
        println("Operação não autorizada. O valor deve ser maior que zero.\n")
    } else if (transferencia > saldo) {
        println("Operação não autorizada. Saldo insuficiente.\n")
    } else {
        println("Transferência realizada com sucesso!\n")
        println("Seu saldo atualizado é esse: R$ ${saldo - transferencia}\n")
        return saldo - transferencia
    }
    return saldo
}