package org.banco;

import org.banco.exceptions.SaldoInsuficienteException;
import org.banco.exceptions.ValorNegativoException;

public class ContaPoupanca extends  Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        if(valor < 0)
            throw new ValorNegativoException("O valor de depositos deve ser maior do que zero");

        if(this.saldo < valor)
            throw new SaldoInsuficienteException("Saldo insuficiente para completar a transacao");

        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if(valor < 0)
            throw new ValorNegativoException("O valor de depositos deve ser maior do que zero");

        this.saldo += valor;
    }
}
