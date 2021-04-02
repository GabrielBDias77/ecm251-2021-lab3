package dias.gabriel;

public class Contas {
    private int idConta;
    private double saldo;
    private Usuarios usuarios;

    public Contas(int idConta, double saldo, String usuarios) {
        this.idConta = idConta;
        this.saldo = saldo;
        this.usuarios = new Usuarios(usuarios);
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

    public boolean transferirPara(double valor, Contas destino) {
        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "ID=" + idConta +
                ", saldo=" + saldo +
                ", usuario=" + usuarios.toString() +
                '}';
    }
}
