package dias.gabriel;

public class Cliente {
    String cpf;
    String titular;

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", titular='" + titular + '\'' +
                '}';
    }
}
