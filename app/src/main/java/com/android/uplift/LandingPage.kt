package com.android.uplift

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class LandingPage : Activity() {
    companion object {
        private var isFirstVisit = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val comfyHomeText: TextView = findViewById(R.id.comfy_home_text)
        val drawableHome: ImageView = findViewById(R.id.drawable_home)
        val profileButton: ImageButton = findViewById(R.id.btn_profile)
        val settingsButton: ImageButton = findViewById(R.id.btn_settings)
        val developersButton: ImageButton = findViewById(R.id.btn_developer)


        if (isFirstVisit) {
            comfyHomeText.visibility = View.INVISIBLE
            drawableHome.visibility = View.INVISIBLE

            val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)

            comfyHomeText.postDelayed({
                comfyHomeText.startAnimation(fadeInAnimation)
                comfyHomeText.visibility = View.VISIBLE
            }, 1000)

            drawableHome.postDelayed({
                drawableHome.startAnimation(fadeInAnimation)
                drawableHome.visibility = View.VISIBLE
            }, 1000)

            isFirstVisit = false
        } else {
            comfyHomeText.visibility = View.VISIBLE
            drawableHome.visibility = View.VISIBLE
        }

        // Set click listeners with Intents
        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

//        developersButton.setOnClickListener {
//            val intent = Intent(this, DeveloperActivity::class.java)
//            startActivity(intent)
//        }
    }
}