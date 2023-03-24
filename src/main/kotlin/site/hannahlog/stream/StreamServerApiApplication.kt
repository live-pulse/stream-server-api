package site.hannahlog.stream

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableFeignClients
@EnableJpaRepositories
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
