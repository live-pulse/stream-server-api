package site.hannahlog.stream.util.encrypt

import java.security.MessageDigest

class StreamKeyMaker {

    companion object{

        fun getStreamKey(broadcastId: Long): String {
            val digest = MessageDigest.getInstance("MD5")
            digest.update(broadcastId.toByteArray())
            return bytesToHex(digest.digest())
        }

        private fun bytesToHex(bytes: ByteArray): String {
            val builder = StringBuilder()
            for (b in bytes) builder.append(String.format("%02x", b))
            return builder.toString()
        }

        private fun Long.toByteArray(): ByteArray {
            return this
                .toString()
                .toByteArray()
        }
    }

}