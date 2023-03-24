package site.hannahlog.stream.util.exception

import site.hannahlog.stream.util.code.ErrorCode

class BusinessException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)