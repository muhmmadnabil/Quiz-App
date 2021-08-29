package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    var CurrentPosition:Int=1
    var QuestionList:ArrayList<Question>?=null
    var SelectedOptionPosition:Int=0
    var userName:String?=null
    var correctAnswers:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        userName=intent.getStringExtra(Constants.USERNAME)

        QuestionList=Constants.getQuestions()

        setQuestion()

        btn_optionOne.setOnClickListener (this)
        btn_optionTwo.setOnClickListener (this)
        btn_optionThree.setOnClickListener (this)
        btn_optionFour.setOnClickListener (this)
        btn_Submit.setOnClickListener (this)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(view: View) {
        when(view.id)
        {
            R.id.btn_optionOne ->
            {
                selectedOptionView(btn_optionOne,1)
            }
            R.id.btn_optionTwo ->
            {
                selectedOptionView(btn_optionTwo,2)
            }
            R.id.btn_optionThree ->
            {
                selectedOptionView(btn_optionThree,3)
            }
            R.id.btn_optionFour ->
            {
                selectedOptionView(btn_optionFour,4)
            }
            R.id.btn_Submit ->
            {
                if(SelectedOptionPosition==0)
                {
                    CurrentPosition++
                    if(CurrentPosition<=QuestionList!!.size)
                    {
                        setQuestion()
                    } else {
                        val intent= Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.USERNAME,userName)
                        intent.putExtra(Constants.CORRECTANSWERS,correctAnswers.toString())
                        intent.putExtra(Constants.TOTALANSWERS,QuestionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }else{
                    val question=QuestionList?.get(CurrentPosition-1)
                    if(question!!.correctAnswer!=SelectedOptionPosition)
                    {
                        answerView(SelectedOptionPosition,R.drawable.wrong_option_border)
                    }else{
                        correctAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border)
                    if(CurrentPosition==QuestionList!!.size)
                    {
                        btn_Submit.text="FINISH"
                    }else{
                        btn_Submit.text="GO TO NEXT QUESTION"
                    }
                    SelectedOptionPosition=0
                }
            }
        }

    }
    fun setQuestion(){
        val question= QuestionList!!.get(CurrentPosition-1)
        defaultOptionView()
        if(CurrentPosition==QuestionList!!.size)
        {
            btn_Submit.text="FINISH"
        }
        else
        {
            btn_Submit.text="SUBMIT"
        }
        progressBar.progress=CurrentPosition
        tv_progress.text="$CurrentPosition/"+progressBar.max
        tv_Question.text=question.question
        iv_image.setImageResource(question.image)
        btn_optionOne.text=question.optionOne
        btn_optionTwo.text=question.optionTwo
        btn_optionThree.text=question.optionThree
        btn_optionFour.text=question.optionFour
    }
    fun selectedOptionView(button:Button,selectedOptionNum:Int)
    {
        defaultOptionView()
        SelectedOptionPosition=selectedOptionNum
        button.setTextColor(Color.parseColor("#363A43"))
        button.setTypeface(button.typeface,Typeface.BOLD)
        button.background=ContextCompat.getDrawable(this,R.drawable.select_option_border)
    }
    fun defaultOptionView()
    {
        val options=ArrayList<Button>()
        options.add(0,btn_optionOne)
        options.add(1,btn_optionTwo)
        options.add(2,btn_optionThree)
        options.add(3,btn_optionFour)
        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border)
        }
    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun answerView(answer:Int, drawableView:Int){
        when(answer)
        {
            1->
            {
                btn_optionOne.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->
            {
                btn_optionTwo.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->
            {
                btn_optionThree.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->
            {
                btn_optionFour.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}