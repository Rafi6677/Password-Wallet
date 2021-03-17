package com.example.passwordwallet.data.auth

import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidKeySpecException
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec


object AuthenticationOperations {

    private val RANDOM: Random = SecureRandom()
    private const val ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    private const val ITERATIONS = 10000
    private const val KEY_LENGTH = 256

    private fun hashPassword(password: CharArray, salt: ByteArray): ByteArray {
        val spec = PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH)
        Arrays.fill(password, Character.MIN_VALUE)

        return try {
            val secretKeyFactory: SecretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            secretKeyFactory.generateSecret(spec).encoded
        } catch (e: NoSuchAlgorithmException) {
            throw AssertionError("Error while hashing a password: " + e.message, e)
        } catch (e: InvalidKeySpecException) {
            throw AssertionError("Error while hashing a password: " + e.message, e)
        } finally {
            spec.clearPassword()
        }
    }

    fun generateSalt(length: Int): String {
        val returnValue = StringBuilder(length)

        for (i in 0 until length) {
            returnValue.append(ALPHABET[RANDOM.nextInt(ALPHABET.length)])
        }

        return String(returnValue)
    }

    fun generateSecurePassword(password: String, salt: String): String {
        var returnValue: String? = null
        val securePassword = hashPassword(password.toCharArray(), salt.toByteArray())

        returnValue = Base64.getEncoder().encodeToString(securePassword)

        return returnValue
    }

    fun verifyUserPassword(
        providedPassword: String,
        securedPassword: String,
        salt: String
    ): Boolean {
        val user = generateSecurePassword(providedPassword, salt)
        return generateSecurePassword(providedPassword, salt)
            .equals(securedPassword, ignoreCase = true)
    }

}