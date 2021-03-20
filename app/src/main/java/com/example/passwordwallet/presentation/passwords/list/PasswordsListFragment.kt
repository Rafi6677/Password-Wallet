package com.example.passwordwallet.presentation.passwords.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passwordwallet.R
import com.example.passwordwallet.data.db.model.Password
import com.example.passwordwallet.databinding.FragmentPasswordsListBinding
import com.example.passwordwallet.presentation.passwords.PasswordsActivity
import com.example.passwordwallet.presentation.passwords.PasswordsViewModel

class PasswordsListFragment : Fragment() {

    private lateinit var binding: FragmentPasswordsListBinding
    private lateinit var passwordsAdapter: PasswordsAdapter
    private lateinit var viewModel: PasswordsViewModel

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
        viewModel = (activity as PasswordsActivity).viewModel

        initRecyclerView()
        initButtons()
    }

    override fun onResume() {
        super.onResume()
        passwordsAdapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        val divider = DividerItemDecoration(
            binding.passwordsRecyclerView.context,
            LinearLayoutManager.VERTICAL
        )

        passwordsAdapter = PasswordsAdapter { password ->
            onPasswordClickListener(password)
        }

        val user = (activity as PasswordsActivity).user
        viewModel.getPasswordsList(user)
        viewModel.passwordsList.observe(viewLifecycleOwner, Observer { passwordsList ->
            passwordsAdapter.setPasswordsList(passwordsList)
            manageNoPasswordInfoVisibility()
        })

        binding.passwordsRecyclerView.apply {
            adapter = passwordsAdapter
            layoutManager = LinearLayoutManager(this@PasswordsListFragment.context)
            addItemDecoration(divider)
        }
    }

    private fun initButtons() {
        binding.addPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_passwordsListFragment_to_passwordDetailsFragment)
        }
    }

    private fun onPasswordClickListener(password: Password) {

    }

    private fun manageNoPasswordInfoVisibility() {
        if (passwordsAdapter.getPasswordsList().isNotEmpty()) {
            binding.noPasswordsStoredTextView.visibility = View.INVISIBLE
        } else {
            binding.noPasswordsStoredTextView.visibility = View.VISIBLE
        }
    }

}