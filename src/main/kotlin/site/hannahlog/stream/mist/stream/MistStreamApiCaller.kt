package site.hannahlog.stream.mist.stream

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import site.hannahlog.stream.mist.stream.dto.response.SaveMistStreamResponse
import site.hannahlog.stream.util.feign.FeignClientConfig

@FeignClient(
    name = "mist-stream-api",
    url = "\${mist.server.url}",
    configuration = [FeignClientConfig::class]
)
interface MistStreamApiCaller {

    @GetMapping("/api")
    fun saveStream(@RequestParam command: String): SaveMistStreamResponse

}