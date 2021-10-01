import models.Jogador
import java.sql.DriverManager

fun main(args: Array<String>) {
    val  senhadb: String
    senhadb = "TESTEfutreview"
    // cria a conexão com o banco
    val connection = DriverManager.getConnection("jdbc:mysql://[(host=localhost,port=3306,user=root,password=${senhadb})]/fifa")
    // cria um caminho para realizar queries sql no banco
    val sqlStatement = connection.createStatement()
    //executa uma query de busca
    val resultSet = sqlStatement.executeQuery("Select * FROM jogador;")
    //passa pelos resultados obtidos
    while (resultSet.next()){
        val jogador = Jogador(
            resultSet.getInt("idJogador"),
            resultSet.getNString("nomeJogador"),
            resultSet.getInt("idTime"),
            resultSet.getInt("idGeral")
        )
        println("Jogador encontrado: ${jogador}")
    }
    resultSet.close()
    connection.close()
}