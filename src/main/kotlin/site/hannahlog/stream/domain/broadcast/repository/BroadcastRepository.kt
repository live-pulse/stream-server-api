package site.hannahlog.stream.domain.broadcast.repository

import org.springframework.data.jpa.repository.JpaRepository
import site.hannahlog.stream.domain.broadcast.Broadcast

interface BroadcastRepository: JpaRepository<Broadcast, Long>