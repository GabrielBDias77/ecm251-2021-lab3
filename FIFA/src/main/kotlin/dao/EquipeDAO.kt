package dao

import models.Equipe

class EquipeDAO: GenericoDAO {
    override fun pegarUm(id: Int): Any {

    var equipe: Equipe? = null
    var conexao : ConexaoDao? = null
    try {
        // cria a conexão com o banco
        conexao = ConexaoDao()
        //executa uma query de busca
        val resultSet = conexao.executarQuery("Select * FROM Equipe WHERE idEquipe=${id};")
        //passa pelos resultados obtidos
        while (resultSet?.next()!!) {
            equipe = Equipe(
                resultSet.getInt("idEquipe"),
                resultSet.getString("nomeEquipe"),
                resultSet.getInt("idLiga")

            )

            println("Equipe encontrada: ${equipe}")
        }
        conexao.fechar()
    }
    catch (exception : Exception){
        exception.printStackTrace()
    }
    finally {
        conexao?.fechar()
    }

    return  equipe!!
}

    override fun pegarTodos(): List<Any> {
        val equipes = mutableListOf<Equipe>()
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Equipe;")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                equipes.add(
                    Equipe(
                        resultSet.getInt("idEquipe"),
                        resultSet.getString("nomeEquipe"),
                        resultSet.getInt("idLiga")
                    )
                )
            }
            for (equipes in equipes) {
                println("${equipes}")
            }

        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
        return  equipes
    }

    override fun inserirUm(objeto: Any) {
        val conexao = ConexaoDao()
        val equipe = objeto as Equipe
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
            INSERT INTO Equipe
            (idEquipe, nomeEquipe, idLiga)
            VALUES(?,?,?)
            """.trimMargin()
            )

            preparedStatement?.setInt(1, equipe.idEquipe)
            preparedStatement?.setString(2, equipe.nomeEquipe)
            preparedStatement?.setInt(3, equipe.idLiga)
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
             INSERT INTO Equipe
            (idEquipe, nomeEquipe, idLiga)
            VALUES(?,?,?)
            """.trimMargin()
            )
            for (objeto in Lista) {
                val equipe = objeto as Equipe
                preparedStatement?.setInt(1, equipe.idEquipe)
                preparedStatement?.setString(2, equipe.nomeEquipe)
                preparedStatement?.setInt(3, equipe.idLiga)
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
        val equipe = objeto as Equipe
        try {

            val preparedStatement = conexao.getPreparedStatement(
                """
                UPDATE Equipe
                SET idEquipe = ?, nomeEquipe = ?, idLiga = ?
                Where idEquipe = ?;
                """.trimMargin()
            )

            preparedStatement?.setInt(1, equipe.idEquipe)
            preparedStatement?.setString(2, equipe.nomeEquipe)
            preparedStatement?.setInt(3, equipe.idLiga)
            preparedStatement?.executeUpdate()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
    }

    override fun deletar(idEquipe: Int) {
        val conexao = ConexaoDao()
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
                DELETE FROM Equipe
                Where idEquipe = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, idEquipe)
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
