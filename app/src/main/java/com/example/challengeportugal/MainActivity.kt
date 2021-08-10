package com.example.challengeportugal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.StringTokenizer

class MainActivity : AppCompatActivity() {

    private lateinit var btnSend: Button
    private val listString: MutableList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend = findViewById(R.id.btn_send)

        btnSend.setOnClickListener {
            val frase = "Esta é uma frase exemplo exemplo"

            val word1 = frase.substring(0, 4)
            val word2 = frase.substring(5, 6)
            val word3 = frase.substring(7, 10)
            val word4 = frase.substring(11, 16)
            val word5 = frase.substring(17, 24)
            val word6 = frase.substring(25, 32)

            println(word1 + " - " + contaPalavra(word1, frase))
            println(word2 + " - " + contaPalavra(word2, frase))
            println(word3 + " - " + contaPalavra(word3, frase))
            println(word4 + " - " + contaPalavra(word4, frase))
            println(word5 + " - " + contaPalavra(word5, frase))

            listString.add(word1 + " - " + contaPalavra(word1, frase))
            listString.add(word2 + " - " + contaPalavra(word2, frase))
            listString.add(word3 + " - " + contaPalavra(word3, frase))
            listString.add(word4 + " - " + contaPalavra(word4, frase))
            listString.add(word5 + " - " + contaPalavra(word5, frase))

            sendResult(listString)
        }
    }

    private fun contaPalavra(palavra: String, texto: String): Int {
        val st = StringTokenizer(texto)
        var count = 0
        while (st.hasMoreTokens()) {
            if (st.nextToken().compareTo(palavra) == 0) {
                count++
            }
        }
        return count
    }

    private fun sendResult(listString: MutableList<String>) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("PALAVRAS", ArrayList(listString))
        startActivity(intent)
    }
}
