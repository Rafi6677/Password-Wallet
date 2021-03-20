package com.example.passwordwallet.presentation.passwords.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.passwordwallet.BuildConfig
import com.example.passwordwallet.R
import com.example.passwordwallet.data.auth.AESUtils
import com.example.passwordwallet.data.auth.UserAuth
import com.example.passwordwallet.databinding.FragmentPasswordDetailsBinding
import com.example.passwordwallet.presentation.passwords.PasswordsActivity
import com.example.passwordwallet.presentation.passwords.PasswordsViewModel

class PasswordDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPasswordDetailsBinding
    private lateinit var viewModel: PasswordsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPasswordDetailsBinding.bind(view)
        viewModel = (activity as PasswordsActivity).viewModel

        initButtons()
    }

    private fun initButtons() {
        binding.savePasswordButton.setOnClickListener {
            val accountName = binding.accountNameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()

            savePassword(accountName, password, description)
        }
    }

    private fun savePassword(accountName: String, password: String, description: String) {
        if (accountName.isEmpty() || password.isEmpty()) {
            Toast.makeText(activity, resources.getString(R.string.empty_data), Toast.LENGTH_SHORT)
                    .show()
            return
        }

        val user = (activity as PasswordsActivity).user
        val userId = user.id
        val key = AESUtils.encrypt(user.passwordHash, BuildConfig.PEPPER)

        var hashedPassword: String? = null

        if (key != null) {
            hashedPassword = AESUtils.encrypt(password, key)
        }

        if (key == null || hashedPassword == null) {
            Toast.makeText(activity, resources.getString(R.string.error_encrypting), Toast.LENGTH_SHORT)
                    .show()
            return
        }

        viewModel.savePassword(hashedPassword, userId, accountName, description)
        (activity as PasswordsActivity).onBackPressed()
    }

}