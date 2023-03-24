package site.hannahlog.stream.util.handler

import org.json.JSONException
import site.hannahlog.stream.util.ApiResponse.Error
import site.hannahlog.stream.util.code.ErrorCode
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import site.hannahlog.stream.util.exception.BusinessException

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleMemberException(e: BusinessException): Error<String> {
        return Error(e.errorCode)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun httpRequestMethodNotSupportedException(e: HttpRequestMethodNotSupportedException): Error<String> {
        return Error(ErrorCode.NOT_URI)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun httpMessageNotReadableException(e: HttpMessageNotReadableException): Error<String> {
        return Error(ErrorCode.NOT_BODY)
    }

    @ExceptionHandler(JSONException::class)
    fun jsonException(e: JSONException): Error<String> {
        return Error(ErrorCode.NOT_JSON)
    }


}