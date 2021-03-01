package dias.gabriel;

import java.util.Random;

public class Basico03 {
    public static void main(String[] args) {
        int limire=10;
        int contador;
        for (contador=0;contador<limire;contador++){
            System.out.println("contagem: "+contador);
        }
        int senha=123456;
        Random gerador=new Random();
        int chute =gerador.nextInt(999999);
        System.out.println("chute: "+chute);
        int tentativa=0;
        while (chute!=senha){
            System.out.println("tentativa: "+tentativa);
            System.out.println("chute"+chute);
            tentativa++;
            chute= gerador.nextInt(999999);

        }
        System.out.println("acertou");
    }
}
