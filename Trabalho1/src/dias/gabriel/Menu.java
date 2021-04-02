package dias.gabriel;
import java.util.Scanner;
public class Menu {
        private boolean continuarExecucao;
        private Scanner scanner;
        private Contas contas;

        public Menu() {
            this.continuarExecucao = true;
            this.scanner = new Scanner(System.in);
            Contas c1;
            c1 = new Contas("Neymar", 1000, 1);

            Contas c2;
            c2 = new Contas("Robinho", 250, 2);

            Contas c3;
            c3 = new Contas("Zé Love", 3000, 3);
            System.out.println("Conta 1: " + c1.toString());
            System.out.println("Conta 2: " + c2.toString());
            System.out.println("Conta 3: " + c3.toString());

   
        }

        public void executar(){
            while(continuarExecucao) {
                exibirMenu();
                int opcao = scanner.nextInt();
                avaliarOpcao(opcao);
            }
        }

        private void avaliarOpcao(int opcao) {
            switch (opcao){
                case 0:
                    System.out.println("Obrigado por ter utilizado nosso sistema!");
                    this.continuarExecucao = false;
                    break;
                default:
                    System.out.println("Funcionalidade ainda não implementada");
                    break;
            }
        }

        private void exibirMenu() {
            System.out.println("Bem vindo ao MauaBank");
            System.out.println("1 - Visualizar Saldo");
            System.out.println("2 - Depositar dinheiro");
            System.out.println("3 - Sacar dinheiro");
            System.out.println("4 - Transferir dinheiro");
            System.out.println("5 - Pagar título");
            System.out.println("0 - Sair do sistema");

        }
    }
