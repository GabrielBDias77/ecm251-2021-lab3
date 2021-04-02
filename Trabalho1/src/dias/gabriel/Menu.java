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
        System.out.println("5 - Pagar título");
        System.out.println("0 - Sair do sistema");

    }
    private void avaliarOpcao(int opcao) {
        switch (opcao){
            case 0:
                System.out.println("Obrigado por ter utilizado nosso sistema!");
                break;
            case 1:
                System.out.println("Saldo: R$" + this.contas.getSaldo());
                break;
            case 2:
                System.out.println("Informe o valor:");
                double valorParaDepositar = scanner.nextDouble();
                this.contas.depositar(valorParaDepositar);
                System.out.println("Operação realizada com sucesso!");
                break;
            case 3:
                System.out.println("Informe o valor:");
                double valorParaRetirar = scanner.nextDouble();
                if(this.contas.sacar(valorParaRetirar)){
                    System.out.println("Operação realizada com sucesso!");
                } else {
                    System.out.println("Operação falhou! Verificar saldo!");
                }
            default:
                System.out.println("Funcionalidade ainda não implementada");
                break;
        }
    }
}
