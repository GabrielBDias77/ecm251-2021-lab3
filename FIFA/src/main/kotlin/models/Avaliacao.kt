package models

data class Avaliacao(
    val idAvaliacao: Int,
    val idJogador: Int,
    val idUsuario: Int,
    val avaliacaoCompleta: String
)
