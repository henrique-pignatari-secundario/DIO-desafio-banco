package org.banco;

import java.util.List;

public class Cliente {
    private String nome;
    private List<Conta> contas;

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }
}
