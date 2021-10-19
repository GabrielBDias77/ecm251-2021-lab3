import dao.*
import models.*


fun main(args: Array<String>) {
    val paisDao = PaisDAO()
    paisDao.pegarTodos()

// jogadoresDao.inserirUm(Jogador(0,"Neymar",27,"Neymar",178,80,"1985-12-20",2,1,1,1,"LW",5,5,"Right","high","low",91,99,85,87,87,87,87))
//    jogadoresDao.inserirVarios(listOf(Jogador(0,"Kevin De Bruyne",3),Jogador(0,"Lewandowski",4)))
//    jogadoresDao.atualizar(Jogador(0,"Kevin De Bruyne",3))
//jogadoresDao.deletar(13754)

    //INSERT INTO Jogador(idJogador,resource_id,nomeJogador,idade,resource_base_id,fut_bin_id,first_name,last_name,nomeComum,altura,peso,aniversario,idLiga,idPais,idEquipe,idRaridade,posicao,estrelaDrible,pernaRuim,perna,dedicacaoAtaque,dedicacaoDefesa,total_stats,total_stats_in_game,geral,rating_average,velocidade,chute,passe,drible,defesa,fisico,pace_attributes,shooting_attributes,passing_attributes,dribbling_attributes,defending_attributes,physicality_attributes,goalkeeper_attributes) VALUES

}
