package com.example.quizapp

object Constants{
    val USERNAME="user_name"
    val CORRECTANSWERS="correct_answers"
    val TOTALANSWERS="total_answers"
    fun getQuestions():ArrayList<Question>
    {
        val questionList=ArrayList<Question>()
        val qu1=Question(1,"What does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Uruguay",
            "United Arab Emirates","Turkey",1)
        questionList.add(qu1)
        val qu2=Question(2,"What does this flag belong to?",
        R.drawable.ic_flag_of_australia,
            "Sweden","Sudan",
            "Australia","Tunisia",3)
        questionList.add(qu2)
        val qu3=Question(3,"What does this flag belong to?",
        R.drawable.ic_flag_of_brazil,
            "Mexico","Kuwait",
            "Japan","Brazil", 4)
        questionList.add(qu3)
        val qu4=Question(4,"What does this flag belong to?",
        R.drawable.ic_flag_of_belgium,
        "Jordan","Belgium",
        "Italy","Greece",2)
        questionList.add(qu4)
        val qu5=Question(5,"What does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3)
        questionList.add(qu5)
        val qu6=Question(6,"What does this flag belong to?",
        R.drawable.ic_flag_of_germany,
            "Germany","Finland",
        "Egypt","none of these", 1)
        questionList.add(qu6)
        val qu7=Question(7,"What does this flag belong to?",
        R.drawable.ic_flag_of_denmark,
        "Ecuador","Denmark",
        "Cuba","China",2)
        questionList.add(qu7)
        val qu8=Question(8,"What does this flag belong to?",
        R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4)
        questionList.add(qu8)
        val qu9=Question(9,"What does this flag belong to?",
        R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2)
        questionList.add(qu9)
        val qu10=Question(10,"What does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1)
        questionList.add(qu10)
        return questionList
    }
}