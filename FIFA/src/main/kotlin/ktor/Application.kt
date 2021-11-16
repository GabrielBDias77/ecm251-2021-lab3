package ktor

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    embeddedServer(Netty, port = 80, host = "0.0.0.0") {

        install(ContentNegotiation){
            gson()
        }
        install(CORS){
            method(HttpMethod.Get)
            method(HttpMethod.Options)
            method(HttpMethod.Put)
            allowXHttpMethodOverride()
            allowHeaders { true }
            exposeHeader(HttpHeaders.AccessControlAllowOrigin)
            anyHost()
        }



        configureRouting()

    }.start(wait = true)
}