package ktor

import dao.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    val avaliacaoDao = AvaliacaoDAO()
    val paisDao = PaisDAO()
    val equipeDao = EquipeDAO()
    val jogadoresDao = JogadoresDAO()
    val ligaDao = LigaDAO()
    val raridadeDao = RaridadeDAO()
    val usuarioDao = UsuarioDAO()

    embeddedServer(Netty, port = 80, host = "0.0.0.0") {


        install(StatusPages) {
            exception<Throwable> { e ->
                call.respondText(e.localizedMessage, ContentType.Text.Plain, HttpStatusCode.InternalServerError)
            }
        }

        routing {
            get("/"){
                call.respondText("HOME PAGE!!!!")
            }
            get("/Player/{nome}"){
                call.respondText("Bem-VIndo ${call.parameters["nome"]}")
            }
            get("/Jogadores"){
                call.respondText("${jogadoresDao.pegarTodos()}")
            }
            get("/Jogador/{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respondText("${jogadoresDao.pegarUm(num!!)}")
            }
            get("/Paises"){
                call.respondText("${paisDao.pegarTodos()}")
            }
            get("/Pais/{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respondText("${paisDao.pegarUm(num!!)}")
            }
            get("/Avaliacoes"){
                call.respondText("${avaliacaoDao.pegarTodos()}")
            }
            get("/Avaliacao/{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respondText("${avaliacaoDao.pegarUm(num!!)}")
            }
            get("/Equipes"){
                call.respondText("${equipeDao.pegarTodos()}")
            }
            get("/Equipe/{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respondText("${equipeDao.pegarUm(num!!)}")
            }
            get("/Ligas"){
                call.respondText("${ligaDao.pegarTodos()}")
            }
            get("/Liga/{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respondText("${ligaDao.pegarUm(num!!)}")
            }
            get("/Raridades"){
                call.respondText("${raridadeDao.pegarTodos()}")
            }
            get("/Raridade/{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respondText("${raridadeDao.pegarUm(num!!)}")
            }
            get("/Usuarios"){
                call.respondText("${usuarioDao.pegarTodos()}")
            }
            get("/Usuario/{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respondText("${usuarioDao.pegarUm(num!!)}")
            }

        }
    }.start(wait = true)
}