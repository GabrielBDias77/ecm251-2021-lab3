package dias.gabriel;
import java.util.Scanner;
public class Menu {
    private Scanner scanner;
    private Contas contas;
    public void exibirMenu() {
        System.out.println("Bem vindo ao MauaBank");
        System.out.println("1 - Visualizar Saldo");
        System.out.println("2 - Depositar dinheiro");
        System.out.println("3 - Sacar dinheiro");
        System.out.println("4 - Transferir dinheiro");
        System.out.println("0 - Sair do sistema");

    }
    public void avaliarOpcao(int opcao) {
        switch (opcao){
            case 0:
                System.out.println("Obrigado por ter utilizado nosso sistema!");
                break;
            default:
                System.out.println("Funcionalidade ainda não implementada");
                break;
        }
    }
}