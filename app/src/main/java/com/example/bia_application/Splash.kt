package com.example.bia_application

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Splash: AppCompatActivity()  {
    private var isTransitionDone = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_bia)

        val sharedPreferences = getPreferences(MODE_PRIVATE)
        isTransitionDone = sharedPreferences.getBoolean("isTransitionDone", false)

        if (!isTransitionDone) {
            Handler().postDelayed({
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            }, 2000)
        }
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("isTransitionDone", isTransitionDone).apply()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
