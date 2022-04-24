package com.example.fruitquiz

object Constant {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"

    fun getQuestions(): ArrayList<Fruits> {

        val questionList = ArrayList<Fruits>()

        questionList.add(
            Fruits(
                1,
                R.drawable.stawbary,
                R.string.question,
                "Strawberry", "Sushi", "Swish", "Stawbarry",
                1
            )
        )
        questionList.add(
            Fruits(
                2,
                R.drawable.pineapple,
                R.string.question,
                "Strawberry", "Pineapple", "Swish", "Stawbarry",
                2
            )
        )
        questionList.add(
            Fruits(
                3,
                R.drawable.banana,
                R.string.question,
                "Banana", "Sushi", "Swish", "Stawbarry",
                1
            )
        )
        questionList.add(
            Fruits(
                4,
                R.drawable.kiwi,
                R.string.question,
                "Strawberry", "Sushi", "KiWi", "Stawbarry",
                3
            )
        )
        questionList.add(
            Fruits(
                5,
                R.drawable.melon,
                R.string.question,
                "Strawberry", "Sushi", "Swish", "Watermelon",
                4
            )
        )
        questionList.add(
            Fruits(
                6,
                R.drawable.apple,
                R.string.question,
                "Strawberry", "Apple", "Swish", "Stawbarry",
                2
            )
        )
        questionList.add(
            Fruits(
                7,
                R.drawable.pomo,
                R.string.question,
                "Pomegranate", "Sushi", "Swish", "Stawbarry",
                1
            )
        )

        return questionList
    }
}