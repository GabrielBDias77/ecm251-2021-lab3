package dao

import models.Jogador

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
                resultSet.getString("nomeJogador"),
                resultSet.getInt("idade"),
                resultSet.getString("nomeComum"),
                resultSet.getInt("altura"),
                resultSet.getInt("peso"),
                resultSet.getString("aniversario"),
                resultSet.getInt("idLiga"),
                resultSet.getInt("idPais"),
                resultSet.getInt("idEquipe"),
                resultSet.getInt("idRaridade"),
                resultSet.getString("posicao"),
                resultSet.getInt("estrelaDrible"),
                resultSet.getInt("pernaRuim"),
                resultSet.getString("perna"),
                resultSet.getString("dedicacaoAtaque"),
                resultSet.getString("dedicacaoDefesa"),
                resultSet.getInt("geral"),
                resultSet.getInt("velocidade"),
                resultSet.getInt("chute"),
                resultSet.getInt("passe"),
                resultSet.getInt("drible"),
                resultSet.getInt("defesa"),
                resultSet.getInt("fisico")
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
                        resultSet.getString("nomeJogador"),
                        resultSet.getInt("idade"),
                        resultSet.getString("nomeComum"),
                        resultSet.getInt("altura"),
                        resultSet.getInt("peso"),
                        resultSet.getString("aniversario"),
                        resultSet.getInt("idLiga"),
                        resultSet.getInt("idPais"),
                        resultSet.getInt("idEquipe"),
                        resultSet.getInt("idRaridade"),
                        resultSet.getString("posicao"),
                        resultSet.getInt("estrelaDrible"),
                        resultSet.getInt("pernaRuim"),
                        resultSet.getString("perna"),
                        resultSet.getString("dedicacaoAtaque"),
                        resultSet.getString("dedicacaoDefesa"),
                        resultSet.getInt("geral"),
                        resultSet.getInt("velocidade"),
                        resultSet.getInt("chute"),
                        resultSet.getInt("passe"),
                        resultSet.getInt("drible"),
                        resultSet.getInt("defesa"),
                        resultSet.getInt("fisico")


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
        val jogador = objeto as Jogador
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
            INSERT INTO Jogador
            (nomeJogador, idade, nomeComum, altura, peso, aniversario, idLiga, idPais, idEquipe, idRaridade, posicao, estrelaDrible, pernaRuim, perna, dedicacaoAtaque, dedicacaoDefesa, geral, velocidade, chute, passe, drible, defesa, fisico )
            VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
            """.trimMargin()
            )

            preparedStatement?.setString(1, jogador.nomeJogador)
            preparedStatement?.setInt(2, jogador.idade)
            preparedStatement?.setString(3, jogador.nomeComum)
            preparedStatement?.setInt(4, jogador.altura)
            preparedStatement?.setInt(5, jogador.peso)
            preparedStatement?.setString(6, jogador.aniversario)
            preparedStatement?.setInt(7, jogador.idLiga)
            preparedStatement?.setInt(8, jogador.idPais)
            preparedStatement?.setInt(9, jogador.idEquipe)
            preparedStatement?.setInt(10, jogador.idRaridade)
            preparedStatement?.setString(11, jogador.posicao)
            preparedStatement?.setInt(12, jogador.estrelaDrible)
            preparedStatement?.setInt(13, jogador.pernaRuim)
            preparedStatement?.setString(14, jogador.perna)
            preparedStatement?.setString(15, jogador.dedicacaoAtaque)
            preparedStatement?.setString(16, jogador.dedicacaoDefesa)
            preparedStatement?.setInt(17, jogador.geral)
            preparedStatement?.setInt(18, jogador.velocidade)
            preparedStatement?.setInt(19, jogador.chute)
            preparedStatement?.setInt(20, jogador.passe)
            preparedStatement?.setInt(21, jogador.drible)
            preparedStatement?.setInt(22, jogador.defesa)
            preparedStatement?.setInt(23, jogador.fisico)
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
             INSERT INTO Jogador
            (nomeJogador, idade, nomeComum, altura, peso, aniversario, idLiga, idPais, idEquipe, idRaridade, posicao, estrelaDrible, pernaRuim, perna, dedicacaoAtaque, dedicacaoDefesa, geral, velocidade, chute, passe, drible, defesa, fisico )
            VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
            """.trimMargin()
            )
            for (objeto in Lista) {
                val jogador = objeto as Jogador
                preparedStatement?.setString(1, jogador.nomeJogador)
                preparedStatement?.setInt(2, jogador.idade)
                preparedStatement?.setString(3, jogador.nomeComum)
                preparedStatement?.setInt(4, jogador.altura)
                preparedStatement?.setInt(5, jogador.peso)
                preparedStatement?.setString(6, jogador.aniversario)
                preparedStatement?.setInt(7, jogador.idLiga)
                preparedStatement?.setInt(8, jogador.idPais)
                preparedStatement?.setInt(9, jogador.idEquipe)
                preparedStatement?.setInt(10, jogador.idRaridade)
                preparedStatement?.setString(11, jogador.posicao)
                preparedStatement?.setInt(12, jogador.estrelaDrible)
                preparedStatement?.setInt(13, jogador.pernaRuim)
                preparedStatement?.setString(14, jogador.perna)
                preparedStatement?.setString(15, jogador.dedicacaoAtaque)
                preparedStatement?.setString(16, jogador.dedicacaoDefesa)
                preparedStatement?.setInt(17, jogador.geral)
                preparedStatement?.setInt(18, jogador.velocidade)
                preparedStatement?.setInt(19, jogador.chute)
                preparedStatement?.setInt(20, jogador.passe)
                preparedStatement?.setInt(21, jogador.drible)
                preparedStatement?.setInt(22, jogador.defesa)
                preparedStatement?.setInt(23, jogador.fisico)
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
        val jogador = objeto as Jogador
        try {

            val preparedStatement = conexao.getPreparedStatement(
                """
                UPDATE Jogador
                SET nomeJogador = ?, idade = ?, nomeComum = ?, altura = ?, peso = ?, aniversario = ?, idLiga = ?, idPais = ?, idEquipe = ?, idRaridade = ?, posicao = ?, estrelaDrible = ?, pernaRuim = ?, perna = ?, dedicacaoAtaque = ?, dedicacaoDefesa = ?, geral = ?, velocidade = ?, chute = ?, passe = ?, drible = ?, defesa = ?, fisico = ?
                Where idJogador = ?;
                """.trimMargin()
            )

            preparedStatement?.setString(1, jogador.nomeJogador)
            preparedStatement?.setInt(2, jogador.idade)
            preparedStatement?.setString(3, jogador.nomeComum)
            preparedStatement?.setInt(4, jogador.altura)
            preparedStatement?.setInt(5, jogador.peso)
            preparedStatement?.setString(6, jogador.aniversario)
            preparedStatement?.setInt(7, jogador.idLiga)
            preparedStatement?.setInt(8, jogador.idPais)
            preparedStatement?.setInt(9, jogador.idEquipe)
            preparedStatement?.setInt(10, jogador.idRaridade)
            preparedStatement?.setString(11, jogador.posicao)
            preparedStatement?.setInt(12, jogador.estrelaDrible)
            preparedStatement?.setInt(13, jogador.pernaRuim)
            preparedStatement?.setString(14, jogador.perna)
            preparedStatement?.setString(15, jogador.dedicacaoAtaque)
            preparedStatement?.setString(16, jogador.dedicacaoDefesa)
            preparedStatement?.setInt(17, jogador.geral)
            preparedStatement?.setInt(18, jogador.velocidade)
            preparedStatement?.setInt(19, jogador.chute)
            preparedStatement?.setInt(20, jogador.passe)
            preparedStatement?.setInt(21, jogador.drible)
            preparedStatement?.setInt(22, jogador.defesa)
            preparedStatement?.setInt(23, jogador.fisico)
            preparedStatement?.setInt(24, jogador.idJogador)
            preparedStatement?.executeUpdate()
        }
        catch (exception : Exception){
            exception.printStackTrace()
        }
        finally {
            conexao?.fechar()
        }
    }

    override fun deletar(idJogador: Int) {
        val conexao = ConexaoDao()
        try {
            val preparedStatement = conexao.getPreparedStatement(
                """
                DELETE FROM Jogador
                Where idJogador = ?;
                """.trimMargin()
            )
            preparedStatement?.setInt(1, idJogador)
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