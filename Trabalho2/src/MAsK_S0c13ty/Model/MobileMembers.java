package MAsK_S0c13ty.Model;

import MAsK_S0c13ty.Enum.Horario;
import MAsK_S0c13ty.Enum.TipoMembro;

/**
 * Classe dos Mobile_Members
 */
public class MobileMembers extends Membros {

    /**
     * Construtor da classe dos Mobiles_Members
     * @param nome nome do usuario
     * @param email email do usuario
     * @param id id do usuario
     */
    public MobileMembers(String nome, String email, int id) {
        super(nome,email, TipoMembro.Mobile_Members,id);
    }


    /**
     * Metodo utilizado para assinatura das mensagens postadas
     * @param horarioAtual horario do sistema
     */
    @Override
    public void postar(Horario horarioAtual) {

        if (horarioAtual == Horario.Normal){
            System.out.println("\"Happy Coding!\"");
        }
        else{
            System.out.println("\"Happy_C0d1ng. Maskers\"");
        }
    }
}
