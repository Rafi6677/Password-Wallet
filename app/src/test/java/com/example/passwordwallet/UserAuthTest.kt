package com.example.passwordwallet

import com.example.passwordwallet.data.auth.UserAuth
import org.junit.Test

class UserAuthTest {

    @Test
    fun generateSecureUserPassword_saltGiven_returnEncryptedIsNotEmpty() {
        val saltLength = 30
        val salt = UserAuth.generateSalt(saltLength)
        val password = "pass123"
        val securePassword = UserAuth.generateSecureUserPassword(password, salt)

        assert(UserAuth.generateSecureUserPassword(password, salt).isNotEmpty())
    }

    @Test
    fun verifyUserPassword_passwordGiven_isCorrect() {
        val saltLength = 30
        val salt = UserAuth.generateSalt(saltLength)
        val password = "pass123"
        val securePassword = UserAuth.generateSecureUserPassword(password, salt)

        assert(UserAuth.verifyUserPassword(password, securePassword, salt))
    }

    @Test
    fun verifyUserPassword_passwordGiven_isNotCorrect() {
        val saltLength = 30
        val salt = UserAuth.generateSalt(saltLength)
        val password1 = "pass123"
        val password2 = "Pass123"
        val securePassword1 = UserAuth.generateSecureUserPassword(password1, salt)

        assert(!UserAuth.verifyUserPassword(password2, securePassword1, salt))
    }

}