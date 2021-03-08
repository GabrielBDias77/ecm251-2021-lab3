package dias.gabriel;

public class Main {

    public static void main(String[] args) {
        //Referencia pra conta
        Conta c1;
        c1=new Conta();



        c1.cliente.titular="Neymar";
        c1.saldo=2000;

        c1.visualizarSaldo();

        Conta c2=new Conta();
        c2.cliente.titular="Robinho";
        c2.saldo=1000;
        c2.visualizarSaldo();

        c1.depositar(20);
        c2.depositar(35.99);

        c1.visualizarSaldo();
        c2.visualizarSaldo();

        if(c1.sacar(200000000)){
            System.out.println("Deu Bom!");
        }else {
            System.out.println("Deu ruim");
        }
        if(c2.sacar(9)){
            System.out.println("Deu Bom!");
        }else {
            System.out.println("Deu ruim");
        }
        c1.visualizarSaldo();
        c2.visualizarSaldo();

        if(c1.transferirPara(90,c2)){
            System.out.println("Deu Bom! Transferiu");
        }else {
            System.out.println("Deu ruim");
        }

        c1.visualizarSaldo();
        c2.visualizarSaldo();

        System.out.println("c1: "+c1.toString());
        System.out.println("c2: "+c2.toString());

    }
}
