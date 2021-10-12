import dao.JogadoresDAO
import models.Jogador
import java.sql.DriverManager

fun main(args: Array<String>) {
    val jogadoresDao = JogadoresDAO()
    val jogadores = jogadoresDao.pegarUm(1)

}
