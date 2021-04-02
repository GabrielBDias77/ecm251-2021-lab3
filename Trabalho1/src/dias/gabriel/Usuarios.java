package dias.gabriel;

import java.util.Random;
import java.util.Scanner;

public class Usuarios {
    public Usuarios(String nome){this.nome=nome;}
    private String nome;
    private int senha;
    private String email;

    @Override
    public String toString() {
        return "Usuarios{" +
                "nome='" + nome + '\'' +
                ", senha=" + senha +
                ", email='" + email + '\'' +
                '}';
    }
}
