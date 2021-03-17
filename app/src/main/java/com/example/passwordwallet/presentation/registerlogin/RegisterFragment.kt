package com.example.passwordwallet.presentation.registerlogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.passwordwallet.R
import com.example.passwordwallet.data.auth.AuthenticationOperations
import com.example.passwordwallet.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterLoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        viewModel = (activity as RegisterLoginActivity).viewModel

        initButtons()
    }

    private fun initButtons() {
        binding.frameRegisterLayout.alreadyHaveAccountTextViewButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.frameRegisterLayout.registerButton.setOnClickListener {
            val login = binding.frameRegisterLayout.loginEditText.text.toString()
            val password = binding.frameRegisterLayout.passwordEditText.text.toString()
            val repeatedPassword = binding.frameRegisterLayout.repeatPasswordEditText.text.toString()
            val keepPasswordAsHash = binding.frameRegisterLayout.keepPasswordHashSwitch.isChecked

            registerUser(login, password, repeatedPassword, keepPasswordAsHash)
        }
    }

    private fun registerUser(
        login: String,
        password: String,
        repeatedPassword: String,
        keepPasswordAsHash: Boolean
    ) {
        if (login.isEmpty() || password.isEmpty() || repeatedPassword.isEmpty()) {
            Toast.makeText(activity, resources.getString(R.string.empty_data), Toast.LENGTH_SHORT)
                    .show()
            return
        }

        (activity as RegisterLoginActivity).showProgressBar()

        val salt = AuthenticationOperations.generateSalt(30)
        val securePassword = AuthenticationOperations.generateSecurePassword(password, salt)
        val repeatedSecurePassword = AuthenticationOperations.generateSecurePassword(repeatedPassword, salt)

        if (securePassword != repeatedSecurePassword) {
            Toast.makeText(activity, resources.getString(R.string.different_passwords), Toast.LENGTH_SHORT)
                .show()

            (activity as RegisterLoginActivity).hideProgressBar()
            return
        }

        viewModel.getUserByLogin(login).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                Toast.makeText(activity, resources.getString(R.string.login_exists), Toast.LENGTH_SHORT)
                        .show()
                (activity as RegisterLoginActivity).hideProgressBar()
            } else {
                viewModel.registerUser(login, securePassword, salt, keepPasswordAsHash)
                (activity as RegisterLoginActivity).hideProgressBar()
            }
        })
    }

}