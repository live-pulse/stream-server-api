package site.hannahlog.stream.mist.stream.dto.request

import org.json.JSONObject
import org.springframework.beans.factory.annotation.Value

data class SaveMistStreamRequest(
    val stream: String,
) {

    class Authorize {

        @Value("\${mist.server.username}")
        private val username: String? = null

        @Value("\${mist.server.password}")
        private val password: String? = null

        override fun toString(): String {
            return "{\"username\": \"$username\", \"password\": \"$password\"}"
        }

    }

    operator fun invoke(): String {
        return toString()
    }

    override fun toString(): String {
        val addStream = JSONObject("{\"$stream\":{\"source\":\"push://\"}}")
        val authorize = JSONObject(Authorize().toString())
        return JSONObject()
            .accumulate("authorize", authorize)
            .accumulate("addstream", addStream)
            .toString()
    }

}
