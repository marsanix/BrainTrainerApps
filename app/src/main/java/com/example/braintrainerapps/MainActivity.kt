package com.example.braintrainerapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.braintrainerapps.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val answers = arrayListOf<Int>()
    private var answerLocation: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartGo.setOnClickListener {
            startGo()
        }

    }


    private fun startGo() {

        binding.btnStartGo.isVisible = false
        binding.gridLayout.isVisible = true

        val rand = Random(20)
        val a = rand.nextInt(1, 20)
        val b = rand.nextInt(1, 20)

        val answer = a + b
        binding.tvQuestion.text = "$a + $b"
        answerLocation = rand.nextInt(4)

        var incorrectAnswer: Int = 0

        for (i in 2..4) {
            if(i == answerLocation) {
                answers.add(answer)
            } else {
                incorrectAnswer = rand.nextInt(40)
                while (incorrectAnswer == a + b) {
                    incorrectAnswer = rand.nextInt(40)
                }
                answers.add(incorrectAnswer)
            }
        }

        binding.btn1.text = answers.get(0).toString()
        binding.btn2.text = answers.get(1).toString()
        binding.btn3.text = answers.get(2).toString()
        binding.btn4.text = answers.get(3).toString()
    }

}