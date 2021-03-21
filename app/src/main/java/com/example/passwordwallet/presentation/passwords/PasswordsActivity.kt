package com.example.passwordwallet.presentation.passwords

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.passwordwallet.R
import com.example.passwordwallet.data.db.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PasswordsActivity : AppCompatActivity() {

    lateinit var user: User
    val viewModel by viewModels<PasswordsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passwords)

        getUserLogin()
    }

    private fun getUserLogin() {
        val bundle = intent.extras!!
        user = bundle.getSerializable("user") as User
        supportActionBar!!.title = "User: ${user.login}"
    }

    private fun showExitDialog() {
        AlertDialog.Builder(this).apply {
            setTitle(resources.getString(R.string.exit))
            setMessage(resources.getString(R.string.exit_question))
            setPositiveButton(resources.getString(R.string.yes)) { _, _ ->
                this@PasswordsActivity.finishAffinity()
            }
            setNegativeButton(resources.getString(R.string.no)) { _, _ -> }
        }.show()
    }

    fun closeKeyboard() {
        val view: View? = this.currentFocus

        if (view != null) {
            val manager: InputMethodManager = getSystemService(
                    Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}