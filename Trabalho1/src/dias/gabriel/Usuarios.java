package dias.gabriel;

public class Usuarios {

    public Usuarios(String nome){
    this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    //private Usuarios(String senha){
    //    this.senha = senha;
    //}
    private String nome;
    private String senha;
    private String email;

    @Override
    public String toString() {
        return "" +
                "nome='" + nome + '\'' +
                ", senha=" + senha +
                ", email='" + email + '\'' ;
    }
}
