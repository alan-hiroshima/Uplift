package com.android.uplift

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class LoginActivity : Activity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            val intent = Intent(this, LandingPage::class.java)
            startActivity(intent)

        }

    }

}