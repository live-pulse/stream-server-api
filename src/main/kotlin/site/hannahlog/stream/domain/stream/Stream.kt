package site.hannahlog.stream.domain.stream

import com.hannah.education.util.domain.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import site.hannahlog.stream.domain.broadcast.Broadcast

@Entity
data class Stream(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    private val streamKey: String,

    private val rtmpUrl: String,

    private val hlsUrl: String,

    @ManyToOne
    private val broadcast: Broadcast,

): BaseEntity() {

    constructor(streamKey: String, broadcastId: Long) : this(
        streamKey = streamKey,
        rtmpUrl = "rtmp://stream.hannah-log.site/live/$streamKey",
        hlsUrl = "http://stream.hannah-log.site:8080/hls/$streamKey.m3u8",
        broadcast = Broadcast(broadcastId),
    )

}
