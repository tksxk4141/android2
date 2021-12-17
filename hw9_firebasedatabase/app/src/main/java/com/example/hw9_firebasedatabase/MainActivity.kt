package com.example.hw9_firebasedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw9_firebasedatabase.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Firebase.auth.currentUser == null) {
            startActivity(
                    Intent(this, LoginActivity::class.java)
            )
            finish()
        }

        binding.textUID.text = Firebase.auth.currentUser?.uid ?: "No User"

        binding.buttonSignout.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(
                    Intent(this, LoginActivity::class.java)
            )
            finish()
        }
    }
}