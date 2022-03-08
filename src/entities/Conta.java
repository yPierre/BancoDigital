package entities;

public abstract class Conta {

    private static final int AGENCIA_PADRAO = 5555;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if(saldo < valor) {
            System.out.println("Valor indisponivel, insira um valor menor que o seu saldo");
            return;
        }
        saldo -= valor;
    }

    public void depositar(double valor) {
        if(valor < 0){
            System.out.println("Valor invalido, insira um novo valor");
            return;
        }
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void imprimirExtrato();

    public boolean compare(String cpf, String senha){
        return this.cliente.getCpf().equals(cpf) && this.cliente.getSenha().equals(senha);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: %.2f\n", saldo));
    }
}