package dao

import com.google.gson.GsonBuilder
import models.Pais

class PaisDAO: GenericoDAO {
    override fun pegarUm(id: Int): Any {

        var pais: Pais? = null
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Pais WHERE idPais=${id};")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                pais = Pais(
                    resultSet.getInt("idPais"),
                    resultSet.getString("nomePais")
                )

                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val jsonPais: String = gsonPretty.toJson(pais)
                println(jsonPais)
            }
            conexao.fechar()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }

        return  pais!!
    }

    override fun pegarTodos(): List<Any> {
        val paises = mutableListOf<Pais>()
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Pais;")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                paises.add(
                    Pais(
                        resultSet.getInt("idPais"),
                        resultSet.getString("nomePais")
                    )
                )
            }
            for (paises in paises) {
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val jsonPaises: String = gsonPretty.toJson(paises)
                println(jsonPaises)
            }

        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
        return  paises
    }

    override fun inserirUm(objeto: Any) {
        val conexao = ConexaoDao()
        val pais = objeto as Pais
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
            INSERT INTO Pais
            (idPais, nomePais)
            VALUES(?,?)
            """.trimMargin()
            )
            preparedStatement?.setInt(1, pais.idPais)
            preparedStatement?.setString(2, pais.nomePais)
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
             INSERT INTO Pais
            (idPais, nomePais)
            VALUES(?,?)
            """.trimMargin()
            )
            for (objeto in Lista) {
                val pais = objeto as Pais
                preparedStatement?.setInt(1, pais.idPais)
                preparedStatement?.setString(2, pais.nomePais)
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
        val pais = objeto as Pais
        try {

            val preparedStatement = conexao.getPreparedStatement(
                """
                UPDATE Pais
                SET idPais = ?, nomePais = ?
                Where idPais = ?;
                """.trimMargin()
            )

            preparedStatement?.setInt(1, pais.idPais)
            preparedStatement?.setString(2, pais.nomePais)
            preparedStatement?.executeUpdate()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
    }

    override fun deletar(idPais: Int) {
        val conexao = ConexaoDao()
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
                DELETE FROM Pais
                Where idPais = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, idPais)
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