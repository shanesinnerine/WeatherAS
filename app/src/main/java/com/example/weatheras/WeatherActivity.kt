package com.example.weatheras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        var txt = findViewById<TextView>(R.id.header)
        var location = findViewById<EditText>(R.id.location)
        txt.setText("You are in " + location.text.toString())
        location.setText("")
        txt.setTextSize(40F)
    }
}