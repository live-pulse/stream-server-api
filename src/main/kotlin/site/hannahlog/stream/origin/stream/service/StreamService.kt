package site.hannahlog.stream.origin.stream.service

import org.springframework.stereotype.Service
import site.hannahlog.stream.domain.stream.Stream
import site.hannahlog.stream.domain.stream.repository.StreamRepository
import site.hannahlog.stream.mist.stream.MistStreamApiCaller
import site.hannahlog.stream.origin.stream.dto.request.SaveStreamRequest
import site.hannahlog.stream.origin.stream.helper.StreamHelper

@Service
class StreamService(
    private val streamHelper: StreamHelper,
    private val streamRepository: StreamRepository,
    private val mistStreamApiCaller: MistStreamApiCaller,
) {

    fun saveStream(request: SaveStreamRequest): String {
        val streamKey = streamHelper.saveMistStreamKey(request.broadcastId)
        val entityStream = Stream(streamKey, request.broadcastId)
        val saveEntityStream = streamRepository.save(entityStream)
        return saveEntityStream.toString()
    }

}