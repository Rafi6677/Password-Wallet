package com.example.passwordwallet

import com.example.passwordwallet.data.auth.AESUtils
import com.example.passwordwallet.data.auth.UserAuth
import org.junit.Test

class AESUtilsTest {

    @Test
    fun decrypt_strToDecryptGiven_encryptionCorrect() {
        val salt = UserAuth.generateSalt(30)
        val strToEncrypt = "pass123"
        val encrypted = AESUtils.encrypt(strToEncrypt, salt)

        assert(AESUtils.decrypt(encrypted!!, salt).equals(strToEncrypt))
    }

}