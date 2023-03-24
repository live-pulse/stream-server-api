package site.hannahlog.stream.mist.stream.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import site.hannahlog.stream.util.code.ErrorCode
import site.hannahlog.stream.util.exception.BusinessException

data class SaveMistStreamResponse (
    private val streams: Streams? = null,
    private val log: List<List<Int>>? = null,
    private val config: Config? = null,
    private val authorize: Authorize,
    private val LTS: Int? = 0,
) {
    fun checkState() {
        if (authorize.status != "OK") throw BusinessException(ErrorCode.ERROR_AUTH_SAVE_STREAM)
        streams?.let { streams ->
            if (streams.incompleteList == 0) throw BusinessException(ErrorCode.ERROR_SAVE_STREAM)
        }
    }
}

data class Streams (
    private val streamName: Any? = null,

    @JsonProperty("incomplete list") val incompleteList: Int? = 0,
)

class Config (
    private val version: String? = null,

    @JsonProperty("trustedproxy")
    private val trustedProxy: List<String>? = null,

    private val time: Int? = 0,

    @JsonProperty("serverid")
    private val serverId: String? = null,
    private val protocols: List<Protocols>? = null,
    private val prometheus: String? = null,
    private val iid: String? = null,
    private val controller: Controller? = null,

    @JsonProperty("accesslog")
    private val accessLog: String? = null,
)

data class Protocols (
    private val online: String? = null,
    private val connector: String? = null,
)

data class Controller (
    @JsonProperty("interface")
    private val controllerInterface: String? = null,
    private val port: String? = null,
    private val username: String? = null,
)

data class Authorize (
    val status: String? = null,
)
