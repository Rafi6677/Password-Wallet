package com.example.passwordwallet.presentation.registerlogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.passwordwallet.R
import com.example.passwordwallet.data.auth.UserAuth
import com.example.passwordwallet.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: RegisterLoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        viewModel = (activity as RegisterLoginActivity).viewModel

        initButtons()
    }

    private fun initButtons() {
        binding.frameLoginLayout.noAccountTextViewButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.frameLoginLayout.loginButton.setOnClickListener {
            val login = binding.frameLoginLayout.loginEditText.text.toString()
            val password = binding.frameLoginLayout.passwordEditText.text.toString()

            loginUser(login, password)
        }
    }

    private fun loginUser(login: String, givenPassword: String) {
        if (login.isEmpty() || givenPassword.isEmpty()) {
            Toast.makeText(activity, resources.getString(R.string.empty_data), Toast.LENGTH_SHORT)
                    .show()
            return
        }

        (activity as RegisterLoginActivity).showProgressBar()

        viewModel.getUserByLogin(login).observe(viewLifecycleOwner, Observer { user ->
            if (user == null) {
                Toast.makeText(activity, resources.getString(R.string.wrong_data), Toast.LENGTH_SHORT)
                        .show()
                (activity as RegisterLoginActivity).hideProgressBar()
            } else {
                val userPassword = user.passwordHash
                val salt = user.salt

                if (UserAuth.verifyUserPassword(givenPassword, userPassword, salt)) {
                    (activity as RegisterLoginActivity).hideProgressBar()
                    (activity as RegisterLoginActivity).logIntoApp(user)
                } else {
                    Toast.makeText(activity, resources.getString(R.string.wrong_data), Toast.LENGTH_SHORT)
                            .show()
                    (activity as RegisterLoginActivity).hideProgressBar()
                }

                (activity as RegisterLoginActivity).hideProgressBar()
            }
        })
    }

}