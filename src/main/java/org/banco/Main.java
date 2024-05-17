package org.banco;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Meu banco");
        Cliente cliente = banco.criarCliente("Nome legal");

        Conta cc = banco.adicioanarContaCorrente(cliente);
        Conta poupanca = banco.adicionarContaPupanca(cliente);

        banco.imprimirClientes();

        cc.depositar(100);
        cc.transferir(300, poupanca);

        poupanca.transferir(200, cc);
    }
}