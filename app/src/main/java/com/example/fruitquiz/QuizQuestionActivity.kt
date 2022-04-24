package com.example.fruitquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionActivity : AppCompatActivity() {

    private lateinit var tvQuestion: TextView
    private lateinit var ivFruitImage: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgressCounts: TextView
    private lateinit var tvOptionOne: TextView
    private lateinit var tvOptionTwo: TextView
    private lateinit var tvOptionThree: TextView
    private lateinit var tvOptionFour: TextView
    private lateinit var btnSubmit: Button

    private var totalQuestionCounts = Constant.getQuestions().size
    private var currentQuestionCount = 1
    private var correctAnswersCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        //To assign all the widgets and values
        initial()

        // To load initial data
        loadData()

    }

    private fun loadData() {
        with(Constant.getQuestions()[currentQuestionCount]) {
            tvQuestion.text = getString(question)
            ivFruitImage.setImageResource(image)
            progressBar.max = totalQuestionCounts
            tvProgressCounts.text = "$currentQuestionCount/$totalQuestionCounts"
            tvOptionOne.text = option1
            tvOptionTwo.text = option2
            tvOptionThree.text = option3
            tvOptionFour.text = option4
            progressBar.progress = currentQuestionCount
        }
    }

    private fun initial() {
        tvQuestion = findViewById(R.id.tv_question)
        ivFruitImage = findViewById(R.id.iv_fruit_image)
        progressBar = findViewById(R.id.progress_bar)
        tvProgressCounts = findViewById(R.id.tv_progress_counts)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)
    }
}