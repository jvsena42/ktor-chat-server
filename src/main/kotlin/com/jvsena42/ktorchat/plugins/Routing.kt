package com.jvsena42.ktorchat.plugins

import com.jvsena42.ktorchat.room.RoomController
import com.jvsena42.ktorchat.routes.chatSocket
import com.jvsena42.ktorchat.routes.getAllMessages
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    val roomController: RoomController by inject<RoomController>()

    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
