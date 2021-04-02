package dias.gabriel;
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

        Contas c1;
        c1 = new Contas(1000, "Neymar");

        Contas c2;
        c2 = new Contas(250, "Robinho");

        Contas c3;
        c3 = new Contas(3000, "Zé Love");
        System.out.println("Conta 1: " + c1.toString());
        System.out.println("Conta 2: " + c2.toString());
        System.out.println("Conta 3: " + c3.toString());


    }


    public Menu() {

        this.continuarExecucaoMenu = true;
        this.scanner = new Scanner(System.in);


    }

}