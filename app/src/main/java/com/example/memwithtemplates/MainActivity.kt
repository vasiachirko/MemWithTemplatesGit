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


class MainActivity : ComponentActivity(), View.OnClickListener {

    val currentLevel = 3
    var initialClick = false
    val randomListIndexes = ArrayList<Int>()
    val allButtonsOnPage = ArrayList<ImageButton>()
    val picturesList = ArrayList<Int>()

    lateinit var imgRight : ImageView
    lateinit var imgLeft : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialClick = true
        setContentView(R.layout.activity_main)
        createLayout()

        val mainScreenMainLayout: ConstraintLayout = findViewById(R.id.mainConstraintLayout)
        mainScreenMainLayout.setOnClickListener(this)
        picturesList.add(R.drawable.pic0)
        picturesList.add(R.drawable.pic1)
        picturesList.add(R.drawable.pic2)
        picturesList.add(R.drawable.pic3)
        picturesList.add(R.drawable.pic4)
        picturesList.add(R.drawable.pic5)
        picturesList.add(R.drawable.pic6)
        picturesList.add(R.drawable.pic7)
        picturesList.add(R.drawable.pic8)
        picturesList.add(R.drawable.pic9)
        picturesList.add(R.drawable.pic10)
        picturesList.add(R.drawable.pic11)
        picturesList.add(R.drawable.pic12)
        picturesList.add(R.drawable.pic13)
        picturesList.add(R.drawable.pic14)





        for (i in 0..< currentLevel * 10 / 2){
            randomListIndexes.add(i)
            randomListIndexes.add(i)
        }
        randomListIndexes.shuffle()



        for (i in 0..<currentLevel * 10) {
            val my_btn : ImageButton = allButtonsOnPage[i]
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
        picturesPlusButtonsLayoutMain.gravity = Gravity.TOP
        val lp = ConstraintLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        picturesPlusButtonsLayoutMain.layoutParams = lp
        mainScreenMainLayout.addView(picturesPlusButtonsLayoutMain)


        val picturesLayout = TableLayout(this)
        val lpTable = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        lpTable.gravity = Gravity.TOP
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
        lpImgLeft.height = TableRow.LayoutParams.WRAP_CONTENT
        lpImgLeft.weight = 1.0f
        imgLeft.layoutParams = lpImgLeft
        imgLeft.setImageResource(R.drawable.tshirt2)
        tableRow.addView(imgLeft)



        imgRight = ImageView(this)
        imgRight.adjustViewBounds = true
        val lpImgRight = TableRow.LayoutParams()
        lpImgRight.height = TableRow.LayoutParams.WRAP_CONTENT
        lpImgRight.width = TableRow.LayoutParams.WRAP_CONTENT
        lpImgRight.weight = 1.0f
        imgRight.layoutParams = lpImgRight
        imgRight.setImageResource(R.drawable.tshirt2)

        tableRow.addView(imgRight)

        //layout and buttons itself
        val buttonsLayout = TableLayout(this)
        val lpButtonsTable = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
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

    }

    var buttonLeft : ImageButton? = null
    var buttonRight : ImageButton? = null
    override fun onClick(v: View) {
        if (initialClick) {
            for (i in 0..<currentLevel * 10) {
                val my_btn : ImageButton = allButtonsOnPage[i]
                my_btn.setImageResource(R.drawable.tshirt2)
            }
            initialClick = false
            return
        }



        if (buttonLeft == null && v.tag != null ) {
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
            }
        } else if (buttonLeft != null && buttonRight != null ){
            if (buttonLeft != null){ buttonLeft!!.setImageResource(R.drawable.tshirt2) }
            if (buttonRight != null){ buttonRight!!.setImageResource(R.drawable.tshirt2) }
            imgLeft.setImageResource(R.drawable.tshirt2)
            imgRight.setImageResource(R.drawable.tshirt2)
            buttonLeft = null
            buttonRight = null
        }


    }
}