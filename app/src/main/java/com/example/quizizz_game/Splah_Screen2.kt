package com.example.quizizz_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splah_Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splah_screen2)

            Handler().postDelayed(
                {
                    startActivity(Intent(this,PreDashboard1::class.java))
                    finish()
                },5000
            )

    }
}