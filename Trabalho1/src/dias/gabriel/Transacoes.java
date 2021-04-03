package dias.gabriel;

//Gabriel B. Dias   Ra: 18.00487-3
//Raphael Kalaes    Ra: 18.02011-9

import java.util.Random;
public class Transacoes {

    private static int getRandomNumberInRange ( int min , int max ) {
        Random r = new Random();
        return r . nextInt (( max - min ) + 1 ) + min ;
    }
    public static String NovoQRCODE(double valor, Contas destino, Usuarios UsuarioDestino){
        String NovoQRCODE=valor+";"+destino.getId()+";"+UsuarioDestino.getNome()+";"+getRandomNumberInRange(1000,9999);
        return NovoQRCODE;
    }
    public static void Transacao(Contas Paga, Contas Recebe, String QRCODE){
        String s = QRCODE;
        String[] dados = s.split( ";" ) ;

        //Convertendo o valor da transacao
        double valorTransacao=Double.parseDouble(dados[0]);

        if (valorTransacao<= Paga.getSaldo()) {
            Paga.sacar(valorTransacao);
            Recebe.depositar(valorTransacao);
            System.out.println("Transação efetuada com sucesso");
        }else {
            System.out.println("O pagador não tem saldo insuficiente");
        }
    }
}
