package ktor

import dao.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import models.*

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
        get("/Teste/{nome}") {
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
            post("/add") {
                val formParameters = call.receiveParameters()
                val id = formParameters["idJogador"]!!.toInt()
                val nome = formParameters["nomeJogador"].toString()
                val idade = formParameters["idade"]!!.toInt()
                val nomeComum = formParameters["nomeComum"].toString()
                val altura = formParameters["altura"]!!.toInt()
                val peso = formParameters["peso"]!!.toInt()
                val aniversario = formParameters["aniversario"].toString()
                val idLiga = formParameters["idLiga"]!!.toInt()
                val idPais = formParameters["idPais"]!!.toInt()
                val idEquipe = formParameters["idEquipe"]!!.toInt()
                val idRaridade = formParameters["idRaridade"]!!.toInt()
                val posicao = formParameters["posicao"].toString()
                val estrelaDrible = formParameters["estrelaDrible"]!!.toInt()
                val pernaRuim = formParameters["pernaRuim"]!!.toInt()
                val perna = formParameters["perna"].toString()
                val dedicacaoAtaque = formParameters["dedicacaoAtaque"].toString()
                val dedicacaoDefesa = formParameters["dedicacaoDefesa"].toString()
                val geral = formParameters["geral"]!!.toInt()
                val velocidade = formParameters["velocidade"]!!.toInt()
                val chute = formParameters["chute"]!!.toInt()
                val passe = formParameters["passe"]!!.toInt()
                val drible = formParameters["drible"]!!.toInt()
                val defesa = formParameters["defesa"]!!.toInt()
                val fisico = formParameters["fisico"]!!.toInt()

                call.respond(jogadoresDao.inserirUm(Jogador(id,nome,idade,nomeComum,altura,peso,aniversario,idLiga,idPais,idEquipe,
                idRaridade,posicao,estrelaDrible,pernaRuim,perna,dedicacaoAtaque,dedicacaoDefesa,geral,velocidade,chute,passe,drible,defesa,fisico)))
            }
            delete("/delete/{id}"){
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(usuarioDao.deletar(num!!))
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
            post("/add") {
                val formParameters = call.receiveParameters()
                val id = formParameters["idPais"]!!.toInt()
                val nome = formParameters["nomePais"].toString()

                call.respond(paisDao.inserirUm(Pais(id,nome)))
            }
            delete("/delete/{id}"){
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(paisDao.deletar(num!!))
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
            post("/add") {
                val formParameters = call.receiveParameters()
                val id = formParameters["idAvaliacao"]!!.toInt()
                val idJogador = formParameters["idJogador"]!!.toInt()
                val idUsuario = formParameters["idUsuario"]!!.toInt()
                val avaliacao = formParameters["avaliacaoCompleta"].toString()

                call.respond(avaliacaoDao.inserirUm(Avaliacao(id,idJogador,idUsuario,avaliacao)))
            }
            delete("/delete/{id}"){
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(avaliacaoDao.deletar(num!!))
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
            post("/add") {
                val formParameters = call.receiveParameters()
                val id = formParameters["idEquipe"]!!.toInt()
                val nome = formParameters["nomeEquipe"].toString()
                val idLiga = formParameters["idLiga"]!!.toInt()

                call.respond(equipeDao.inserirUm(Equipe(id,nome,idLiga)))
            }
            delete("/delete/{id}"){
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(equipeDao.deletar(num!!))
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
            post("/add") {
                val formParameters = call.receiveParameters()
                val id = formParameters["idLiga"]!!.toInt()
                val nome = formParameters["nomeLiga"].toString()
                val idPais = formParameters["idPais"]!!.toInt()


                call.respond(ligaDao.inserirUm(Liga(id,nome,idPais)))
            }
            delete("/delete/{id}"){
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(ligaDao.deletar(num!!))
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
            post("/add") {
                val formParameters = call.receiveParameters()
                val id = formParameters["idRaridade"]!!.toInt()
                val tipo = formParameters["tipoRaridade"].toString()


                call.respond(raridadeDao.inserirUm(Raridade(id,tipo)))
            }
            delete("/delete/{id}"){
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(raridadeDao.deletar(num!!))
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

            post("/add") {
                val formParameters = call.receiveParameters()
                val id = formParameters["idusuario"]!!.toInt()
                val nome = formParameters["nomeUsuario"].toString()
                val email = formParameters["emailUsuario"].toString()
                val senha = formParameters["senhaUsuario"].toString()

               call.respond(usuarioDao.inserirUm(Usuario(id,nome,email,senha)))
            }
            delete("/delete/{id}"){
                val id: String? = call.parameters["id"]
                val num = id?.toInt()
                call.respond(usuarioDao.deletar(num!!))
            }




        }
    }
}