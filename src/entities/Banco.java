package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas = new ArrayList<Conta>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void addConta(Conta conta){
        if(!contas.contains(conta))
            contas.add(conta);
    }

    public void deleteConta(Conta conta){
        contas.remove(conta);
    }

    public void imprimirExtratoBanco(String cpf, String senha){
        for (Conta i: contas) {
            if(i.compare(cpf, senha)){
                i.imprimirExtrato();
                return;
            }
        }
    }
    public void depositarBanco(String cpf, String senha, double valor){
        for (Conta i: contas) {
            if(i.compare(cpf, senha)){
                i.depositar(valor);
                i.imprimirExtrato();
                return;
            }
        }
    }
    public void sacarBanco(String cpf, String senha, double valor){
        for (Conta i: contas) {
            if(i.compare(cpf, senha)){
                i.sacar(valor);
                i.imprimirExtrato();
                return;
            }
        }
    }

    public void transferirBanco(String cpf, String senha, double valor, int numDestino){
        for (Conta i: contas) {
            if(i.compare(cpf, senha)){
                i.sacar(valor);
                i.imprimirExtrato();
                break;
            }
        }
        for(Conta i: contas){
            if(i.getNumero() == numDestino){
                i.depositar(valor);
                break;
            }
        }
    }
}
