package za.ac.innosphere.disaster.util

import java.security.MessageDigest

object Security {
    fun hash(password: String): String {
        val md = MessageDigest.getInstance("SHA-256")
        val bytes = md.digest(password.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}
