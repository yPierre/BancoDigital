package application;

import entities.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int operacao = 0, numConta, cadastroOuLogin = 0;
        String cpf = "", senha = "";
        double valor;

        Banco banco = new Banco("BC");

        Cliente cliente1 = new Cliente("Raimunda", "908.487.970-86", "111");
        Cliente cliente2 = new Cliente("Sandra", "726.886.930-42", "222");
        Cliente cliente3 = new Cliente("Thales", "379.337.280-49", "333");
        Cliente cliente4 = new Cliente("Felipe", "545.984.660-90", "444");
        Cliente cliente5 = new Cliente("Vinicius", "735.535.140-00", "555");

        Conta cc1 = new ContaCorrente(cliente1);
        Conta cc2 = new ContaPoupanca(cliente2);
        Conta cc3 = new ContaCorrente(cliente3);
        Conta cc4 = new ContaPoupanca(cliente4);
        Conta cc5 = new ContaPoupanca(cliente5);

        cc1.depositar(1000);
        cc2.depositar(500);
        cc3.depositar(2000);
        cc4.depositar(20);
        cc5.depositar(4500);

        banco.addConta(cc1);
        banco.addConta(cc2);
        banco.addConta(cc3);
        banco.addConta(cc4);
        banco.addConta(cc5);


        while (cadastroOuLogin != 3) {
            System.out.println("O que você deseja fazer?\n1 - Cadastrar\n2 - Realizar Login\n3 - Sair do Banco");
            cadastroOuLogin = sc.nextInt();

            if (cadastroOuLogin == 1) { //Realiza o cadastro
                banco.addConta(cadastrar());
                System.out.println("==============================");
                System.out.println("Cadastro realizado com sucesso!");
                System.out.println("==============================\n");
            }
            else if (cadastroOuLogin == 2) { //Tentativa de login e acesso à conta do usuário

                for (int i = 0; i < 3; i++) {
                    System.out.println("Digite o seu cpf: ");
                    cpf = sc.next();
                    System.out.println("Digite sua senha: ");
                    sc.nextLine();
                    senha = sc.nextLine();

                    if (banco.efetuarLoginCliente(cpf, senha)) {
                        System.out.println("Login efetuado com sucesso!");
                        break;
                    } else if (i != 2) {
                        System.out.printf("Erro no login, %d tentativa(s) restantes antes de bloquear a conta!\n", 2 - i);
                    } else {
                        System.out.println("Conta bloqueada!");
                        operacao = 5;
                    }
                }

                while (operacao != 5) {
                    System.out.println("\n\n=====Qual operação deseja realizar?=====");
                    System.out.println("1 - Extrato");
                    System.out.println("2 - Deposito");
                    System.out.println("3 - Saque");
                    System.out.println("4 - Transferencia");
                    operacao = sc.nextInt();

                    switch (operacao) {
                        case 1:
                            System.out.println("===Extrato===");
                            banco.imprimirExtratoBanco(cpf, senha);
                            break;
                        case 2:
                            System.out.println("===Deposito===");
                            System.out.println("Digite o valor a ser depositado:");
                            valor = sc.nextDouble();

                            banco.depositarBanco(cpf, senha, valor);
                            break;
                        case 3:
                            System.out.println("===Saque===");
                            System.out.println("Digite o valor a ser sacado:");
                            valor = sc.nextDouble();

                            banco.sacarBanco(cpf, senha, valor);
                            break;
                        case 4:
                            System.out.println("Transferencia");
                            System.out.println("Digite o valor a ser transferido: ");
                            valor = sc.nextDouble();
                            System.out.println("Digite o numero da conta destino: ");
                            numConta = sc.nextInt();

                            banco.transferirBanco(cpf, senha, valor, numConta);
                            break;
                    }

                    System.out.println("==============================\n");
                    System.out.println("Deseja realizar mais alguma operação?\nS - Sim\nN - Não");
                    if (sc.next().charAt(0) != 'S' || sc.next().charAt(0) != 's') {
                        operacao = 5;
                        System.out.println("Operacao finalizada, tenha um bom dia!");
                    }

                }
            }
        }
        sc.close();

    }


    public static Conta cadastrar(){

        Scanner sc = new Scanner(System.in);
        int tipoConta;
        String nome, cpf, senha;
        Conta tConta;

        System.out.println("Criar nova conta");

        System.out.println("======Cadastro======");
        System.out.println("Digite o tipo de conta s: \n1 - Conta Corrente \n2 - Conta Poupanca");
        tipoConta = sc.nextInt();
        System.out.println("Digite o seu nome completo:");
        sc.nextLine();
        nome = sc.nextLine();
        System.out.println("Digite o numero do seu cpf:");
        cpf = sc.next();
        System.out.println("Digite uma senha: ");
        sc.nextLine();
        senha = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, senha);
        if(tipoConta == 1)
            tConta = new ContaCorrente(cliente);
        else
            tConta = new ContaPoupanca(cliente);

        return tConta;
    }


}
