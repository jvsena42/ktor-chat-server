package com.jvsena42.ktorchat.data

import com.jvsena42.ktorchat.data.model.Message

interface MessageDataSource {
    suspend fun getAllMessages(): List<Message>
    suspend fun insertMessage(message: Message)

}