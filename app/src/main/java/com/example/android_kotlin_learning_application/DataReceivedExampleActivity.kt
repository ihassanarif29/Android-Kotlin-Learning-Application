package com.example.android_kotlin_learning_application

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DataReceivedExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_received_example)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstName = intent.getStringExtra(DataTransferExampleActivity.KEY_FIRST_NAME)
        val lastName = intent.getStringExtra(DataTransferExampleActivity.KEY_LAST_NAME)
        val email = intent.getStringExtra(DataTransferExampleActivity.KEY_EMAIL)
        val phoneNumber = intent.getStringExtra(DataTransferExampleActivity.KEY_PHONE_NUMBER)
        val cnic = intent.getStringExtra(DataTransferExampleActivity.KEY_CNIC)
        val address = intent.getStringExtra(DataTransferExampleActivity.KEY_ADDRESS)


        val userDetailTextView = findViewById<TextView>(R.id.textViewUserDetail)
        userDetailTextView.text = "User $firstName $lastName having CNIC number $cnic is register on email $email as a new user if there is any miss information kindly contact on following number $phoneNumber or its home address $address"
    }
}