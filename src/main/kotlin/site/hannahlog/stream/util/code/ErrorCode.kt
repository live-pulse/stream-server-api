package site.hannahlog.stream.util.code

enum class ErrorCode(
    val code: String,
    val message: String
) {
    SERVER_ERROR("50000", "서버에서 문제가 발생했습니다. 나중에 다시 시도해주세요."),

    NOT_URI("40000", "잘못된 URI 요청입니다."),
    NOT_BODY("40001", "잘못된 Body 요청입니다."),
    NOT_JSON("40002", "잘못된 JSON 요청입니다."),

    ERROR_AUTH_SAVE_STREAM("40010", "스트림키 생성 권한이 없습니다. 나중에 다시 시도해주세요."),
    ERROR_SAVE_STREAM("40011", "스트림키 생성에 실패했습니다. 나중에 다시 시도해주세요."),


}