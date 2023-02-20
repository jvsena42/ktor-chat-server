package com.jvsena42.ktorchat

import com.jvsena42.ktorchat.data.di.mainModule
import com.jvsena42.ktorchat.plugins.*
import io.ktor.server.application.*
import org.koin.dsl.koinApplication

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    koinApplication{
        modules(mainModule)

    }
    configureSockets()
    configureSerialization()
    configureMonitoring()
    configureSecurity()
    configureRouting()
}
