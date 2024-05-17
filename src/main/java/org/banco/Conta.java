package org.banco;

import lombok.Data;
import org.banco.exceptions.ValorNegativoException;

@Data
public abstract class Conta {
    private static int SEQUENCIAL = 1;
    private int AGENCIA_PADRAO = 1;

    private int agencia;
    private int numero;
    protected double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0;

        cliente.adicionarConta(this);
    }

    public abstract void sacar(double valor);

    public abstract void depositar(double valor);

    public void transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void imprimirExtrato(){
        System.out.printf("Conta: %d%n", this.numero);
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Saldo: %.2f", this.saldo);
    }
}
