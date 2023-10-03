package com.example.memwithtemplates


import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginStart
import com.bumptech.glide.Glide


import android.app.Activity
import android.content.Intent

class Play : Activity(), View.OnClickListener {

    companion object { var currentLevel = 3
     var currentLetter = 1 }
    var initialClick = false
    val randomListIndexes = ArrayList<Int>()
    val allButtonsOnPage = ArrayList<ImageButton>()
    val picturesList = ArrayList<Int>()


    lateinit var imgRight: ImageView
    lateinit var imgLeft: ImageView

    override fun onStart() {
        super.onStart()

        initialClick = true
        setContentView(R.layout.activity_main)
        createLayout()

        val mainScreenMainLayout: ConstraintLayout = findViewById(R.id.mainConstraintLayout)
        mainScreenMainLayout.setOnClickListener(this)


        picturesList.clear()
        if (currentLetter == 1) {
            picturesList.add(R.drawable.pic10)
            picturesList.add(R.drawable.pic1)
            picturesList.add(R.drawable.pic2)
            picturesList.add(R.drawable.pic3)
            picturesList.add(R.drawable.pic4)
            picturesList.add(R.drawable.pic5)
            picturesList.add(R.drawable.pic6)
            picturesList.add(R.drawable.pic7)
            picturesList.add(R.drawable.pic8)
            picturesList.add(R.drawable.pic9)
        } else if (currentLetter == 2) {
            picturesList.add(R.drawable.letter2_picture1)
            picturesList.add(R.drawable.letter2_picture2)
            picturesList.add(R.drawable.letter2_picture3)
            picturesList.add(R.drawable.letter2_picture4)
            picturesList.add(R.drawable.letter2_picture5)
            picturesList.add(R.drawable.letter2_picture6)
            picturesList.add(R.drawable.letter2_picture7)
            picturesList.add(R.drawable.letter2_picture8)
            picturesList.add(R.drawable.letter2_picture9)
            picturesList.add(R.drawable.letter2_picture10)
        } else if (currentLetter == 3) {
            picturesList.add(R.drawable.letter3_picture1)
            picturesList.add(R.drawable.letter3_picture2)
            picturesList.add(R.drawable.letter3_picture3)
            picturesList.add(R.drawable.letter3_picture4)
            picturesList.add(R.drawable.letter3_picture5)
            picturesList.add(R.drawable.letter3_picture6)
            picturesList.add(R.drawable.letter3_picture7)
            picturesList.add(R.drawable.letter3_picture8)
            picturesList.add(R.drawable.letter3_picture9)
            picturesList.add(R.drawable.letter3_picture10)
        } else if (currentLetter == 4) {
            picturesList.add(R.drawable.letter4_picture1)
            picturesList.add(R.drawable.letter4_picture2)
            picturesList.add(R.drawable.letter4_picture3)
            picturesList.add(R.drawable.letter4_picture4)
            picturesList.add(R.drawable.letter4_picture5)
            picturesList.add(R.drawable.letter4_picture6)
            picturesList.add(R.drawable.letter4_picture7)
            picturesList.add(R.drawable.letter4_picture8)
            picturesList.add(R.drawable.letter4_picture9)
            picturesList.add(R.drawable.letter4_picture10)
        }





        for (i in 0..<(currentLevel -1) * 10 / 2) {
            randomListIndexes.add(i)
            randomListIndexes.add(i)
        }
        for (i in 5..< 10) {
            randomListIndexes.add(i)
            randomListIndexes.add(i)
        }

        randomListIndexes.shuffle()



        for (i in 0..<currentLevel * 10) {
            val my_btn: ImageButton = allButtonsOnPage[i]
            my_btn.setImageResource(picturesList[randomListIndexes[i]])
            my_btn.setOnClickListener(this)
        }
    }


    fun createLayout() {
        setContentView(R.layout.activity_main)
        val mainScreenMainLayout: ConstraintLayout = findViewById(R.id.mainConstraintLayout)

        //detach 2 images and buttons
        val picturesPlusButtonsLayoutMain = LinearLayout(this)
        picturesPlusButtonsLayoutMain.orientation = LinearLayout.VERTICAL
        val lp = ConstraintLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        picturesPlusButtonsLayoutMain.layoutParams = lp
        picturesPlusButtonsLayoutMain.gravity = Gravity.NO_GRAVITY
        mainScreenMainLayout.addView(picturesPlusButtonsLayoutMain)


        val picturesLayout = TableLayout(this)
        val lpTable = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        lpTable.gravity = Gravity.TOP
        lpTable.weight = 1.0f
        picturesLayout.layoutParams = lpTable
        picturesPlusButtonsLayoutMain.addView(picturesLayout)

        val tableRow = TableRow(this)
        val lpRow = TableLayout.LayoutParams()
        lpRow.width = TableLayout.LayoutParams.WRAP_CONTENT
        lpRow.height = TableLayout.LayoutParams.WRAP_CONTENT
        lpRow.gravity = Gravity.CLIP_HORIZONTAL
        picturesLayout.addView(tableRow)


        //2 pictures
        imgLeft = ImageView(this)
        imgLeft.adjustViewBounds = true
        val lpImgLeft = TableRow.LayoutParams()
        lpImgLeft.width = TableRow.LayoutParams.WRAP_CONTENT
        lpImgLeft.height = TableRow.LayoutParams.MATCH_PARENT
        lpImgLeft.weight = 1.0f
        imgLeft.layoutParams = lpImgLeft
        imgLeft.setImageResource(R.drawable.tshirt2)
        imgLeft.scaleType = ImageView.ScaleType.CENTER_CROP
        tableRow.addView(imgLeft)



        imgRight = ImageView(this)
        imgRight.adjustViewBounds = true
        val lpImgRight = TableRow.LayoutParams()
        lpImgRight.width = TableRow.LayoutParams.WRAP_CONTENT
        lpImgRight.height = TableRow.LayoutParams.MATCH_PARENT
        lpImgRight.weight = 1.0f
        imgRight.layoutParams = lpImgRight
        imgRight.scaleType = ImageView.ScaleType.CENTER_CROP
        imgRight.setImageResource(R.drawable.tshirt2)

        tableRow.addView(imgRight)

        //layout and buttons itself
        val buttonsLayout = TableLayout(this)
        val lpButtonsTable = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        buttonsLayout.layoutParams = lpButtonsTable
        lpButtonsTable.gravity = Gravity.BOTTOM
        lpButtonsTable.weight = 10.0f
        picturesPlusButtonsLayoutMain.addView(buttonsLayout)

        val numOfButtonsInARow = 5
        val numOfRows = currentLevel * 10 / numOfButtonsInARow
        for (j in 0..<numOfRows) {
            val tableRowButtons = TableRow(this)
            val lpRowButtons = TableLayout.LayoutParams()
            lpRowButtons.width = TableLayout.LayoutParams.WRAP_CONTENT
            lpRowButtons.height = TableLayout.LayoutParams.WRAP_CONTENT
            lpRowButtons.gravity = Gravity.CLIP_HORIZONTAL
            tableRowButtons.layoutParams = lpRowButtons
            buttonsLayout.addView(tableRowButtons)



            for (i in 0..<numOfButtonsInARow) {
                allButtonsOnPage.add(ImageButton(this))
                val index = numOfButtonsInARow * j + i
                val lpImageButton = TableRow.LayoutParams()
                lpImageButton.width = TableRow.LayoutParams.WRAP_CONTENT
                lpImageButton.height = TableRow.LayoutParams.WRAP_CONTENT
                lpImageButton.weight = 1.0f

                allButtonsOnPage[index].layoutParams = lpImageButton
                allButtonsOnPage[index].tag = index
                allButtonsOnPage[index].adjustViewBounds = true
//                allButtonsOnPage[index].maxWidth = 130
//                allButtonsOnPage[index].maxHeight = 130
                allButtonsOnPage[index].setImageResource(R.drawable.tshirt2)
                tableRowButtons.addView(allButtonsOnPage[index])

            }
        }

        val animation = ImageView(this)
        animation.id = R.id.imgAnimation
        val lpAnimation = LinearLayout
            .LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
        animation.layoutParams = lpAnimation
        mainScreenMainLayout.addView(animation)
    }

    var buttonLeft: ImageButton? = null
    var buttonRight: ImageButton? = null
    override fun onClick(v: View) {
        if (initialClick) {
            for (i in 0..<currentLevel * 10) {
                val my_btn: ImageButton = allButtonsOnPage[i]
                my_btn.setImageResource(R.drawable.tshirt2)
            }
            initialClick = false
            return
        }



        if (buttonLeft == null && v.tag != null) {
            buttonLeft = allButtonsOnPage[v.tag as Int]
            allButtonsOnPage[v.tag as Int].setImageResource(picturesList[randomListIndexes[v.tag as Int]])
            imgLeft.setImageResource(picturesList[randomListIndexes[v.tag as Int]])
        } else if (buttonRight == null && v.tag != null && buttonLeft!!.tag != v.tag) {
            buttonRight = allButtonsOnPage[v.tag as Int]
            allButtonsOnPage[v.tag as Int].setImageResource(picturesList[randomListIndexes[v.tag as Int]])
            imgRight.setImageResource(picturesList[randomListIndexes[v.tag as Int]])
            if (randomListIndexes[buttonLeft!!.tag as Int] == randomListIndexes[buttonRight!!.tag as Int]) {
                buttonLeft!!.visibility = View.INVISIBLE
                buttonRight!!.visibility = View.INVISIBLE
                findViewById<ImageView>(R.id.imgAnimation).visibility = View.VISIBLE
                Glide
                    .with(this)
                    .load(R.drawable.star_once)
                    .into(findViewById(R.id.imgAnimation))

            }
        } else if (buttonLeft != null && buttonRight != null) {
            if (buttonLeft != null) {
                buttonLeft!!.setImageResource(R.drawable.tshirt2)
            }
            if (buttonRight != null) {
                buttonRight!!.setImageResource(R.drawable.tshirt2)
            }
            imgLeft.setImageResource(R.drawable.tshirt2)
            imgRight.setImageResource(R.drawable.tshirt2)
            buttonLeft = null
            buttonRight = null
            findViewById<ImageView>(R.id.imgAnimation).visibility = View.INVISIBLE
            if (v.tag != null) {
                buttonLeft = allButtonsOnPage[v.tag as Int]
                imgLeft.setImageResource(picturesList[randomListIndexes[v.tag as Int]])
                allButtonsOnPage[v.tag as Int].setImageResource(picturesList[randomListIndexes[v.tag as Int]])
            }
        }


    }

}