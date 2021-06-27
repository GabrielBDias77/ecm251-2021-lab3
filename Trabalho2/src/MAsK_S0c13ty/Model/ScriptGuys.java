package MAsK_S0c13ty.Model;

import MAsK_S0c13ty.Enum.Horario;
import MAsK_S0c13ty.Enum.TipoMembro;

public class ScriptGuys extends Membros {
    /**
     * Construtor da classe dos Script_Guys
     * @param nome nome do usuario
     * @param email email do usuario
     * @param id id do usuario
     */
    public ScriptGuys(String nome, String email, int id) {
        super(nome,email, TipoMembro.Script_Guys,id);
    }


    /**
     * Metodo utilizado para assinatura das mensagens postadas
     * @param horarioAtual horario do sistema
     */
    @Override
    public void postar(Horario horarioAtual) {

        if (horarioAtual == Horario.Normal){
            System.out.println("\"Prazer em ajudar novos amigos de código!\"");
        }
        else{
            System.out.println("\"QU3Ro_S3us_r3curs0s.py\"");
        }
    }
}
