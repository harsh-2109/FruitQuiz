package com.example.fruitquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView = findViewById(R.id.tv_win_user)
        val tvScore:TextView = findViewById(R.id.tv_score)
        val btnFinish:Button = findViewById(R.id.btn_finish)

        val totalScore = intent.getIntExtra(Constant.CORRECT_ANSWERS,1)
        val totalQuestions = intent.getIntExtra(Constant.TOTAL_QUESTIONS,1)

        tvName.text = intent.getStringExtra(Constant.USER_NAME)
        tvScore.text = "Your Score $totalScore out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}