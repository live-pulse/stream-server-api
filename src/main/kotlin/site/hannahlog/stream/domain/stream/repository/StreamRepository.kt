package site.hannahlog.stream.domain.stream.repository

import org.springframework.data.jpa.repository.JpaRepository
import site.hannahlog.stream.domain.stream.Stream

interface StreamRepository: JpaRepository<Stream, Long>, StreamRepositoryCustom