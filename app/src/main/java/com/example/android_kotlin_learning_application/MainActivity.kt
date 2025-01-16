 package com.example.android_kotlin_learning_application

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //get button from view and show toast message on button click
        val showToastButton = findViewById<Button>(R.id.buttonToast)
        showToastButton.setOnClickListener {
            Toast.makeText(this,"Hi this is toast from kotlin application",Toast.LENGTH_SHORT).show()
        }

        //get button from view and implement implicit intent on button click
        val showImplicitIntentButton = findViewById<Button>(R.id.buttonImplicitActivity)
        showImplicitIntentButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com")
            startActivity(intent)
        }

        //get button from view and implement explicit intent on button click
        val showExplicitIntentButton = findViewById<Button>(R.id.buttonExplicitActivity)
        showExplicitIntentButton.setOnClickListener {
            val intent = Intent(this,NewActivity::class.java)
            startActivity(intent)
        }
    }
}