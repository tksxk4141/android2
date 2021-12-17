package com.example.hw10_firebasemessaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hw10_firebasemessaging.databinding.ActivityMainBinding
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            binding.textFCMToken.text = if (it.isSuccessful) it.result else "Token Error!"


            // write to logcat
            Log.d(MyFirebaseMessagingService.TAG, "FCM token: ${binding.textFCMToken.text}")
        }

        val msg: String = intent?.getStringExtra("message")?:""
        binding.textMessage.setText(msg)

    }
}