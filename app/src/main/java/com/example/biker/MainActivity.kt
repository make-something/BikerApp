package com.example.biker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.btn_kunci)
        btnNext.setOnClickListener {
            val intent = Intent(this, KeyActivity::class.java)
            startActivity(intent)
        }
        val btnSer = findViewById<Button>(R.id.btn_Ser)
        btnSer.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }


    }




}