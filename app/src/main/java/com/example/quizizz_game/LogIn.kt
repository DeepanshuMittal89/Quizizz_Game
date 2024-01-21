package com.example.quizizz_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.quizizz_game.databinding.ActivityLogInBinding
import com.example.quizizz_game.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginBtn.setOnClickListener {
            val emailId= binding.emailId.text.toString()
            val userPassword = binding.enteredPassword.text.toString()
            if(emailId.isNotEmpty() && userPassword.isNotEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(emailId,userPassword).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent = Intent (this,PreDashboard1::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this, "Feilds are Empty!!", Toast.LENGTH_SHORT).show()
            }
        }

        val LogIn: Button = findViewById(R.id.login_btn)
        val tv_Signup: TextView = findViewById(R.id.tv_SignUp)
        tv_Signup.setOnClickListener{
            val intent = Intent (this,SignUp::class.java)
            startActivity(intent)
        }
    }
}