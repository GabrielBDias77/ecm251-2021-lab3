package ktor

import dao.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.cio.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import models.Jogador
import models.Liga
import models.Usuario

fun Application.configureRouting() {
    val avaliacaoDao = AvaliacaoDAO()
    val paisDao = PaisDAO()
    val equipeDao = EquipeDAO()
    val jogadoresDao = JogadoresDAO()
    val ligaDao = LigaDAO()
    val raridadeDao = RaridadeDAO()
    val usuarioDao = UsuarioDAO()


    routing {
        get("/") {
            call.respondText("HOME PAGE!!!!")
        }
        get("/Player/{nome}") {
            call.respondText("Bem-VIndo ${call.parameters["nome"]}")
        }
        route("/Jogador") {
            get {
                call.respond(jogadoresDao.pegarTodos())
            }
            get("{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(jogadoresDao.pegarUm(num!!))
            }
        }
        route("/Pais") {
            get {
                call.respond(paisDao.pegarTodos())
            }
            get("{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(paisDao.pegarUm(num!!))
            }
        }
        route("/Avaliacao") {
            get {
                call.respondText("${avaliacaoDao.pegarTodos()}")
            }
            get("{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(avaliacaoDao.pegarUm(num!!))
            }
        }
        route("/Equipe") {
            get {
                call.respond("${equipeDao.pegarTodos()}")
            }
            get("{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(equipeDao.pegarUm(num!!))
            }
        }
        route("Liga") {
            get {
                call.respond(ligaDao.pegarTodos())
            }
            get("{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(ligaDao.pegarUm(num!!))
            }
        }

        route("Raridade") {
            get {
                call.respond(raridadeDao.pegarTodos())
            }
            get("{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(raridadeDao.pegarUm(num!!))
            }
        }
        route("Usuario") {
            get {
                call.respond(usuarioDao.pegarTodos())
            }
            get("{id}") {
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(usuarioDao.pegarUm(num!!))
            }
//            post("/add") {
//                val formParameters = call.receiveParameters()
//                val id = formParameters["idusuario"]!!.toInt()
//                val nome = formParameters["nomeUsuario"].toString()
//                val email = formParameters["emailUsuario"].toString()
//                val senha = formParameters["senhaUsuario"].toString()
//                val usuario = "${id},${nome},${email},${senha}"
//                call.respond(usuarioDao.inserirUm(usuario))
//            }


        }
    }
}