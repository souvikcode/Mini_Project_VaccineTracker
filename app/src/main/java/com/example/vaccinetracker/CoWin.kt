package com.example.vaccinetracker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CoWin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_co_win)
        val button = findViewById<Button>(R.id.btn1)
        button?.setOnClickListener()
        {
            val url = "https://www.cowin.gov.in/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)

        }
        val button1 = findViewById<Button>(R.id.btn2)
        button1?.setOnClickListener()
        {
            val intent2 = Intent(this, pin_code::class.java)
            startActivity(intent2)

        }
    }

}