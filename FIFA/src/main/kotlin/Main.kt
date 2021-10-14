import dao.JogadoresDAO
import models.Jogador


fun main(args: Array<String>) {
    val jogadoresDao = JogadoresDAO()
    jogadoresDao.pegarTodos()

//    jogadoresDao.inserirUm(Jogador(0,"Neymar",1))
//    jogadoresDao.inserirVarios(listOf(Jogador(0,"Kevin De Bruyne",3),Jogador(0,"Lewandowski",4)))
//    jogadoresDao.atualizar(Jogador(0,"Kevin De Bruyne",3))
//    jogadoresDao.deletar(4)

}
