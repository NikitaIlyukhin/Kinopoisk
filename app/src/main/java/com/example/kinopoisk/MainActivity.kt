package com.example.kinopoisk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.kinopoisk.view.LoginFragment
import com.example.kinopoisk.view.StartFragment

class MainActivity : AppCompatActivity() {
    private lateinit var transaction:FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){
            transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.fragment_container_view,StartFragment.newInstance(),"startFragment").commit()
        }
    }
}