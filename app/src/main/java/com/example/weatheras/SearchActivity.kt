package com.example.weatheras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val mode = intent.getStringExtra("mode")
        var API_KEY = "f75aa22ec6b143fd9843e47520f4274c"
        val queue = Volley.newRequestQueue(this)
        val stringReq: StringRequest
        if(mode == "city") {
            val location = intent.getStringExtra("location")
            val url: String = "https://api.weatherbit.io/v2.0/current?city=$location&key=$API_KEY"
            stringReq = makeStringReq(url, "city", findViewById(R.id.currWeather))
        } else {
            val latitude = intent.getStringExtra("latitude")
            val longitude = intent.getStringExtra("longitude")
            val url: String = "https://api.weatherbit.io/v2.0/current?lat=$latitude&lon=$longitude&key=$API_KEY"
            stringReq = makeStringReq(url, "coords", findViewById(R.id.currWeather))
        }
        queue.add(stringReq)
        val backButton = findViewById<Button>(R.id.backBtn)
        backButton.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }
    }

    fun makeStringReq(url: String, arguments: String, txt: TextView): StringRequest {
        val stringReq = StringRequest(
            Request.Method.GET, url,
            { response ->
                if(arguments != "coords" && arguments != "city") {
                    txt.text = "Not found"
                }
                val obj = JSONObject(response)
                val arr = obj.getJSONArray("data")
                val obj2 = arr.getJSONObject(0)
                txt.text = obj2.getString("temp") + " deg Celsius in " + obj2.getString("city_name")
            }, { txt.text = "That didn't work" })
        return stringReq
    }
}
