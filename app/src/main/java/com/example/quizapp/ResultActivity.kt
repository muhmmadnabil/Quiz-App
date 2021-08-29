package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username=intent.getStringExtra(Constants.USERNAME)
        tv_username.text=username
        val correctanswers=intent.getStringExtra(Constants.CORRECTANSWERS)
        val totalquestions=intent.getStringExtra(Constants.TOTALANSWERS)
        tv_score.text="Your score is $correctanswers out of $totalquestions."
        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}