package com.example.passwordwallet.presentation.passwords.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordwallet.data.db.model.Password
import com.example.passwordwallet.databinding.ItemPasswordBinding

class PasswordsAdapter(private val clickListener: (Password) -> Unit) : RecyclerView.Adapter<PasswordsAdapter.PasswordsViewHolder>() {

    private val passwordsList = ArrayList<Password>()

    fun setPasswordsList(passwords: List<Password>?) {
        passwordsList.clear()

        if (passwords != null) {
            passwordsList.addAll(passwords)
        }
    }

    fun getPasswordsList(): List<Password> {
        return passwordsList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasswordsViewHolder {
        val binding = ItemPasswordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )

        return PasswordsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PasswordsViewHolder, position: Int) {
        val password = passwordsList[position]
        holder.bind(password)
    }

    override fun getItemCount(): Int {
        return passwordsList.size
    }

    inner class PasswordsViewHolder(
        private val binding: ItemPasswordBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(password: Password) {
            binding.accountNameTextView.text = password.accountName

            if (password.description.isNotEmpty()) {
                binding.descriptionTextView.visibility = View.VISIBLE
                binding.descriptionTextView.text = password.description
            } else {
                binding.descriptionTextView.visibility = View.GONE
            }

            binding.passwordCardView.setOnClickListener {
                clickListener(password)
            }
        }

    }

}