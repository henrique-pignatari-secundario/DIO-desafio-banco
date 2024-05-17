package org.banco;

import lombok.AccessLevel;
import lombok.Getter;
import org.banco.exceptions.SaldoInsuficienteException;
import org.banco.exceptions.ValorNegativoException;

@Getter
public class ContaCorrente extends Conta{
    @Getter(AccessLevel.NONE)
    private final double CREDITO_PADRAO = 1000;

    private double credito;
    private double creditoRestante;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.credito = CREDITO_PADRAO;
        this.creditoRestante = CREDITO_PADRAO;
    }

    public ContaCorrente(Cliente cliente, double credito){
        super(cliente);
        this.credito = credito;
        this.creditoRestante = credito;
    }

    private double creditoUtilizado(){
        return credito - creditoRestante;
    }

    @Override
    public void sacar(double valor) {
        if(valor < 0)
            throw new ValorNegativoException("O valor de depositos deve ser maior do que zero");

        if(this.saldo > valor){
            this.saldo -= valor;
        }else if(creditoRestante > valor){
            this.creditoRestante -= valor;
        }else{
            throw new SaldoInsuficienteException("Saldo e credito insuficientes para realizar transacao");
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor < 0)
            throw new ValorNegativoException("O valor de depositos deve ser maior do que zero");

        if(creditoRestante < credito){
            double saldoAdicionado = valor - creditoUtilizado();

            if(saldoAdicionado > 0){
                this.saldo += saldoAdicionado;
                this.creditoRestante = credito;
            }else {
                this.creditoRestante += valor;
            }
        }
    }
}
