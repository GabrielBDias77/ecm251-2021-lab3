package dias.gabriel;

public class Main {

    public static void main(String[] args) {
        Contas c1;
        c1=new Contas("Neymar",1000,123);

        Contas c2;
        c2=new Contas("Robinho",20,1234);

        Contas c3;
        c3=new Contas("Zé Love",100,12345);
        System.out.println("Conta 1: " + c1.toString());
        System.out.println("Conta 2: " + c2.toString());
        System.out.println("Conta 3: " + c3.toString());


    }
}
