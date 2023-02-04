package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class FirstActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var tv_1: TextView
    private lateinit var tv_2: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_activity)
        btn = findViewById(R.id.btn_2)
        tv_1 = findViewById(R.id.player_1)
        tv_2 = findViewById(R.id.player_2)

        btn.setOnClickListener {
            if (tv_1.text.isNotEmpty() && tv_2.text.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("keyString", tv_1.text.toString())
                intent.putExtra("keyString1", tv_2.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(
                    applicationContext,
                    "O'yinchilarni ismini kiriting!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}