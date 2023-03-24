package site.hannahlog.stream.origin.stream.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import site.hannahlog.stream.origin.stream.dto.request.SaveStreamRequest
import site.hannahlog.stream.origin.stream.service.StreamService
import site.hannahlog.stream.util.ApiResponse.Success

@RestController
@RequestMapping("/stream")
class StreamController(
    private val streamService: StreamService
) {

    @PostMapping("")
    fun saveStream(@RequestBody request: SaveStreamRequest): Success<String> {
        val result = streamService.saveStream(request)
        return Success(result)
    }

}