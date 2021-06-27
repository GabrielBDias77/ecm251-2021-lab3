package MAsK_S0c13ty.Model;

import MAsK_S0c13ty.Enum.Horario;
import MAsK_S0c13ty.Enum.TipoMembro;

public class HeavyLifters extends Membros {
    /**
     * Construtor da classe dos Mobiles_Members
     * @param nome nome do usuario
     * @param email email do usuario
     * @param id id do usuario
     */
    public HeavyLifters(String nome, String email, int id) {
        super(nome,email, TipoMembro.Heavy_Lifters,id);
    }


    /**
     * Metodo utilizado para assinatura das mensagens postadas
     * @param horarioAtual horario do sistema
     */
    @Override
    public void postar(Horario horarioAtual) {

        if (horarioAtual == Horario.Normal){
            System.out.println("\"Podem contar conosco!\"");
        }
        else{
            System.out.println("\"N00b_qu3_n_Se_r3pita.bat\"");
        }
    }
}
