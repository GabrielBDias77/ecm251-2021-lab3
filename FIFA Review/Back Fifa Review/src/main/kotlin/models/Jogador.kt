package models

import kotlinx.serialization.*

@Serializable
data class Jogador(
    val idJogador: Int,
    val nomeJogador:String,
    val idade:Int,
    val nomeComum:String,
    val altura:Int,
    val peso:Int,
    val aniversario: String,
    val idLiga:Int,
    val idPais:Int,
    val idEquipe:Int,
    val idRaridade:Int,
    val posicao:String,
    val estrelaDrible:Int,
    val pernaRuim:Int,
    val perna:String,
    val dedicacaoAtaque:String,
    val dedicacaoDefesa:String,
    val geral:Int,
    val velocidade:Int,
    val chute:Int,
    val passe:Int,
    val drible:Int,
    val defesa:Int,
    val fisico:Int
)
