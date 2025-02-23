package com.android.uplift

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class ProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backProfileBtn: ImageButton = findViewById(R.id.profile_back_button)
        val editProfileBtn: Button = findViewById(R.id.editProfileButton)

        // Get references to TextViews
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val usernameTextView: TextView = findViewById(R.id.usernameTextView)
        val addressTextView: TextView = findViewById(R.id.addressTextView)
        val contactTextView: TextView = findViewById(R.id.contactInfoTextView)
        val emailTextView: TextView = findViewById(R.id.emailTextView)

        backProfileBtn.setOnClickListener {
            val intent = Intent(this, LandingPage::class.java)
            startActivity(intent)
        }

        editProfileBtn.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java).apply {
                putExtra("name", nameTextView.text.toString())
                putExtra("username", usernameTextView.text.toString())
                putExtra("address", addressTextView.text.toString())
                putExtra("contact", contactTextView.text.toString())
                putExtra("email", emailTextView.text.toString())
            }
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Update TextViews with new data
            findViewById<TextView>(R.id.nameTextView).text = data.getStringExtra("name")
            findViewById<TextView>(R.id.usernameTextView).text = data.getStringExtra("username")
            findViewById<TextView>(R.id.addressTextView).text = data.getStringExtra("address")
            findViewById<TextView>(R.id.contactInfoTextView).text = data.getStringExtra("contact")
            findViewById<TextView>(R.id.emailTextView).text = data.getStringExtra("email")
        }
    }
}