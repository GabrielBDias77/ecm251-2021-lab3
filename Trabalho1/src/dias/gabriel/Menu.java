package dias.gabriel;

//Gabriel B. Dias      Ra: 18.00487-3
//Raphael G. Kalaes    Ra: 18.02011-9

import java.awt.*;
import java.util.Scanner;
public class Menu {
    public Usuarios getUsuarios() {
        return usuarios;
    }

    private boolean continuarExecucaoMenu;
    private Scanner scanner;
    private Contas contas;
    private boolean continuarExecucaoID;
    private Usuarios usuarios;


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
    public void executarMenuID() {




        System.out.println("Informe o nome do usuário 1");
        String usuario1 = scanner.nextLine();
        System.out.println("Informe o nome do usuário 2");
        String usuario2 = scanner.nextLine();
        System.out.println("Informe o nome do usuário 3");
        String usuario3 = scanner.nextLine();

        System.out.println("Informe o saldo inicial do usuario 1");
        Double saldoini1=scanner.nextDouble();
        System.out.println("Informe o saldo inicial do usuario 2");
        Double saldoini2=scanner.nextDouble();
        System.out.println("Informe o saldo inicial do usuario 3");
        Double saldoini3=scanner.nextDouble();

        Contas c1;
        c1 = new Contas(saldoini1, usuario1);

        Contas c2;
        c2 = new Contas(saldoini2, usuario2);

        Contas c3;
        c3 = new Contas(saldoini3, usuario3);

        System.out.println("Estado Inicial:");
        System.out.println("Conta 1: " + c1.toString());
        System.out.println("Conta 2: " + c2.toString());
        System.out.println("Conta 3: " + c3.toString());

        //1º Operação de Recebimento
        String opRecebimento1=Transacoes.NovoQRCODE(250,c1, c1.getUsuarios());
        //Operações entre as Contas para os testes
        Transacoes.Transacao(c2,c1,opRecebimento1);
        Transacoes.Transacao(c3,c1,opRecebimento1);
        Transacoes.Transacao(c2,c1,opRecebimento1);
        //2º Operação de Recebimento
        String opRecebimento2=Transacoes.NovoQRCODE(1000,c2, c2.getUsuarios());
        //Operações entre as Contas para os testes
        Transacoes.Transacao(c3,c2,opRecebimento2);

        System.out.println("Estado Final:");
        System.out.println("Conta 1: " + c1.toString());
        System.out.println("Conta 2: " + c2.toString());
        System.out.println("Conta 3: " + c3.toString());


    }


    public Menu() {

        this.continuarExecucaoMenu = true;
        this.scanner = new Scanner(System.in);


    }

}