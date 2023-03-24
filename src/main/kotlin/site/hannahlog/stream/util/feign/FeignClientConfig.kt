package site.hannahlog.stream.util.feign

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FeignClientConfig {

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }

}