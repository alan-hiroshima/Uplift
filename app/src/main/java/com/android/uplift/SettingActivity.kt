package com.android.uplift

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton

class SettingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        val backSettingBtn : ImageButton = findViewById(R.id.settingsBackButton)

        backSettingBtn.setOnClickListener {
            val intent = Intent(this, LandingPage::class.java)
            startActivity(intent)
        }
    }
}