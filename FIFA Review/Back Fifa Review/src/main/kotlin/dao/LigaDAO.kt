package dao

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.serialization.Serializable
import models.Liga


@Serializable
class LigaDAO: GenericoDAO {




    override fun pegarUm(id: Int): Any {


        var liga: Liga? = null
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Liga WHERE idLiga=${id};")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                liga = Liga(
                    resultSet.getInt("idLiga"),
                    resultSet.getString("nomeLiga"),
                    resultSet.getInt("idPais")

                )
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val jsonLiga: String = gsonPretty.toJson(liga)
                println(jsonLiga)

            }
            conexao.fechar()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }

        return  liga!!
    }

    override fun pegarTodos(): List<Any> {
        val gsonPretty = GsonBuilder().setPrettyPrinting().create()

        val ligas = mutableListOf<Liga>()
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Liga;")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                ligas.add(
                    Liga(
                        resultSet.getInt("idLiga"),
                        resultSet.getString("nomeLiga"),
                        resultSet.getInt("idPais")
                    )
                )
            }
            for (ligas in ligas) {
                val jsonLigas: String = gsonPretty.toJson(ligas)
                println(jsonLigas)
            }

        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
        return  ligas
    }

    override fun inserirUm(objeto: Any) {
        val conexao = ConexaoDao()
        val liga = objeto as Liga
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
            INSERT INTO Liga
            (idLiga, nomeLiga, idPais)
            VALUES(?,?,?)
            """.trimMargin()
            )
            preparedStatement?.setInt(1, liga.idLiga)
            preparedStatement?.setString(2, liga.nomeLiga)
            preparedStatement?.setInt(3, liga.idPais)
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
             INSERT INTO Liga
            (idLiga, nomeLiga, idPais)
            VALUES(?,?,?)
            """.trimMargin()
            )
            for (objeto in Lista) {
                val liga = objeto as Liga
                preparedStatement?.setInt(1, liga.idLiga)
                preparedStatement?.setString(2, liga.nomeLiga)
                preparedStatement?.setInt(3, liga.idPais)
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
        val liga = objeto as Liga
        try {

            val preparedStatement = conexao.getPreparedStatement(
                """
                UPDATE Liga
                SET idLiga = ?, nomeLiga = ?, idPais = ?
                Where idLiga = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, liga.idLiga)
            preparedStatement?.setString(2, liga.nomeLiga)
            preparedStatement?.setInt(3, liga.idPais)
            preparedStatement?.executeUpdate()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
    }

    override fun deletar(idLiga: Int) {
        val conexao = ConexaoDao()
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
                DELETE FROM Liga
                Where idLiga = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, idLiga)
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