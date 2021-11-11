package models

import kotlinx.serialization.*


@Serializable
data class Liga(
    val idLiga: Int,
    val nomeLiga: String,
    val idPais: Int
)

