package prog2.trab3;

import java.util.List;

public class ContaCorrente {

    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgenda() {
        return agencia;
    }

    public void setAgenda(int agenda) {
        this.agencia = agenda;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void addCliente(Cliente cliente) {
        this.cliente.add(cliente);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor) {
        
    }

    public void depositar(double valor) {
        
    }

    public void transferir(double valor, ContaCorrente contraDestino) {
        
    }

    public void receberTransferencia(double valor, ContaCorrente origem) {
        
    }
    
}
