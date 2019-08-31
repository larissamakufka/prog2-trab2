package etapa2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class ContaCorrente extends Observable{

    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo;
    private ArrayList<Operacao> operacao = null;
    private ArrayList<OperacaoTransferencia> operacaoT = null;
    private ArrayList<Observer> servicos = null;

    public ArrayList<Observer> getServicos() {
        return servicos;
    }
    
    public void addServico(Observer servico){
      this.servicos.add(servico);
    }
    
    public void removeServico(Observer servico){
        this.servicos.remove(servico);
    }
  
    public ContaCorrente(int numero, int agencia, Cliente cliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = saldo;
    }    
    
    public ArrayList<OperacaoTransferencia> getOperacaoT() {
        return operacaoT;
    }

    public void setOperacaoT(OperacaoTransferencia operacaoT) {
        this.operacaoT.add(operacaoT);
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao.add(operacao);
    }

    public ArrayList<Operacao> getOperacao() {
        return operacao;
    }

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor) {
        if (valor <= 0 || this.getSaldo() <= valor) {
            throw new IllegalArgumentException("Valor inválido");
        }
        Operacao operacaosacar = new Operacao(valor, this.getSaldo(), TipoOperacao.SAIDA, this, new Date(System.currentTimeMillis()));
        operacaosacar.sacar();
        notifyObservers(operacaosacar);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        Operacao operacaodepositar = new Operacao(valor, this.getSaldo(), TipoOperacao.ENTRADA, this, new Date(System.currentTimeMillis()));
        operacaodepositar.depositar();
        notifyObservers(operacaodepositar);
    }

    public void transferir(double valor, ContaCorrente contaDestino) {
        if (valor <= 0 || this.getSaldo() <= valor) {
            throw new IllegalArgumentException("Valor inválido");
        }
        
        OperacaoTransferencia operacaotransfere = new OperacaoTransferencia(valor, this.getSaldo(), TipoOperacao.ENTRADA, this, new Date(System.currentTimeMillis()));
        contaDestino.setOperacaoT(operacaotransfere);
        contaDestino.receberTransferencia(valor, this);
        this.setSaldo(this.getSaldo() - valor);
        notifyObservers(operacaotransfere);
    }

    private void receberTransferencia(double valor, ContaCorrente origem) {
        
        OperacaoTransferencia operacaotransfere = new OperacaoTransferencia(valor, this.getSaldo(), TipoOperacao.SAIDA, this, new Date(System.currentTimeMillis()));
        origem.setOperacaoT(operacaotransfere);
        origem.setSaldo(origem.getSaldo() + valor);
        notifyObservers(operacaotransfere);
    }
}
