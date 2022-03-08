package application;

import entities.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int operacao = 0, tipoConta, numConta;
        String nome, cpf, senha;
        Conta tConta;
        double valor;

        Banco banco = new Banco("BC");

        Cliente cliente1 = new Cliente("Raimunda", "033.444.444-55", "123");
        Cliente cliente2 = new Cliente("Sandra", "023.111.111.33", "723");

        Conta cc1 = new ContaCorrente(cliente1);
        Conta cc2 = new ContaPoupanca(cliente2);
        cc1.depositar(1000);
        cc2.depositar(500);

        banco.addConta(cc1);
        banco.addConta(cc2);


        while (operacao != 5) {

            System.out.println("0 - Cadastrar");
            System.out.println("1 - Extrato");
            System.out.println("2 - Deposito");
            System.out.println("3 - Saque");
            System.out.println("4 - Transferencia");
            System.out.println("5 - Terminar operacao");

            operacao = sc.nextInt();

            switch (operacao) {
                case 0:
                    System.out.println("======Cadastro======");
                    System.out.println("Digite: \n1 - Conta Corrente \n2 - Conta Poupanca");
                    tipoConta = sc.nextInt();
                    System.out.println("Digite o seu nome completo:");
                    sc.nextLine();
                    nome = sc.nextLine();
                    System.out.println("Digite o numero do seu cpf(somente numeros):");
                    cpf = sc.next();
                    System.out.println("Digite uma senha: ");
                    sc.nextLine();
                    senha = sc.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, senha);
                    if(tipoConta == 1) {
                        tConta = new ContaCorrente(cliente);
                        banco.addConta(tConta);
                    }
                    else if(tipoConta == 2) {
                        tConta = new ContaPoupanca(cliente);
                        banco.addConta(tConta);
                    }

                    break;
                case 1:
                    System.out.println("===Extrato===");
                    System.out.println("Digite o numero do seu cpf(somente numeros): ");
                    cpf = sc.next();
                    System.out.println("Digite sua senha: ");
                    sc.nextLine();
                    senha = sc.nextLine();

                    banco.imprimirExtratoBanco(cpf, senha);
                    break;
                case 2:
                    System.out.println("===Deposito===");
                    System.out.println("Digite o numero do seu cpf(somente numeros): ");
                    cpf = sc.next();
                    System.out.println("Digite sua senha: ");
                    sc.nextLine();
                    senha = sc.nextLine();
                    System.out.println("Digite o valor a ser depositado:");
                    valor = sc.nextDouble();

                    banco.depositarBanco(cpf, senha, valor);
                    break;
                case 3:
                    System.out.println("===Saque===");
                    System.out.println("Digite o numero do seu cpf(somente numeros): ");
                    cpf = sc.next();
                    System.out.println("Digite sua senha: ");
                    sc.nextLine();
                    senha = sc.nextLine();
                    System.out.println("Digite o valor a ser sacado:");
                    valor = sc.nextDouble();

                    banco.sacarBanco(cpf, senha, valor);
                    break;
                case 4:
                    System.out.println("Transferencia");
                    System.out.println("Digite o numero do seu cpf(somente numeros): ");
                    cpf = sc.next();
                    System.out.println("Digite sua senha: ");
                    sc.nextLine();
                    senha = sc.nextLine();
                    System.out.println("Digite o valor a ser transferido: ");
                    valor = sc.nextDouble();
                    System.out.println("Digite o numero da conta destino: ");
                    numConta = sc.nextInt();

                    banco.transferirBanco(cpf, senha, valor, numConta);
                    break;
                case 5:
                    System.out.println("Operacao finalizada, tenha um bom dia!");
                    break;
            }
        }




        sc.close();


    }
}
