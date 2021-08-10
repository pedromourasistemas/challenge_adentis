package com.example.challengeportugal

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textView = findViewById(R.id.text_result)

        val bundle = intent.extras
        if (bundle != null) {
            val listWords = bundle.getStringArrayList("PALAVRAS")

            listWords?.forEach {
                textView.append(it+"\n")
            }
        }
    }
}
