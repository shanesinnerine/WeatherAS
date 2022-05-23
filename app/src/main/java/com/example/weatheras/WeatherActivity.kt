package com.example.weatheras

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.cityBtn).isSelected = true

        findViewById<Button>(R.id.coordBtn).setOnClickListener {
            if (findViewById<Button>(R.id.cityBtn).isSelected) {
                findViewById<Button>(R.id.cityBtn).isSelected = !findViewById<Button>(R.id.cityBtn).isSelected
                findViewById<Button>(R.id.coordBtn).isSelected = !findViewById<Button>(R.id.coordBtn).isSelected
            }
        }
        findViewById<Button>(R.id.cityBtn).setOnClickListener {
            if (findViewById<Button>(R.id.coordBtn).isSelected) {
                findViewById<Button>(R.id.coordBtn).isSelected = !findViewById<Button>(R.id.coordBtn).isSelected
                findViewById<Button>(R.id.cityBtn).isSelected = !findViewById<Button>(R.id.cityBtn).isSelected
            }
        }

        val searchButton = findViewById<Button>(R.id.btn)
        searchButton.setOnClickListener {
            var location = findViewById<EditText>(R.id.location).text.toString()
            val intent = Intent(this, SearchActivity::class.java).apply {
                putExtra("location", location)
            }
            //For coords mode: pass latitude, longitude, putExtra("mode", "coords")
            //For city: pass city name, putExtra("mode", "city")
            startActivity(intent)
        }
    }


}

