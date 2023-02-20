package com.jvsena42.ktorchat.data.di

import com.jvsena42.ktorchat.data.MessageDataSource
import com.jvsena42.ktorchat.data.MessageDataSourceImpl
import com.jvsena42.ktorchat.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient().coroutine.getDatabase("message_db")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}