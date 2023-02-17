package com.jvsena42.ktorchat.plugins

import com.jvsena42.ktorchat.session.ChatSession
import io.ktor.server.application.*
import io.ktor.server.sessions.*

fun Application.configureSecurity() {
    install(Sessions) {
        cookie<ChatSession>("SESSION")
    }
}
