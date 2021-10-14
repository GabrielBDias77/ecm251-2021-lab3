package dao

import models.Jogador
import shared.ConectarDb


class JogadoresDAO: GenericoDAO {
    override fun pegarUm(id: Int): Any {

        // cria a conexão com o banco
        val conexao = ConexaoDao()
        //executa uma query de busca
        val resultSet = conexao.executarQuery("Select * FROM Jogador WHERE idJogador=${id};")
        //passa pelos resultados obtidos
        var jogador: Jogador? = null
        while (resultSet?.next()!!){
            jogador = Jogador(
                resultSet.getInt("idJogador"),
                resultSet.getNString("nomeJogador"),
                resultSet.getInt("idEquipe")
            )

            println("Jogador encontrado: ${jogador}")
        }
        conexao.fechar()
        return  jogador!!
    }

    override fun pegarTodos(): List<Any> {



        // cria a conexão com o banco
        val conexao = ConexaoDao()
        //executa uma query de busca
        val resultSet = conexao.executarQuery("Select * FROM Jogador;")
        //passa pelos resultados obtidos
        val jogadores = mutableListOf<Jogador>()
        while (resultSet?.next()!!){
            jogadores.add(Jogador(
                resultSet.getInt("idJogador"),
                resultSet.getNString("nomeJogador"),
                resultSet.getInt("idEquipe")
            ))
        }
        for (jogadores in jogadores){
        println("${jogadores}")
        }
        conexao.fechar()
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