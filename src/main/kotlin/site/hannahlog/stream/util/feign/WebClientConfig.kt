package site.hannahlog.stream.util.feign

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.Connection
import reactor.netty.http.client.HttpClient
import java.util.concurrent.TimeUnit

@Configuration
class WebClientConfig {

    var exchangeStrategies = ExchangeStrategies.builder().codecs { configurer: ClientCodecConfigurer ->
        configurer.defaultCodecs().maxInMemorySize(20 * 1024 * 1024)
    }.build()

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .exchangeStrategies(exchangeStrategies)
            .clientConnector(ReactorClientHttpConnector(
                HttpClient.create()
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 20000)
                    .doOnConnected { conn: Connection ->
                        conn.addHandler(
                            ReadTimeoutHandler(20000, TimeUnit.MILLISECONDS)
                        )
                    }
            )).build()
    }
}