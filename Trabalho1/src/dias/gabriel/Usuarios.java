package dias.gabriel;

public class Usuarios {
    public static String senha;

    private Usuarios(String nome, String senha){this.nome=nome;
        this.senha = senha;
    }
    private String nome;
    //private String senha;
    private String email;

    @Override
    public String toString() {
        return "" +
                "nome='" + nome + '\'' +
                ", senha=" + senha +
                ", email='" + email + '\'' ;
    }
}
