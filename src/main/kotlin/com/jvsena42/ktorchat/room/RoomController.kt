package com.jvsena42.ktorchat.room

import com.jvsena42.ktorchat.data.MessageDataSource
import com.jvsena42.ktorchat.data.model.Message
import io.ktor.websocket.*
import java.util.concurrent.ConcurrentHashMap

class RoomController(
    private val messageDataSource: MessageDataSource
) {
    private val members = ConcurrentHashMap<String, Member>()

    fun onJoin(
        userName: String,
        sessionId: String,
        session: WebSocketSession,
    ) {
        if (members.containsKey(userName)) {
            throw MemberAlreadyExistsException()
        }

        members[userName] = Member(
            userName = userName,
            sessionId = sessionId,
            socket = session
        )
    }

    suspend fun sendMessage(senderUserName: String, message: String) {

        members.values.forEach { member ->
            val messageEntity = Message(
                text = message,
                userName = senderUserName,
                timeStamp = System.currentTimeMillis(),
            )
            messageDataSource.insertMessage(messageEntity)
        }

    }

}