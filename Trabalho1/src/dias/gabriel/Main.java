package dias.gabriel;

public class Main {

    public static void main(String[] args) {
        Contas c1;
        c1=new Contas("Neymar",1000,1);

        Contas c2;
        c2=new Contas("Robinho",250,2);

        Contas c3;
        c3=new Contas("Zé Love",3000,3);
        System.out.println("Conta 1: " + c1.toString());
        System.out.println("Conta 2: " + c2.toString());
        System.out.println("Conta 3: " + c3.toString());

        Menu menu= new Menu();
        menu.exibirMenu();

    }

}
