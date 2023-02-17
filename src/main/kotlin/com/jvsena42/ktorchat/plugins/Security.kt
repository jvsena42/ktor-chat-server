package com.jvsena42.ktorchat.plugins

import com.jvsena42.ktorchat.session.ChatSession
import io.ktor.server.application.*
import io.ktor.server.sessions.*
import io.ktor.util.*

fun Application.configureSecurity() {
    install(Sessions) {
        cookie<ChatSession>("SESSION")
    }

    intercept(ApplicationCallPipeline.Plugins) {
        if (call.sessions.get<ChatSession>() == null) {
            //the parameter name shouldn't be userName instead of username?
            val userName = call.parameters["username"] ?: "Guest"
            call.sessions.set(ChatSession(userName, generateNonce()))
        }
    }
}
