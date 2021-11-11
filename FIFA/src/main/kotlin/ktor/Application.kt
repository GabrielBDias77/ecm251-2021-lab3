package ktor

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import javax.naming.AuthenticationException


fun main() {
    embeddedServer(Netty, port = 80, host = "0.0.0.0") {

        install(ContentNegotiation){
            gson()
        }
        install(CORS){
            method(HttpMethod.Options)
            anyHost()
        }


        configureRouting()

    }.start(wait = true)
}