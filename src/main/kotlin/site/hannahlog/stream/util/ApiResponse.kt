package site.hannahlog.stream.util

import site.hannahlog.stream.util.code.ErrorCode
import site.hannahlog.stream.util.code.SuccessCode

sealed class ApiResponse<T>(
    open val data: T? = null,
    val code: String? = null,
    val message: String? = null
) {

    data class Success<T>(override val data: T? = null, val success: SuccessCode = SuccessCode.SUCCESS) : ApiResponse<T>(data = data, code = success.code, message = success.message) {
        constructor(success: SuccessCode) : this(null, success)
    }

    data class Error<T>(val error: ErrorCode) : ApiResponse<T>(code = error.code, message = error.message)
}