package org.banco;

import lombok.Data;
import org.banco.exceptions.ClienteInexistenteException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Banco {
    private String nome;
    private Set<Conta> contas;
    private Set<Cliente> clientes;

    public Banco(String nome){
        contas = new HashSet<>();
        clientes = new HashSet<>();
        this.nome = nome;
    }

    public Conta adicioanarContaCorrente(Cliente cliente){
        if(!clientes.contains(cliente))
            throw new ClienteInexistenteException("Este cliente não está no banco");

        Conta cc = new ContaCorrente(cliente);
        contas.add(cc);
        return cc;
    }

    public Conta adicionarContaPupanca(Cliente cliente){
        if(!clientes.contains(cliente))
            throw new ClienteInexistenteException("Este cliente não está no banco");

        Conta poupanca = new ContaPoupanca(cliente);
        contas.add(poupanca);
        return poupanca;
    }

    public Cliente criarCliente(String nome){
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
        return cliente;
    }

    public void imprimirClientes(){
        clientes.forEach(System.out::println);
    }
}
