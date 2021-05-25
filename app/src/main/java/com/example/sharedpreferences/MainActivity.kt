package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("nome", MODE_PRIVATE)

        buttonWrite.setOnClickListener {
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString().toInt()

            val editor = prefs.edit()
            editor.apply{
                putInt("user_age", age)
                putString("user_name", name)
                apply()
            }
        }

        buttonRead.setOnClickListener {
            val userAge = prefs.getInt("user_age", 0)
            val userName = prefs.getString("user_name", null)

            textView.text = "O seu nome é ${userName} e a sua idade é ${userAge}"
        }
    }
}