import dao.JogadoresDAO
import models.Jogador
import java.sql.DriverManager

fun main(args: Array<String>) {
    val jogadoresDao = JogadoresDAO()
    val jogadores = jogadoresDao.pegarTodos()

}

//val usuariodb:String
//val  senhadb: String
//usuariodb = "admin"
//senhadb = "admin"
// cria a conexão com o banco
//val connection = DriverManager.getConnection("jdbc:mysql://[(host=10.33.162.153,port=3306,user=${usuariodb},password=${senhadb})]/FIFA")
// cria um caminho para realizar queries sql no banco
//val sqlStatement = connection.createStatement()
//executa uma query de busca
//val resultSet = sqlStatement.executeQuery("Select * FROM Jogador;")
//passa pelos resultados obtidos
//while (resultSet.next()){
//    val jogador = Jogador(
//        resultSet.getInt("idJogador"),
//        resultSet.getNString("nomeJogador"),
//        resultSet.getInt("idEquipe")
//    )
//    println("Jogador encontrado: ${jogador}")
//}
//resultSet.close()
//connection.close()