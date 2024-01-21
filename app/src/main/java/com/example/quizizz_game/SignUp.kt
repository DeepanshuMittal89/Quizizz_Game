package com.example.quizizz_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.quizizz_game.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signUpBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.etvPassword.text.toString()
            val confirm_password = binding.etvConfirmPassword.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty() && confirm_password.isNotEmpty()){
                if(password == confirm_password){
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent = Intent (this,PreDashboard1::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Feilds are Empty!!", Toast.LENGTH_SHORT).show()
            }
        }

        val SignUp: Button= findViewById(R.id.sign_up_btn)
        val tv_logIn:TextView= findViewById(R.id.tv_login)



        binding.tvLogin.setOnClickListener{
            val intent = Intent (this,LogIn::class.java)
            startActivity(intent)
        }

    }
}