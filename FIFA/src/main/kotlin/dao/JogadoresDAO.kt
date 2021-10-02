package dao

import models.Jogador
import java.sql.DriverManager

class JogadoresDAO: GenericoDAO {
    override fun pegarUm(id: Int): Any {
        val usuariodb:String
        val  senhadb: String
        usuariodb = "root"
        senhadb = "TESTEfutreview"
        // cria a conexão com o banco
        val connection = DriverManager.getConnection("jdbc:mysql://[(host=localhost,port=3306,user=${usuariodb},password=${senhadb})]/fifa")
        // cria um caminho para realizar queries sql no banco
        val sqlStatement = connection.createStatement()
        //executa uma query de busca
        val resultSet = sqlStatement.executeQuery("Select * FROM jogador WHERE idJogador==${id};")
        //passa pelos resultados obtidos
        var jogador: Jogador? = null
        while (resultSet.next()){
            jogador = Jogador(
                resultSet.getInt("idJogador"),
                resultSet.getNString("nomeJogador"),
                resultSet.getInt("idTime"),
                resultSet.getInt("idGeral")
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
        usuariodb = "root"
        senhadb = "TESTEfutreview"
        // cria a conexão com o banco
        val connection = DriverManager.getConnection("jdbc:mysql://[(host=localhost,port=3306,user=${usuariodb},password=${senhadb})]/fifa")
        // cria um caminho para realizar queries sql no banco
        val sqlStatement = connection.createStatement()
        //executa uma query de busca
        val resultSet = sqlStatement.executeQuery("Select * FROM jogador;")
        //passa pelos resultados obtidos
        val jogadores: MutableList<Jogador> = mutableListOf()
        while (resultSet.next()){
            jogadores.add(Jogador(
                resultSet.getInt("idJogador"),
                resultSet.getNString("nomeJogador"),
                resultSet.getInt("idTime"),
                resultSet.getInt("idGeral")
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