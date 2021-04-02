package dias.gabriel;
import java.util.Random;
import java.util.Scanner;
public class Contas {
    public Usuarios getUsuarios(){return usuarios;}

    public int getId(){return id;}

    private Usuarios usuarios;
    private double saldo;
    private int id;

    public Contas(String nomeUsuario,double Saldoini, int ID){
    this.usuarios=new Usuarios(nomeUsuario);
    this.saldo=Saldoini;
    this.id= ID;
    }
    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
//        this.saldo = this.saldo + valor;
        this.saldo += valor;
    }
    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
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
