package com.example.passwordwallet.presentation.passwords.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.passwordwallet.R
import com.example.passwordwallet.databinding.FragmentPasswordsListBinding

class PasswordsListFragment : Fragment() {

    private lateinit var binding: FragmentPasswordsListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_passwords_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPasswordsListBinding.bind(view)

        initButtons()
    }

    private fun initButtons() {
        binding.addPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_passwordsListFragment_to_passwordDetailsFragment)
        }
    }

}