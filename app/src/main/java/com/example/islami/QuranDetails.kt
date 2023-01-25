package com.example.islami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader
import kotlin.streams.toList

class QuranDetails : AppCompatActivity() {
    lateinit var fileName: String
    lateinit var sura_Name: String
    lateinit var content: TextView
    lateinit var suraName: TextView
    var initialContent = ""
    lateinit var back :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_details)
        fileName = intent.getStringExtra("fileName") ?: ""
        sura_Name = intent.getStringExtra("suraName") ?: ""
        init()
        suraName.text = sura_Name
        readFile(fileName)
        content.text = initialContent
        initLisnters()

    }

   fun init (){
       content = findViewById(R.id.suraContent)
       suraName = findViewById(R.id.suraName)
       back = findViewById(R.id.backArrow)
   }
    fun initLisnters(){
        back.setOnClickListener {
            finish()
        }
    }

    fun readFile(fileName: String) {
        val bufferedReader: BufferedReader =
            BufferedReader(InputStreamReader(assets.open(fileName)))
        val lines = bufferedReader.lines().toList()
      for ( i in 0.. lines.size -1){
          initialContent += lines[i] + "(${i+1}) "
      }
    }
}