package entities;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimir() {
        System.out.println("\n=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

}