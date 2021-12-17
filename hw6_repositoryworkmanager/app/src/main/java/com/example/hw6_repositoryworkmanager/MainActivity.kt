package com.example.hw6_repositoryworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import java.lang.StringBuilder
import java.util.concurrent.TimeUnit

// The repository pattern is a strategy for abstracting data access.
// ViewModel delegates the data-fetching process to the repository.

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel : MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this, MyViewModel.Factory(this)).get(MyViewModel::class.java)

        myViewModel.contributors.observe(this) { contributors ->
            val response = StringBuilder().apply {
                contributors.forEach {
                    append(it.login)
                    append(" - ")
                    append(it.contributions)
                    append("\n")
                }
            }.toString()
            findViewById<TextView>(R.id.textResponse).text = response
        }

    }
}