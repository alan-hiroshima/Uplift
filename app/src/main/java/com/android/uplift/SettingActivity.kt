package com.android.uplift

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout

class SettingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        val backSettingBtn : ImageButton = findViewById(R.id.settingsBackButton)
        backSettingBtn.setOnClickListener {
            val intent = Intent(this, LandingPage::class.java)
            startActivity(intent)
        }

        val logoutSettingBtn : Button = findViewById(R.id.logout_button)
        logoutSettingBtn.setOnClickListener {
            val intent = Intent(this, LogoutActivity::class.java)
            startActivity(intent)
        }


        val developersBtn : ConstraintLayout = findViewById(R.id.aboutSection)
        developersBtn.setOnClickListener {
            val intent = Intent(this, DevelopersPage::class.java)
            startActivity(intent)
        }

    }
}