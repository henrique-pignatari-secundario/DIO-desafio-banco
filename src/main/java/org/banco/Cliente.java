package org.banco;

import lombok.Data;

import java.util.List;

@Data
public class Cliente {
    private String nome;
    private List<Conta> contas;

    public Cliente(String nome){
        this.nome = nome;
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public double getSaldoTotal(){
        return contas
                .stream()
                .mapToDouble(Conta::getSaldo)
                .sum();
    }

    public void imprimirSaldoTotal(){
        System.out.printf("Saldo total do cliente: R$%.2f%n", getSaldoTotal());
    }

    public void imprimirExtratosPorConta(){
        contas.forEach(Conta::imprimirExtrato);
    }

    @Override
    public String toString() {
        return nome + " saldo total: R$ " + getSaldoTotal();
    }
}
