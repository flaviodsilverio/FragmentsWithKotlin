package com.example.fragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity(), FragmentOne.FragmentOneActions, FragmentTwo.FragmentTwoActions {

    var isFragmentOneLoaded = true;
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val change = findViewById<Button>(R.id.btn_change)

        showFragmentOne()
        change.setOnClickListener({

            if(isFragmentOneLoaded) {
                showFragmentTwo()
            } else {
                showFragmentOne()
            }

        })
    }

    fun showFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
    }

    fun showFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
    }

    override fun fragmentOneButtonPressed() {
        Toast.makeText(this, "Fragment One Button Pressed", Toast.LENGTH_SHORT).show()
    }

    override fun fragmentTwoButtonPressed() {
        Toast.makeText(this, "Fragment Two Button Pressed", Toast.LENGTH_SHORT).show()
    }
}
