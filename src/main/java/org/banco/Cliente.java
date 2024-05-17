package org.banco;

import java.util.List;

public class Cliente {
    private String nome;
    private List<Conta> contas;

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public void imprimirSaldoTotal(){
        var saldoTotal = contas
                .stream()
                .mapToDouble(Conta::getSaldo)
                .sum();

        System.out.printf("Saldo total do cliente: R$%.2f%n", saldoTotal);
    }

    public void imprimirExtratosPorConta(){
        contas.forEach(Conta::imprimirExtrato);
    }
}
