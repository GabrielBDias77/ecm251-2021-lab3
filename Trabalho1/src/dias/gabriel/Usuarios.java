package dias.gabriel;

//Gabriel B. Dias   Ra: 18.00487-3
//Raphael Kalaes    Ra: 18.02011-9

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
                  nome  +
                ", senha=" + senha +
                ", email=" + email ;
    }
}
