package com.example.biker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.Toast

class KeyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key)

        val btn_toast1: Button = findViewById(R.id.btn_start)
        val btn_toast2: Button = findViewById(R.id.btn_call)

        btn_toast1.setOnClickListener {
            showToast("Your Engine is ON")
        }
        btn_toast2.setOnClickListener {
            showToast("Your Alarm is ON")
        }

    }
    private fun showToast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

}