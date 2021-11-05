package ktor

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.serialization.*


fun main() {
    embeddedServer(Netty, port = 80, host = "0.0.0.0") {

        install(ContentNegotiation){
            json()
        }

//        install(StatusPages) {
//            exception<Throwable> { e ->
//                call.respondText(e.localizedMessage, ContentType.Text.Plain, HttpStatusCode.InternalServerError)
//            }
//        }

        configureRouting()

    }.start(wait = true)
}