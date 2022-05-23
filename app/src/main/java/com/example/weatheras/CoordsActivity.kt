package com.example.weatheras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CoordsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coords)
        findViewById<Button>(R.id.coordBtn).isSelected = true

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
        val cityButton = findViewById<Button>(R.id.cityBtn)
        cityButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            //For coords mode: pass latitude, longitude, putExtra("mode", "coords")
            //For city: pass city name, putExtra("mode", "city")
        }
        val searchButton = findViewById<Button>(R.id.btn)
        searchButton.setOnClickListener {
            var longitude = findViewById<EditText>(R.id.longitude).text.toString()
            var latitude = findViewById<EditText>(R.id.latitude).text.toString()
            val intent = Intent(this, SearchActivity::class.java).apply {
                putExtra("longitude", longitude)
                putExtra("latitude", latitude)
                putExtra("mode", "coords")
            }
            //For coords mode: pass latitude, longitude, putExtra("mode", "coords")
            //For city: pass city name, putExtra("mode", "city")
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

}