package com.android.uplift

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton


class ProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backProfileBtn : ImageButton = findViewById(R.id.profile_back_button)

        backProfileBtn.setOnClickListener {
            val intent = Intent(this, LandingPage::class.java)
            startActivity(intent)
        }


    }


    
}