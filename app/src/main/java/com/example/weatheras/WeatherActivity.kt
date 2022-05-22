package com.example.weatheras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.*
import org.json.JSONObject
import java.net.URI
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        var txt = findViewById<TextView>(R.id.header)
        var API_KEY = "f75aa22ec6b143fd9843e47520f4274c"
        var location = findViewById<EditText>(R.id.location).text
        val queue = Volley.newRequestQueue(this)
        val url: String = "https://api.weatherbit.io/v2.0/current?city=$location&key=$API_KEY"
        val stringReq: StringRequest = makeStringReq(url, "city", txt)
        queue.add(stringReq)
                            //    { response ->
                // get the JSON object
        //        val obj = JSONObject(response)

                // get the Array from obj of name - "data"
        //        val arr = obj.getJSONArray("data")

                // get the JSON object from the
                // array at index position 0
        //      val obj2 = arr.getJSONObject(0)

                // set the temperature and the city
        //        txt.setText(obj2.getString("temp") + " deg Celsius in " + obj2.getString("city_name"))
        //    },
            // In case of any error
        //    { txt!!.setText("That didn't work")})
    }
    fun makeStringReq(url: String, arguments: String, txt: TextView): StringRequest{
        val stringReq = StringRequest(Request.Method.GET, url,
            { response ->
                if(arguments == "city") {
                    val obj = JSONObject(response)
                    val arr = obj.getJSONArray("data")
                    val obj2 = arr.getJSONObject(0)
                    txt.text = obj2.getString("temp") + " deg Celsius in " + obj2.getString("city_name")
                } else {
                    txt.text = "Not Found"
                }
        }, { txt.text = "That didn't work" })
        return stringReq
    }
}