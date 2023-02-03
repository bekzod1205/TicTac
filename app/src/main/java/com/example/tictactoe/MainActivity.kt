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
    private var res = false

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
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        val image = findViewById<ImageView>(view.id)
        var row = image.tag.toString().toInt() / 3
        var col = image.tag.toString().toInt() % 3
        if (isok) {
            matrix[row][col] = 1
            image.setImageResource(R.drawable.x)
            tv.text = tv.text.dropLast(1).toString() + "O"
            isok = false
        } else {
            matrix[row][col] = 0
            image.setImageResource(R.drawable.o)
            tv.text = tv.text.dropLast(1).toString() + "X"
            isok = true
        }
    }

    fun isXwin(mat: Array<IntArray>): Boolean {
        if (mat[0][0] == 1 && mat[0][1] == 1 && mat[0][2] == 1) return true
        if (mat[1][0] == 1 && mat[1][1] == 1 && mat[1][2] == 1) return true
        if (mat[2][0] == 1 && mat[2][1] == 1 && mat[2][2] == 1) return true
        if (mat[0][0] == 1 && mat[1][0] == 1 && mat[2][0] == 1) return true
        if (mat[0][1] == 1 && mat[1][1] == 1 && mat[2][1] == 1) return true
        if (mat[0][2] == 1 && mat[1][2] == 1 && mat[2][2] == 1) return true
        if (mat[0][0] == 1 && mat[1][1] == 1 && mat[2][2] == 1) return true
        if (mat[0][2] == 1 && mat[1][1] == 1 && mat[2][0] == 1) return true
        return false
    }

    fun isOwin(mat: Array<IntArray>): Boolean {
        if (mat[0][0] == 0 && mat[0][1] == 0 && mat[0][2] == 0) return true
        if (mat[1][0] == 0 && mat[1][1] == 0 && mat[1][2] == 0) return true
        if (mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] == 0) return true
        if (mat[0][0] == 0 && mat[1][0] == 0 && mat[2][0] == 0) return true
        if (mat[0][1] == 0 && mat[1][1] == 0 && mat[2][1] == 0) return true
        if (mat[0][2] == 0 && mat[1][2] == 0 && mat[2][2] == 0) return true
        if (mat[0][0] == 0 && mat[1][1] == 0 && mat[2][2] == 0) return true
        if (mat[0][2] == 0 && mat[1][1] == 0 && mat[2][0] == 0) return true
        return false
    }
}