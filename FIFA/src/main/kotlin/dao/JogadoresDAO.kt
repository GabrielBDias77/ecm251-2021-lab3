package dao

import models.Jogador
import java.sql.DriverManager

class JogadoresDAO: GenericoDAO {
    override fun pegarUm(id: Int): Any {
        val usuariodb:String
        val  senhadb: String
        usuariodb = "admin"
        senhadb = "admin"
        // cria a conexão com o banco
        val connection = DriverManager.getConnection("jdbc:mysql://[(host=10.33.162.153,port=3306,user=${usuariodb},password=${senhadb})]/FIFA")
        // cria um caminho para realizar queries sql no banco
        val sqlStatement = connection.createStatement()
        //executa uma query de busca
        val resultSet = sqlStatement.executeQuery("Select * FROM Jogador WHERE idJogador==${id};")
        //passa pelos resultados obtidos
        var jogador: Jogador? = null
        while (resultSet.next()){
            jogador = Jogador(
                resultSet.getInt("idJogador"),
                resultSet.getNString("nomeJogador"),
                resultSet.getInt("idEquipe")
            )
            println("Jogador encontrado: ${jogador}")
        }
        resultSet.close()
        connection.close()
        return  jogador!!
    }

    override fun pegarTodos(): List<Any> {
        val usuariodb:String
        val  senhadb: String
        usuariodb = "admin"
        senhadb = "admin"
        // cria a conexão com o banco
        val connection = DriverManager.getConnection("jdbc:mysql://[(host=10.33.162.153,port=3306,user=${usuariodb},password=${senhadb})]/FIFA")
        // cria um caminho para realizar queries sql no banco
        val sqlStatement = connection.createStatement()
        //executa uma query de busca
        val resultSet = sqlStatement.executeQuery("Select * FROM Jogador;")
        //passa pelos resultados obtidos
        val jogadores = mutableListOf<Jogador>()
        while (resultSet.next()){
            jogadores.add(Jogador(
                resultSet.getInt("idJogador"),
                resultSet.getNString("nomeJogador"),
                resultSet.getInt("idEquipe")
            ))
        }
        println("Jogador encontrado: ${jogadores}")
        resultSet.close()
        connection.close()
        return  jogadores
    }

    override fun inserirUm(objeto: Any) {
        TODO("Not yet implemented")
    }

    override fun inserirVarios(Lista: List<Any>) {
        TODO("Not yet implemented")
    }

    override fun atualizar(objeto: Any) {
        TODO("Not yet implemented")
    }

    override fun deletar(Id: Int) {
        TODO("Not yet implemented")
    }
}