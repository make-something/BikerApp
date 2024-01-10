package com.example.biker

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.os.Vibrator
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.Locale

class KeyActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var vibrator: Vibrator
    private lateinit var textToSpeech: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key)

        val btn_toast1: Button = findViewById(R.id.btn_start)
        val btn_toast2: Button = findViewById(R.id.btn_call)


        vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
        btn_toast1.setOnClickListener {
            // Trigger vibration
            vibrate()
            // Trigger Toast
            showToast("Your Engine is ON")
            // Trigger speakText
            speakText("Your Engine is ON")
        }
        textToSpeech = TextToSpeech(this, this)
        btn_toast2.setOnClickListener {
            // Trigger speakText
            speakText("Your alarm is on")
            // Trigger Toast
            showToast("Your Alarm is ON")
        }

    }
    //Funtion for Toast
    private fun showToast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
    // for set the time vibrate
    private fun vibrate() {
        // Check if the device has a vibrator
        if (vibrator.hasVibrator()) {
            // Vibrate for 400 milliseconds
            vibrator.vibrate(400)
        }
    }
    // funtion for Text Speech

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech.setLanguage(Locale.getDefault())

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                showToast("Text-to-Speech is not supported on this device.")
            }
        } else {
            showToast("Initialization failed.")
        }
    }
    private fun speakText(text: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        } else {
            @Suppress("DEPRECATION")
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null)
        }
    }
    override fun onDestroy() {
        if (::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }

}