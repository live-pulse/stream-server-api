package com.example.streamServerApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableFeignClients
@SpringBootApplication
class StreamServerApiApplication

fun main(args: Array<String>) {
    runApplication<StreamServerApiApplication>(*args)
}

@RestController
class PingController {

    @GetMapping("/ping")
    fun pingPong(): String = "pong!"

}
