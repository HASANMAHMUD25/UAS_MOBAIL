package com.arya.movie.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.arya.movie.MainActivity
import com.arya.movie.R
import com.arya.movie.data.local.UserPreferences

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(
            {
                val database = UserPreferences(this)
                val user = database.getUser().username

                if (user != null) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }, 3000
        )
    }
}