package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.fragments.AhadethFragment
import com.example.islami.fragments.QuranFragment
import com.example.islami.fragments.RadioFragment
import com.example.islami.fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var bottonNavigation :BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottonNavigation = findViewById(R.id.botton_navigation)
        moveToFragment(QuranFragment())
        bottonNavigation.setOnItemSelectedListener OnItemSelectedListener@{
            when (it.itemId) {
                R.id.ic_quran -> {
                    moveToFragment(QuranFragment())
                }
                R.id.ic_hadeth -> {
                    moveToFragment(AhadethFragment())
                }
                R.id.ic_sebha -> {
                    moveToFragment(SebhaFragment())
                }
                else -> {
                    moveToFragment(RadioFragment())
                }
            }
            return@OnItemSelectedListener true
        }

    }

    fun moveToFragment(fragment :Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment , fragment)
            .commit()

    }
}