/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import prog2.trab3.Cliente;
import prog2.trab3.ClientePessoaFisica;
import prog2.trab3.ClientePessoaJuridica;
import prog2.trab3.ContaCorrente;
import prog2.trab3.Operacao;
import prog2.trab3.OperacaoTransferencia;
import prog2.trab3.TipoOperacao;
/**
 *
 * @author eamelz
 */
public class TesteEtapa01 {
    
    public TesteEtapa01() {
    }
    
    public void TesteDeposito(){
        Cliente cliente = new Cliente();

        cliente.setConta(new ContaCorrente(123, 1, cliente, 0));
        
        ContaCorrente conta = cliente.obterConta(123);
        
        conta.depositar(100);
        
        Assert.assertEquals(conta.getSaldo(), 100);
    }
    
    public void TesteSaque(){
        Cliente cliente = new Cliente();

        cliente.setConta(new ContaCorrente(123, 1, cliente, 0));
        
        ContaCorrente conta = cliente.obterConta(123);
        
        conta.depositar(150);
        conta.sacar(100);
        
        Assert.assertEquals(conta.getSaldo(), 50);
    }
    
    public void TesteTransferir(){
        Cliente cliente = new Cliente();

        cliente.setConta(new ContaCorrente(123, 1, cliente, 1000));
        
        ContaCorrente conta = cliente.obterConta(123);
        
        Cliente cliente2 = new Cliente();

        cliente2.setConta(new ContaCorrente(999, 9, cliente2, 1000));
        
        ContaCorrente conta2 = cliente.obterConta(999);
        
        conta.transferir(10, conta2);
        
        Assert.assertEquals(conta.getSaldo(), 990);
        Assert.assertEquals(conta2.getSaldo(), 1010);        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
