package dias.gabriel;
import java.util.Random;
import java.util.Scanner;
public class Contas {
    public Usuarios getUsuarios(){return usuarios;}

    public int getId(){return id;}

    private Usuarios usuarios;
    private double saldo;
    private int id;

    public Contas(int ID,double Saldoini,String senhaUsuarios){
    //this.usuarios=new Usuarios(nomeUsuario);
    this.id = ID;
    this.saldo=Saldoini;
    this.usuarios=new Usuarios(senhaUsuarios);

    }
    public double getSaldo() {
        return this.saldo;
    }


    @Override
    public String toString() {
        return "Contas{" +
                "usuarios=" + usuarios +
                ", saldo=" + saldo +
                ", id=" + id +
                '}';
    }
}
