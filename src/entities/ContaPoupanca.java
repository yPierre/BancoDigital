package entities;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimir() {
        System.out.println("\n=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}