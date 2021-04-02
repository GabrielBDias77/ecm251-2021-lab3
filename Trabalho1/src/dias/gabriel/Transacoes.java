package dias.gabriel;
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
        
    }
}
