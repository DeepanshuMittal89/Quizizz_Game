package com.example.quizizz_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class PreDashboard1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_dashboard1)

        val studentButton = findViewById<ImageButton>(R.id.student)
        val officeButton = findViewById<ImageButton>(R.id.office_btn)
        studentButton.setOnClickListener{
            val intent = Intent(this,PreDashboard2::class.java)
            startActivity(intent)
        }
        officeButton.setOnClickListener {
            val intent = Intent(this,PreDashboard2_2::class.java)
            startActivity(intent)
        }
    }


}