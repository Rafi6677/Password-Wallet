package com.example.passwordwallet.presentation.passwords.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.passwordwallet.R
import com.example.passwordwallet.databinding.FragmentPasswordDetailsBinding

class PasswordDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPasswordDetailsBinding

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
    }

}