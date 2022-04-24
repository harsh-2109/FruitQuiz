package com.example.fruitquiz

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatDrawableManager

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvQuestion: TextView
    private lateinit var ivFruitImage: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgressCounts: TextView
    private lateinit var tvOptionOne: TextView
    private lateinit var tvOptionTwo: TextView
    private lateinit var tvOptionThree: TextView
    private lateinit var tvOptionFour: TextView
    private lateinit var btnSubmit: Button

    private var mUsername: String? = null

    private var totalQuestionCounts = Constant.getQuestions().size
    private var mSelectedOption = 0
    private var currentQuestionCount = 1
    private var correctAnswersCount = 0
    private val questions = Constant.getQuestions()
    private lateinit var options: ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUsername = intent.getStringExtra(Constant.USER_NAME)

        //To assign all the widgets and values
        initial()

        // To load initial data
        loadData()

        clickEvent()

    }

    private fun clickEvent() {
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
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

    private fun loadData() {
        defaultOptionViewStyle()
        with(questions[currentQuestionCount - 1]) {
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
        btnSubmit.text =
            if (currentQuestionCount == questions.size)
                "Finish"
            else
                "Submit"
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> selectedOptionItem(tvOptionOne, 1)
            R.id.tv_option_two -> selectedOptionItem(tvOptionTwo, 2)
            R.id.tv_option_three -> selectedOptionItem(tvOptionThree, 3)
            R.id.tv_option_four -> selectedOptionItem(tvOptionFour, 4)
            R.id.btn_submit -> {
                if (mSelectedOption == 0) {
                    currentQuestionCount++
                    when {
                        currentQuestionCount <= questions.size -> loadData()
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constant.USER_NAME, mUsername)
                            intent.putExtra(Constant.CORRECT_ANSWERS, correctAnswersCount)
                            intent.putExtra(Constant.TOTAL_QUESTIONS, questions.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    if (mSelectedOption != questions[currentQuestionCount - 1].correctOption)
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                    else
                        correctAnswersCount++
                    answerView(
                        questions[currentQuestionCount - 1].correctOption,
                        R.drawable.correct_option_border_bg
                    )
                    btnSubmit.text =
                        if (currentQuestionCount == questions.size)
                            "FINISH"
                        else
                            "Go To Next Question"

                    mSelectedOption = 0
                }
            }
        }
    }

    private fun answerView(selectedOption: Int, drawable: Int) {
        when (selectedOption) {
            1 -> {
                options[selectedOption - 1].background =
                    AppCompatResources.getDrawable(this, drawable)
            }
            2 -> {
                options[selectedOption - 1].background =
                    AppCompatResources.getDrawable(this, drawable)
            }
            3 -> {
                options[selectedOption - 1].background =
                    AppCompatResources.getDrawable(this, drawable)
            }
            4 -> {
                options[selectedOption - 1].background =
                    AppCompatResources.getDrawable(this, drawable)
            }
        }
    }

    private fun selectedOptionItem(view: TextView, selectedOption: Int) {
        mSelectedOption = selectedOption

        defaultOptionViewStyle()

        view.background = AppCompatResources.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
        view.setTypeface(view.typeface, Typeface.BOLD)
    }

    private fun defaultOptionViewStyle() {
        options = ArrayList<TextView>()

        options.add(tvOptionOne)
        options.add(tvOptionTwo)
        options.add(tvOptionThree)
        options.add(tvOptionFour)

        for (option in options) {
            option.background = AppCompatResources.getDrawable(
                this, R.drawable.default_option_border_bg
            )
            option.typeface = Typeface.DEFAULT
        }
    }
}