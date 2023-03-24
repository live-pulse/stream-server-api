package site.hannahlog.stream.domain.stream.repository

import site.hannahlog.stream.domain.stream.Stream

interface StreamRepositoryCustom {
    fun findByStreamKey(streamKey: String): Stream?
}