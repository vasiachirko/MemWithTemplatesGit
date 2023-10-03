package com.example.memwithtemplates

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams

class SubMenuActivity : Activity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val menuMainLayout = LinearLayout(this)
        val lpMain = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        menuMainLayout.orientation = LinearLayout.VERTICAL
        menuMainLayout.layoutParams = lpMain
        menuMainLayout.gravity = Gravity.CENTER
        setContentView(menuMainLayout)

        val button1 = ImageButton(this)
        menuMainLayout.addView(button1)
        val lpButton1 = LinearLayout.LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        button1.layoutParams = lpButton1
        lpButton1.weight = 10.0f
        button1.tag = "openSubMenu1"
        button1.setOnClickListener(this)
        button1.scaleType = ImageView.ScaleType.FIT_CENTER
        button1.setImageResource(R.drawable.number1)

        val button2 = ImageButton(this)
        menuMainLayout.addView(button2)
        val lpButton2 = LinearLayout.LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        lpButton2.weight = 10.0f
        button2.layoutParams = lpButton2
        button2.tag = "openSubMenu2"
        button2.setOnClickListener(this)
        button2.scaleType = ImageView.ScaleType.FIT_CENTER
        button2.setImageResource(R.drawable.number2)

        val button3 = ImageButton(this)
        menuMainLayout.addView(button3)
        val lpButton3 = LinearLayout.LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        lpButton3.weight = 10.0f
        button3.layoutParams = lpButton3
        button3.tag = "openSubMenu3"
        button3.setOnClickListener(this)
        button3.scaleType = ImageView.ScaleType.FIT_CENTER
        button3.setImageResource(R.drawable.number3)
    }

    override fun onClick(v: View?) {
        if (v != null && v.tag == "openSubMenu1") {
            Play.currentLevel = 1
        } else if (v != null && v.tag == "openSubMenu2") {
            Play.currentLevel = 2
        } else if (v != null && v.tag == "openSubMenu3") {
            Play.currentLevel = 3
        }
        onPause()
        startActivity(Intent(this, Play::class.java))

    }
}