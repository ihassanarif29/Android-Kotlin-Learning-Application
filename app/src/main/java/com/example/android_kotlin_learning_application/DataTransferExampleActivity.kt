package com.example.android_kotlin_learning_application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DataTransferExampleActivity : AppCompatActivity() {

    companion object{
        const val KEY_FIRST_NAME = "FIRST_NAME"
        const val KEY_LAST_NAME = "LAST_NAME"
        const val KEY_EMAIL = "EMAIL"
        const val KEY_PHONE_NUMBER = "PHONE_NUMBER"
        const val KEY_CNIC = "CNIC"
        const val KEY_ADDRESS = "ADDRESS"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_transfer_example)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstNameEditText = findViewById<EditText>(R.id.editTextFirstName)
        val lastNameExitText = findViewById<EditText>(R.id.editTextLastName)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val phoneNumberEditText = findViewById<EditText>(R.id.editTextPhoneNumber)
        val cnicEditText = findViewById<EditText>(R.id.editTextCNIC)
        val addressEditText = findViewById<EditText>(R.id.editTextAddress)

        val sendDataButton = findViewById<Button>(R.id.buttonSendData)
        sendDataButton.setOnClickListener {
            val intent = Intent(this,DataReceivedExampleActivity::class.java)

            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameExitText.text.toString()
            val email = emailEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()
            val cnic = cnicEditText.text.toString()
            val address = addressEditText.text.toString()

            intent.putExtra(KEY_FIRST_NAME,firstName)
            intent.putExtra(KEY_LAST_NAME,lastName)
            intent.putExtra(KEY_EMAIL,email)
            intent.putExtra(KEY_PHONE_NUMBER,phoneNumber)
            intent.putExtra(KEY_CNIC,cnic)
            intent.putExtra(KEY_ADDRESS,address)
            startActivity(intent)
        }

    }
}