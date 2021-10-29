package API.Fifa

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import API.Fifa.plugins.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun main() {
    embeddedServer(Netty, port = 80, host = "0.0.0.0") {
        routing {
            get("/"){
                call.respondText("OLa")
            }
        }
    }.start(wait = true)
}
