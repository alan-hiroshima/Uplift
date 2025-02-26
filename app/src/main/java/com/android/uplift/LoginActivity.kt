package com.android.uplift

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_login)
        //setContentView(R.layout.activity_developer_page)


        val loginButton: Button = findViewById(R.id.login_button)
        val editTextUsername: EditText = findViewById(R.id.editTextUser)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)

        loginButton.setOnClickListener {

            val username = editTextUsername.text.toString().trim()
            val password = editTextPassword.text.toString().trim()


            when {
                username.isEmpty() || password.isEmpty() -> {
                    showError("Username and Password must not be empty")
                    return@setOnClickListener
                }
                username.length < 4 -> {
                    showError("Username must be at least 4 characters long")
                    editTextUsername.requestFocus()
                    return@setOnClickListener
                }
                password.length < 4 -> {
                    showError("Password must be at least 4 characters long")
                    editTextPassword.requestFocus()
                    return@setOnClickListener
                }
                !username.matches(Regex("^[a-zA-Z0-9]+$")) -> {
                    showError("Username can only contain letters and numbers")
                    editTextUsername.requestFocus()
                    return@setOnClickListener
                }
                !isPasswordValid(password) -> {
                    showError("Password must contain at least one number and one letter")
                    editTextPassword.requestFocus()
                    return@setOnClickListener
                }
                username.equals("csit", ignoreCase = true) &&
                        password == "A1234" -> {
                    handleSuccessfulLogin()
                }
                else -> {
                    showError("Invalid credentials")
                }
            }
        }
    }


    private fun isPasswordValid(password: String): Boolean {
        val hasNumber = password.any { it.isDigit() }
        val hasLetter = password.any { it.isLetter() }
        return hasNumber && hasLetter
    }


    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    private fun handleSuccessfulLogin() {
        Toast.makeText(this, "Successful login", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LandingPage::class.java).apply {

            putExtra("USERNAME", findViewById<EditText>(R.id.editTextUser).text.toString())
        }
        startActivity(intent)
        finish()
    }
}