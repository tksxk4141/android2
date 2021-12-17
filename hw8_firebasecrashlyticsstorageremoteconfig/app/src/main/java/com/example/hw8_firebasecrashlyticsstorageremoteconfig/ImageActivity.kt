package com.example.hw8_firebasecrashlyticsstorageremoteconfig

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.hw8_firebasecrashlyticsstorageremoteconfig.databinding.ActivityImageBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

class ImageActivity : AppCompatActivity() {
    lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Firebase.auth.currentUser ?: finish()  // if not authenticated, finish this activity

        storage = Firebase.storage
        val storageRef = storage.reference

        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 1 // For test purpose only, 3600 seconds for production
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)

        var Season = remoteConfig.getString("season")
        var imageRef = storageRef.child(Season+".jpg")
        displayImageRef(imageRef, binding.imageView)

        binding.refresh.setOnClickListener {
            remoteConfig.fetchAndActivate()
                .addOnCompleteListener(this) {
                    Season = remoteConfig.getString("season")
                    imageRef = storageRef.child(Season+".jpg")
                    displayImageRef(imageRef, binding.imageView)
                }
        }
    }

    private fun displayImageRef(imageRef: StorageReference?, view: ImageView) {
        imageRef?.getBytes(Long.MAX_VALUE)?.addOnSuccessListener {
            val bmp = BitmapFactory.decodeByteArray(it, 0, it.size)
            view.setImageBitmap(bmp)
        }?.addOnFailureListener {
            // Failed to download the image
        }
    }
}