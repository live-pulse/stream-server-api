package site.hannahlog.stream.origin.stream.helper

import org.springframework.stereotype.Component
import site.hannahlog.stream.domain.broadcast.repository.BroadcastRepository
import site.hannahlog.stream.domain.stream.repository.StreamRepository
import site.hannahlog.stream.mist.stream.MistStreamApiCaller
import site.hannahlog.stream.mist.stream.dto.request.SaveMistStreamRequest
import site.hannahlog.stream.util.encrypt.StreamKeyMaker

@Component
class StreamHelper(
    private val streamRepository: StreamRepository,
    private val broadcastRepository: BroadcastRepository,
    private val mistStreamApiCaller: MistStreamApiCaller,
) {

    fun saveMistStreamKey(broadcastId: Long): String {
        val streamKey = StreamKeyMaker.getStreamKey(broadcastId)
        val saveStreamKeyRequest = SaveMistStreamRequest(streamKey)
        val saveStreamKeyResponse = mistStreamApiCaller.saveStream(saveStreamKeyRequest())
        saveStreamKeyResponse.checkState()
        return streamKey
    }

}