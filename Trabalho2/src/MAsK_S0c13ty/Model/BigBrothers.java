package MAsK_S0c13ty.Model;

import MAsK_S0c13ty.Enum.Horario;
import MAsK_S0c13ty.Enum.TipoMembro;

public class BigBrothers extends Membros {
    /**
     * Construtor da classe dos Bis_Brothers
     * @param nome nome do usuario
     * @param email email do usuario
     * @param id id do usuario
     */
    public BigBrothers(String nome, String email, int id) {
        super(nome,email, TipoMembro.Big_Brothers,id);
    }


    /**
     * Metodo utilizado para assinatura das mensagens postadas
     * @param horarioAtual horario do sistema
     */
    @Override
    public void postar(Horario horarioAtual) {

        if (horarioAtual == Horario.Normal){
            System.out.println("\"Sempre ajudando as pessoas membros ou não S2!\"");
        }
        else{
            System.out.println("\"...\"");
        }
    }
}
