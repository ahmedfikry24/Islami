package com.example.islami


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList

class HadethDetails : AppCompatActivity() {
    var position: Int = 0
    lateinit var back: ImageView
    lateinit var hadeth: TextView
    var initialContent: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        init()
        val HadethFileName: String = "h${position + 1}.txt"
        readFile(HadethFileName)
        initLisnters()
    }

    fun init() {
        position = intent.getIntExtra("position", 0)
        hadeth = findViewById(R.id.hadeth_contect)
        back = findViewById(R.id.hadeth_backArrow)
    }

    fun initLisnters() {
        back.setOnClickListener {
            finish()
        }
    }

    fun readFile(fileName: String) {
        val bufferedReader: BufferedReader =
            BufferedReader(InputStreamReader(assets.open(fileName)))
        val lines = bufferedReader.lines().toList()
        for (i in 0..lines.size - 1) {
            initialContent += lines[i]
            println(initialContent)
        }
    }
}