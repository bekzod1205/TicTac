package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var img0: ImageView
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var img5: ImageView
    private lateinit var img6: ImageView
    private lateinit var img7: ImageView
    private lateinit var img8: ImageView
    private lateinit var btn: Button
    private lateinit var tv: TextView
    private var isok = true
    private var matrix = Array(3) { IntArray(3) { -1 } }
    private var res1 = false
    private var res2 = false

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img0 = findViewById(R.id.img0)
        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        img4 = findViewById(R.id.img4)
        img5 = findViewById(R.id.img5)
        img6 = findViewById(R.id.img6)
        img7 = findViewById(R.id.img7)
        img8 = findViewById(R.id.img8)
        btn = findViewById(R.id.btn_1)
        tv = findViewById(R.id.player_id)
        img0.setOnClickListener(this)
        img1.setOnClickListener(this)
        img2.setOnClickListener(this)
        img3.setOnClickListener(this)
        img4.setOnClickListener(this)
        img5.setOnClickListener(this)
        img6.setOnClickListener(this)
        img7.setOnClickListener(this)
        img8.setOnClickListener(this)
        btn.setOnClickListener {
            matrix = Array(3) { IntArray(3) { -1 } }
            res1 = false
            res2 = false
            isok = true
            img0.setImageResource(0)
            img1.setImageResource(0)
            img2.setImageResource(0)
            img3.setImageResource(0)
            img4.setImageResource(0)
            img5.setImageResource(0)
            img6.setImageResource(0)
            img7.setImageResource(0)
            img8.setImageResource(0)
            tv.text = "Player X"
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val image = findViewById<ImageView>(view.id)
        if (image.drawable != null) return
        var row = image.tag.toString().toInt() / 3
        var col = image.tag.toString().toInt() % 3
        if (res1 || res2) return
        if (isok) {
            matrix[row][col] = 1
            image.setImageResource(R.drawable.x)
            tv.text = tv.text.dropLast(1).toString() + "O"
            isok = false
            res1 = isWin(1)
        } else {
            matrix[row][col] = 0
            image.setImageResource(R.drawable.o)
            tv.text = tv.text.dropLast(1).toString() + "X"
            isok = true
            res2 = isWin(0)
        }
        if (res1) {
            if (!tv.text.contains("X won")) {
                tv.text = tv.text.dropLast(1).toString() + "X won"
                btn.visibility = View.VISIBLE
            }
            return
        }
        if (res2) {
            if (!tv.text.contains("O won")) {
                tv.text = tv.text.dropLast(1).toString() + "O won"
                btn.visibility = View.VISIBLE
            }
            return
        }
    }

    fun isWin(n: Int): Boolean {
        if (matrix[0][0] == n && matrix[0][1] == n && matrix[0][2] == n) return true
        if (matrix[1][0] == n && matrix[1][1] == n && matrix[1][2] == n) return true
        if (matrix[2][0] == n && matrix[2][1] == n && matrix[2][2] == n) return true
        if (matrix[0][0] == n && matrix[1][0] == n && matrix[2][0] == n) return true
        if (matrix[0][1] == n && matrix[1][1] == n && matrix[2][1] == n) return true
        if (matrix[0][2] == n && matrix[1][2] == n && matrix[2][2] == n) return true
        if (matrix[0][0] == n && matrix[1][1] == n && matrix[2][2] == n) return true
        if (matrix[0][2] == n && matrix[1][1] == n && matrix[2][0] == n) return true
        return false
    }

}