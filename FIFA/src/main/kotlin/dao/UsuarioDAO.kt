package dao

import com.google.gson.GsonBuilder
import models.Usuario

class UsuarioDAO: GenericoDAO {
    override fun pegarUm(id: Int): Any {

        var usuario: Usuario? = null
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Usuario WHERE idUsuario=${id};")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                usuario = Usuario(
                    resultSet.getInt("idUsuario"),
                    resultSet.getString("nomeUsuario"),
                    resultSet.getString("emailUsuario"),
                    resultSet.getString("senhaUsuario")

                )

                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val jsonUsuario: String = gsonPretty.toJson(usuario)
                println(jsonUsuario)
            }
            conexao.fechar()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }

        return  usuario!!
    }

    override fun pegarTodos(): List<Any> {
        val usuarios = mutableListOf<Usuario>()
        var conexao : ConexaoDao? = null
        try {
            // cria a conexão com o banco
            conexao = ConexaoDao()
            //executa uma query de busca
            val resultSet = conexao.executarQuery("Select * FROM Usuario;")
            //passa pelos resultados obtidos
            while (resultSet?.next()!!) {
                usuarios.add(
                    Usuario(
                        resultSet.getInt("idUsuario"),
                        resultSet.getString("nomeUsuario"),
                        resultSet.getString("emailUsuario"),
                        resultSet.getString("senhaUsuario")
                    )
                )
            }
            for (usuarios in usuarios) {
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val jsonUsuarios: String = gsonPretty.toJson(usuarios)
                println(jsonUsuarios)
            }

        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
        return  usuarios
    }

    override fun inserirUm(objeto: Any) {
        val conexao = ConexaoDao()
        val usuario = objeto as Usuario
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
            INSERT INTO Usuario
            (idUsuario, nomeUsuario, emailUsuario, senhaUsuario)
            VALUES(?,?,?,?)
            """.trimMargin()
            )
            preparedStatement?.setInt(1, usuario.idUsuario)
            preparedStatement?.setString(2, usuario.nomeUsuario)
            preparedStatement?.setString(3, usuario.emailUsuario)
            preparedStatement?.setString(4, usuario.senhaUsuario)
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
             INSERT INTO Usuario
            (idUsuario, nomeUsuario, emailUsuario, senhaUsuario)
            VALUES(?,?,?,?)
            """.trimMargin()
            )
            for (objeto in Lista) {
                val usuario = objeto as Usuario
                preparedStatement?.setInt(1, usuario.idUsuario)
                preparedStatement?.setString(2, usuario.nomeUsuario)
                preparedStatement?.setString(3, usuario.emailUsuario)
                preparedStatement?.setString(4, usuario.senhaUsuario)
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
        val usuario = objeto as Usuario
        try {

            val preparedStatement = conexao.getPreparedStatement(
                """
                UPDATE Usuario
                SET idUsuario = ?, nomeUsuario = ?, emailUsuario = ?, senhaUsuario = ?
                Where idUsuario = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, usuario.idUsuario)
            preparedStatement?.setString(2, usuario.nomeUsuario)
            preparedStatement?.setString(3, usuario.emailUsuario)
            preparedStatement?.setString(4, usuario.senhaUsuario)
            preparedStatement?.executeUpdate()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
    }

    override fun deletar(idUsuario: Int) {
        val conexao = ConexaoDao()
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
                DELETE FROM Usuario
                Where idUsuario = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, idUsuario)
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