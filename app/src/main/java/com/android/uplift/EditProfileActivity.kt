package com.android.uplift

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Get references to EditTexts
        val nameEditText: EditText = findViewById(R.id.editName)
        val usernameEditText: EditText = findViewById(R.id.editUsername)
        val addressEditText: EditText = findViewById(R.id.editAddress)
        val contactEditText: EditText = findViewById(R.id.editContact)
        val emailEditText: EditText = findViewById(R.id.editEmail)
        val saveButton: Button = findViewById(R.id.saveButton)

        // Set current values
        nameEditText.setText(intent.getStringExtra("name"))
        usernameEditText.setText(intent.getStringExtra("username"))
        addressEditText.setText(intent.getStringExtra("address"))
        contactEditText.setText(intent.getStringExtra("contact"))
        emailEditText.setText(intent.getStringExtra("email"))

        saveButton.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("name", nameEditText.text.toString())
                putExtra("username", usernameEditText.text.toString())
                putExtra("address", addressEditText.text.toString())
                putExtra("contact", contactEditText.text.toString())
                putExtra("email", emailEditText.text.toString())
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}