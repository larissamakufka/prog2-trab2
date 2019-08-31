package etapa2;

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
        this.tipo = TipoOperacao.SAIDA;
        conta.setOperacao(this);
        conta.setSaldo(conta.getSaldo() - valor);
    }
    
    public void depositar(){
        this.tipo = TipoOperacao.ENTRADA;
        conta.setOperacao(this);
        conta.setSaldo(conta.getSaldo() + valor);
    }
}
