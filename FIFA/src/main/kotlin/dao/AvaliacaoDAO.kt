package dao

import com.google.gson.GsonBuilder
import models.Avaliacao

class AvaliacaoDAO: GenericoDAO {

    override fun pegarUm(id: Int): Any {

        var avaliacao: Avaliacao? = null
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Equipe WHERE idEquipe=${id};")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                avaliacao = Avaliacao(
                    resultSet.getInt("idAvaliacao"),
                    resultSet.getInt("idJogador"),
                    resultSet.getInt("idUsuario"),
                    resultSet.getString("AvaliacaoCompleta")

                )

                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val jsonAvaliacao: String = gsonPretty.toJson(avaliacao)
                println(jsonAvaliacao)
            }
            conexao.fechar()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }

        return  avaliacao!!
    }

    override fun pegarTodos(): List<Any> {

        val avaliacoes = mutableListOf<Avaliacao>()
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Avaliacao;")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                avaliacoes.add(
                    Avaliacao(
                        resultSet.getInt("idAvaliacao"),
                        resultSet.getInt("idJogador"),
                        resultSet.getInt("idUsuario"),
                        resultSet.getString("AvaliacaoCompleta")
                    )
                )
            }
            for (avaliacoes in avaliacoes) {
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val jsonAvaliacoes: String = gsonPretty.toJson(avaliacoes)
                println(jsonAvaliacoes)
            }

        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
        return  avaliacoes
    }

    override fun inserirUm(objeto: Any) {
        val conexao = ConexaoDao()
        val avaliacao = objeto as Avaliacao
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
            INSERT INTO Avaliacao
            (idAvaliacao, idJogador, idUsuario, avaliacaoCompleta)
            VALUES(?,?,?,?)
            """.trimMargin()
            )

            preparedStatement?.setInt(1, avaliacao.idAvaliacao)
            preparedStatement?.setInt(2, avaliacao.idJogador)
            preparedStatement?.setInt(3, avaliacao.idUsuario)
            preparedStatement?.setString(4,avaliacao.avaliacaoCompleta)
            preparedStatement?.executeUpdate()
        }

        catch(exception : Exception) {
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
    }

    override fun inserirVarios(Lista: List<Any>) {
        val conexao = ConexaoDao()
        try {


            val preparedStatement = conexao.getPreparedStatement(
                """
             INSERT INTO Avaliacao
            (idAvaliacao, idJogador, idUsuario, avaliacaoCompleta)
            VALUES(?,?,?,?)
            """.trimMargin()
            )
            for (objeto in Lista) {
                val avaliacao = objeto as Avaliacao
                preparedStatement?.setInt(1, avaliacao.idAvaliacao)
                preparedStatement?.setInt(2, avaliacao.idJogador)
                preparedStatement?.setInt(3, avaliacao.idUsuario)
                preparedStatement?.setString(4,avaliacao.avaliacaoCompleta)
                preparedStatement?.executeUpdate()
            }
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
    }

    override fun atualizar(objeto: Any) {
        val conexao = ConexaoDao()
        val avaliacao = objeto as Avaliacao
        try {

            val preparedStatement = conexao.getPreparedStatement(
                """
                UPDATE Avaliacao
                SET idAvaliacao = ?, idJogador = ?, idUsuario = ?, avaliacaoCompleta = ?
                Where idAvaliacao = ?;
                """.trimMargin()
            )

            preparedStatement?.setInt(1, avaliacao.idAvaliacao)
            preparedStatement?.setInt(2, avaliacao.idJogador)
            preparedStatement?.setInt(3, avaliacao.idUsuario)
            preparedStatement?.setString(4,avaliacao.avaliacaoCompleta)
            preparedStatement?.executeUpdate()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
    }

    override fun deletar(idAvaliacao: Int) {
        val conexao = ConexaoDao()
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
                DELETE FROM Avaliacao
                Where idAvaliacao = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, idAvaliacao)
            preparedStatement?.executeUpdate()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }

    }
}