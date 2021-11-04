package ktor

import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    embeddedServer(Netty, port = 80, host = "0.0.0.0") {

//        install(StatusPages) {
//            exception<Throwable> { e ->
//                call.respondText(e.localizedMessage, ContentType.Text.Plain, HttpStatusCode.InternalServerError)
//            }
//        }

        configureRouting()

    }.start(wait = true)
}