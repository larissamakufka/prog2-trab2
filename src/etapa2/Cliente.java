package etapa2;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String telFixo;
    private String telCelular;
    private ArrayList<ContaCorrente> conta = new ArrayList<>();

    public ArrayList<ContaCorrente> getConta() {
        return conta;
    }    

    public void setConta(ContaCorrente conta) {
        this.conta.add(conta);
    }
    
    public ContaCorrente obterConta(int numeroConta){
        for(int i = 0; i < conta.size() - 1; i++){
            if (conta.get(i).getNumero() == numeroConta)
                return conta.get(i);
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

}
