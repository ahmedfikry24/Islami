package com.example.islami.fragments

import android.graphics.Matrix
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islami.R

class SebhaFragment : Fragment() {
    private lateinit var tasbehNumbers: TextView
    private lateinit var bodySebhaLogo: ImageView
    private lateinit var tasbehButton: Button
    private var counter: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        listener()

    }

    private fun init(view: View) {
        tasbehNumbers = view.findViewById(R.id.tasbeh_number_text)
        bodySebhaLogo = view.findViewById(R.id.body_sebha_logo)
        tasbehButton = view.findViewById(R.id.tasbeh_button)
        tasbehNumbers.text =counter.toString()
        tasbehButton.text = "سبحان الله"
    }

    private fun listener() {
        tasbehButton.setOnClickListener {
            if (counter < 32) {
                bodySebhaLogo.rotation = bodySebhaLogo.rotation + 10
                counter++
                tasbehNumbers.text = counter.toString()
            } else {
                counter++
                tasbehNumbers.text = counter.toString()
               if(tasbehButton.text == "سبحان الله"){
                   tasbehButton.text = "الحمد لله"
                   counter = 0
                   tasbehNumbers.text = counter.toString()
               }else if (tasbehButton.text == "الحمد لله"){
                   tasbehButton.text = "الله اكبر"
                   counter = 0
                   tasbehNumbers.text = counter.toString()
               }else if (tasbehButton.text == "الله اكبر"){
                   tasbehButton.text = "سبحان الله"
                   counter = 0
                   tasbehNumbers.text = counter.toString()
               }

            }

        }

    }
}