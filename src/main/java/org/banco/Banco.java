package org.banco;

import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Conta adicioanarContaCorrente(Cliente cliente){
        return new ContaCorrente(cliente);
    }

    public Conta adicionarContaPupanca(Cliente cliente){
        return new ContaPoupanca(cliente);
    }
}
