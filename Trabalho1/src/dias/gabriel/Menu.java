package dias.gabriel;
import java.awt.*;
import java.util.Scanner;
public class Menu {
        private boolean continuarExecucaoMenu;
        private Scanner scanner;
        private Contas contas;
        private boolean continuarExecucaoID;



    //    public MenuID() {
//
//        this.continuarExecucaoID = true;
//        this.scanner = new Scanner(System.in);
//        Contas c1;
//        c1 = new Contas(1, 1000);
//
//        Contas c2;
//        c2 = new Contas(2, 250);
//
//        Contas c3;
//        c3 = new Contas(3, 3000);
//
//    }
//
    public void executarMenuID(){
        this.continuarExecucaoID = true;
        while(continuarExecucaoID) {
            exibirMenuID();
            int opcao = scanner.nextInt();
            avaliarOpcaoMenuID(opcao);
        }
    }
    private void avaliarOpcaoMenuID(int opcao) {
        String senha = scanner.next();
        switch (opcao) {
            default:
                System.out.println("ID não encontrado");
                break;
            case 1:
                System.out.println("Informe a senha");

                if (senha == Usuarios.senha) {
                    executarMenuConta();
                } else System.out.println("senha Incorreta");
            case 2:
                System.out.println("Informe a senha");
                if (senha == Usuarios.senha) {
                    executarMenuConta();
                } else System.out.println("senha Incorreta");

            case 3:
                System.out.println("Informe a senha");

                if (senha == Usuarios.senha) {
                    executarMenuConta();
                } else System.out.println("senha Incorreta");
        }
    }


    private void exibirMenuID() {
        System.out.println("Bem vindo ao MauaBank");
        System.out.println("Informe o ID da Conta");}

        public Menu() {

            this.continuarExecucaoMenu = true;
            this.scanner = new Scanner(System.in);
            Contas c1;
            c1 = new Contas(1, 1000);

            Contas c2;
            c2 = new Contas(2, 250);

            Contas c3;
            c3 = new Contas(3, 3000);
            System.out.println("Conta 1: " + c1.toString());
            System.out.println("Conta 2: " + c2.toString());
            System.out.println("Conta 3: " + c3.toString());

   
        }

        public void executarMenuConta(){
            while(continuarExecucaoMenu) {
                exibirMenuConta();
                int opcao = scanner.nextInt();
                avaliarOpcaoMenuConta(opcao);
            }
        }

        private void avaliarOpcaoMenuConta(int opcao) {
            switch (opcao){
                case 6:
                    System.out.println("Obrigado por ter utilizado nosso sistema!");
                    this.continuarExecucaoMenu = false;
                    break;
                default:
                    System.out.println("Funcionalidade ainda não implementada");
                    break;
            }
        }

        private void exibirMenuConta() {
            System.out.println("Bem vindo ao MauaBank");
            System.out.println("1 - Visualizar Saldo");
            System.out.println("2 - Depositar dinheiro");
            System.out.println("3 - Sacar dinheiro");
            System.out.println("4 - Transferir dinheiro");
            System.out.println("5 - Pagar título");
            System.out.println("6 - Sair do sistema");

        }
    }
