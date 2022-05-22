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
        fun cityButtonClicked() {

        }
        findViewById<Button>(R.id.coordBtn).setOnClickListener {
            findViewById<Button>(R.id.coordBtn).isSelected = !findViewById<Button>(R.id.coordBtn).isSelected
            if (findViewById<Button>(R.id.cityBtn).isSelected) {
                findViewById<Button>(R.id.cityBtn).isSelected = !findViewById<Button>(R.id.cityBtn).isSelected
            }
        }
        findViewById<Button>(R.id.cityBtn).setOnClickListener {
            findViewById<Button>(R.id.cityBtn).isSelected = !findViewById<Button>(R.id.cityBtn).isSelected
            if (findViewById<Button>(R.id.coordBtn).isSelected) {
                findViewById<Button>(R.id.coordBtn).isSelected = !findViewById<Button>(R.id.coordBtn).isSelected
            }
        }

        val searchButton = findViewById<Button>(R.id.btn)
        searchButton.setOnClickListener {
            val intent = Intent(this, CoordsActivity::class.java)
            startActivity(intent)
        }
    }

    fun onClick(view: View) {
        var txt = findViewById<TextView>(R.id.header)
        var API_KEY = "f75aa22ec6b143fd9843e47520f4274c"
        var location = findViewById<EditText>(R.id.location).text
        val queue = Volley.newRequestQueue(this)
        val url: String = "https://api.weatherbit.io/v2.0/current?city=$location&key=$API_KEY"
        val stringReq: StringRequest = makeStringReq(url, "city", txt)
        queue.add(stringReq)
    }

    fun makeStringReq(url: String, arguments: String, txt: TextView): StringRequest {
        val stringReq = StringRequest(Request.Method.GET, url,
            { response ->
                if (arguments == "city") {
                    val obj = JSONObject(response)
                    val arr = obj.getJSONArray("data")
                    val obj2 = arr.getJSONObject(0)
                    txt.text =
                        obj2.getString("temp") + " deg Celsius in " + obj2.getString("city_name")
                } else {
                    txt.text = "Not Found"
                }
            }, { txt.text = "That didn't work" })
        return stringReq
    }

   //fun setOnClickOptions(view : View) {
   //     var tag :String = view.tag as String
   //     Log.d("tag", tag)
   // }
}

