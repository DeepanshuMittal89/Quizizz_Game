package com.example.quizizz_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import java.util.jar.Attributes.Name


class MainActivity : AppCompatActivity() {
    var Name_of_splash:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Name_of_splash= findViewById(R.id.name)

        val Animation = AnimationUtils.loadAnimation(this,R.anim.scale)
        Name_of_splash?.startAnimation(Animation)
        android.os.Handler(Looper.getMainLooper())
            .postDelayed(
                {
                    startActivity(Intent(this,Splah_Screen2::class.java))
                    finish()
                },3000
            )
    }
}