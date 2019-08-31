/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etapa2;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author eamelz
 */
public class ServicoAnaliseFluxo implements Observer{
    
    private ContaCorrente conta;

    public ServicoAnaliseFluxo(ContaCorrente conta) {
        this.conta = conta;
        conta.addObserver(this);
    }

    @Override
    public void update(Observable operacao, Object arg) {
        if(conta.getServicos().size() >0){
            for (Observer servico : conta.getServicos()) {
                if(this == servico){
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
        }
    }

    
}
