package com.example.fruitquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.et_username)
        btnStart = findViewById(R.id.btn_start)

        btnStart.setOnClickListener {
            if (etUsername.text.isNotEmpty()) {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constant.USER_NAME, etUsername.text)
                startActivity(intent)
                finish()
            } else
                Toast.makeText(this, "Please Enter your name", Toast.LENGTH_SHORT).show()
        }
    }
}