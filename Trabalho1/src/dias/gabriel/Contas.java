package dias.gabriel;

//Gabriel B. Dias      Ra: 18.00487-3
//Raphael G. Kalaes    Ra: 18.02011-9

import java.util.Random;
import java.util.Scanner;
public class Contas {
    public Usuarios getUsuarios(){return usuarios;}


    private Usuarios usuarios;

    private double saldo;
    private int id;
    private static int gerarID;

    public Contas(double Saldoini, String nomeUsuario){
    //this.usuarios=new Usuarios(nomeUsuario);
    gerarID++;
    this.saldo=Saldoini;
    this.id=gerarID;
    this.usuarios=new Usuarios(nomeUsuario);

    }
    public int getId(){
        return id;
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
        return
                "usuarios =" +" "+ usuarios +
                ", saldo ="+ " " + saldo +
                '}';
    }
}
