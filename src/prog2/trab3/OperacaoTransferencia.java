package prog2.trab3;

import java.util.Date;

public class OperacaoTransferencia extends Operacao {

    private ContaCorrente contraPartida;

    public OperacaoTransferencia(double valor, double saldoAnterior, TipoOperacao tipo, ContaCorrente conta, Date data) {
        super(valor, saldoAnterior, tipo, conta, data);
    }
    
}
