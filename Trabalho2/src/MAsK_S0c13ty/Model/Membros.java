package MAsK_S0c13ty.Model;

import MAsK_S0c13ty.Enum.Horario;
import MAsK_S0c13ty.Enum.TipoMembro;
import MAsK_S0c13ty.Interface.Aprsentacao;
import MAsK_S0c13ty.Interface.PostarMensagem;


/**
 * Classe abstrata que mostra o que cada membro tem cadastrado.
 */
public class Membros<membros> implements Aprsentacao, PostarMensagem {
    protected String nome;
    protected String email;
    protected TipoMembro tipo;
    protected int id;

    /**
     * Construtur da classe Membros
     * @param nome  nome do usuario
     * @param email email do usuario
     * @param tipo funcao do usuario
     * @param id id do usuario
     */
    public Membros(String nome, String email, TipoMembro tipo, int id){
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.id = id;

    }


    /**
     * Getter do nome do membro
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getter do email do membro
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter do tipo do membro
     * @return funcao do membro
     */
    public TipoMembro getTipo() {
        return tipo;
    }

    /**
     * Getter do id do membro
     * @return Int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter do nome do membro
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Setter do email do membro
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter da funcao do membro
     * @param tipo
     */
    public void setTipo(TipoMembro tipo) {
        this.tipo = tipo;
    }

    /**
     * Setter do id do membro
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo que permite aos usuarios se apresentarem
     */
    @Override
    public void apresentacao() {
        System.out.println("Nome: "+
                getNome() +"\n" +
                 "\""+ getTipo() +"\"\n"+
                "e-mail: "+getEmail()+"\n");

    }

    /**
     * metodo que permite aos usuarios postarem de acordo com o horario
     * @param horario horario que se encontra o usuario
     */
    @Override
    public void postar(Horario horario) {
        System.out.println(".");

    }
}
