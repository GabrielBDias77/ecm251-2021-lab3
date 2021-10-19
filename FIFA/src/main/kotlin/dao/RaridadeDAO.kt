package dao

import models.Raridade

class RaridadeDAO: GenericoDAO {
    override fun pegarUm(id: Int): Any {

        var raridade: Raridade? = null
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Raridade WHERE idRaridade=${id};")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                raridade = Raridade(
                    resultSet.getInt("idRaridade"),
                    resultSet.getString("tipo")
                )

                println("Raridade encontrada: ${raridade}")
            }
            conexao.fechar()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }

        return  raridade!!
    }

    override fun pegarTodos(): List<Any> {
        val raridades = mutableListOf<Raridade>()
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Raridade;")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                raridades.add(
                    Raridade(
                        resultSet.getInt("idRaridade"),
                        resultSet.getString("tipo")
                    )
                )
            }
            for (raridades in raridades) {
                println("${raridades}")
            }

        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
        return  raridades
    }

    override fun inserirUm(objeto: Any) {
        val conexao = ConexaoDao()
        val raridade = objeto as Raridade
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
            INSERT INTO Raridade
            (idRaridade, tipo)
            VALUES(?,?)
            """.trimMargin()
            )
            preparedStatement?.setInt(1, raridade.idRaridade)
            preparedStatement?.setString(2, raridade.tipo)
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
             INSERT INTO Raridade
            (idRaridade, tipo)
            VALUES(?,?)
            """.trimMargin()
            )
            for (objeto in Lista) {
                val raridade = objeto as Raridade
                preparedStatement?.setInt(1, raridade.idRaridade)
                preparedStatement?.setString(2, raridade.tipo)
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
        val raridade = objeto as Raridade
        try {

            val preparedStatement = conexao.getPreparedStatement(
                """
                UPDATE Raridade
                SET idRaridade = ?, tipo = ?
                Where idRaridade = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, raridade.idRaridade)
            preparedStatement?.setString(2, raridade.tipo)
            preparedStatement?.executeUpdate()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
    }

    override fun deletar(idRaridade: Int) {
        val conexao = ConexaoDao()
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
                DELETE FROM Raridade
                Where idRaridade = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, idRaridade)
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