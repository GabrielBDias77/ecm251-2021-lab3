package dao

import models.Jogador
import shared.ConectarDb


class JogadoresDAO: GenericoDAO {

    override fun pegarUm(id: Int): Any {

        var jogador: Jogador? = null
        var conexao : ConexaoDao? = null
        try {
        // cria a conexão com o banco
         conexao = ConexaoDao()
        //executa uma query de busca
        val resultSet = conexao.executarQuery("Select * FROM Jogador WHERE idJogador=${id};")
        //passa pelos resultados obtidos
        while (resultSet?.next()!!) {
            jogador = Jogador(
                resultSet.getInt("idJogador"),
                resultSet.getNString("nomeJogador"),
                resultSet.getInt("idEquipe")
            )

            println("Jogador encontrado: ${jogador}")
        }
        conexao.fechar()
    }
    catch (exception : Exception){
        exception.printStackTrace()
    }
        finally {
            conexao?.fechar()
        }

        return  jogador!!
    }

    override fun pegarTodos(): List<Any> {
        val jogadores = mutableListOf<Jogador>()
        var conexao : ConexaoDao? = null
        try {


            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Jogador;")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                jogadores.add(
                    Jogador(
                        resultSet.getInt("idJogador"),
                        resultSet.getNString("nomeJogador"),
                        resultSet.getInt("idEquipe")
                    )
                )
            }
            for (jogadores in jogadores) {
                println("${jogadores}")
            }

        }
        catch (exception : Exception){
                exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
        return  jogadores
    }

    override fun inserirUm(objeto: Any) {
        val conexao = ConexaoDao()
        val preparedStatement = conexao.getPreparedStatement("""
            INSERT INTO Jogador
            (nomeJogador , idEquipe)
            VALUES(?,?)
            """.trimMargin())
        val jogador = objeto as Jogador
        preparedStatement?.setString(1,jogador.nomeJogador)
        preparedStatement?.setInt(2,jogador.idEquipe)
        preparedStatement?.executeUpdate()
        //conexao.commit()
        conexao.fechar()
    }

    override fun inserirVarios(Lista: List<Any>) {
        val conexao = ConexaoDao()
        val preparedStatement = conexao.getPreparedStatement("""
            INSERT INTO Jogador
            (nomeJogador , idEquipe)
            VALUES(?,?)
            """.trimMargin())
        for (objeto in Lista) {
            val jogador = objeto as Jogador
            preparedStatement?.setString(1, jogador.nomeJogador)
            preparedStatement?.setInt(2, jogador.idEquipe)
            preparedStatement?.executeUpdate()
            //conexao.commit()
        }
            conexao.fechar()
    }

    override fun atualizar(objeto: Any) {
        val conexao = ConexaoDao()
        val preparedStatement = conexao.getPreparedStatement("""
            UPDATE Jogador
            SET nomeJogador = ? ,idEquipe = ?
            Where id = ?;
            """.trimMargin())
        val jogador = objeto as Jogador
        preparedStatement?.setString(1,jogador.nomeJogador)
        preparedStatement?.setInt(2,jogador.idEquipe)
        preparedStatement?.setInt(3,jogador.idJogador)
        preparedStatement?.executeUpdate()
        //conexao.commit()
        conexao.fechar()
    }

    override fun deletar(IdJogador: Int) {
        val conexao = ConexaoDao()
        val preparedStatement = conexao.getPreparedStatement("""
            DELETE FROM Jogador
            Where id = ?;
            """.trimMargin())
        preparedStatement?.setInt(1,IdJogador)
        preparedStatement?.executeUpdate()
        //conexao.commit()
        conexao.fechar()
    }
}