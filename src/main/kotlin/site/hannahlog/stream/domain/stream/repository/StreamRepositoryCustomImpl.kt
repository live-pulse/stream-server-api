package site.hannahlog.stream.domain.stream.repository

import jakarta.persistence.EntityManager
import site.hannahlog.stream.domain.stream.Stream

class StreamRepositoryCustomImpl(
    private val em: EntityManager
): StreamRepositoryCustom {

    override fun findByStreamKey(streamKey: String): Stream? {
        return em.createQuery(
            "select s from Stream s where s.streamKey = :streamKey",
            Stream::class.java
        )
            .setParameter("streamKey", streamKey)
            .singleResult

    }
}
