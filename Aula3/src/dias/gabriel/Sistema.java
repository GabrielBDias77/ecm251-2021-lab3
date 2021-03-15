package dias.gabriel;

import java.util.Scanner;

public class Sistema {

    private boolean executarSistema;
    private Scanner scanner;

        public void executar() {
            int opcao;
            while (executarSistema){
                exibirMenu();
                opcao=scanner.nextInt();

            }
        }

        public Sistema() {
            this.executarSistema=true;
            this.scanner=new Scanner(System.in);

        }

        private void exibirMenu() {
            System.out.println("Bem vindo ao MauaBank");
            System.out.println("1 - Visualizar Saldo");
            System.out.println("2 - Depositar dinheiro");
            System.out.println("3 - Sacar dinheiro");
            System.out.println("4 - Transferir dinheiro");
            System.out.println("5 - Pagar conta (título)");
            System.out.println("0 - Encerrar Sistema");

        }
    }
}
