package prog2.trab3;

import java.util.Date;

public class Operacao {
    
    private double valor;
    private double saldoAnterior;
    private TipoOperacao tipo;
    private ContaCorrente conta;
    private Date data;

    public Operacao(double valor, double saldoAnterior, TipoOperacao tipo, ContaCorrente conta, Date data) {
        this.valor = valor;
        this.saldoAnterior = saldoAnterior;
        this.tipo = tipo;
        this.conta = conta;
        this.data = data;
    }
    
    public void sacar(){
        this.setOperacao(operacaosacar);
        setSaldo(getSaldo() - valor);
    }
    
    public void depositar(){
        this.setOperacao(operacaodepositar);
        this.setSaldo(this.getSaldo() + valor);
    }
}
