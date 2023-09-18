package com.example.memwithtemplates


import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createLayout()
    }


    fun createLayout() {
        setContentView(R.layout.activity_main)
        val mainScreenMainLayout: ConstraintLayout = findViewById(R.id.mainConstraintLayout)

        //detach 2 images and buttons
        val picturesPlusButtonsLayoutMain = LinearLayout(this)
        picturesPlusButtonsLayoutMain.orientation = LinearLayout.VERTICAL
        picturesPlusButtonsLayoutMain.gravity = Gravity.CENTER
        val lp3 = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        picturesPlusButtonsLayoutMain.layoutParams = lp3
        mainScreenMainLayout.addView(picturesPlusButtonsLayoutMain)

        //images
        val twoMainPicturesLayout = LinearLayout(this)
        twoMainPicturesLayout.orientation = LinearLayout.HORIZONTAL
        twoMainPicturesLayout.gravity = Gravity.CENTER
        val lp = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        lp.setMargins(0, 0, 0, 100)                        //between pictures and buttons
        twoMainPicturesLayout.layoutParams = lp
        picturesPlusButtonsLayoutMain.addView(twoMainPicturesLayout)

        //2 pictures
        val imgLeft = ImageView(this)
        imgLeft.maxWidth = 500
        imgLeft.maxHeight = 500
        imgLeft.adjustViewBounds = true
        imgLeft.setImageResource(R.drawable.tshirt2)
        twoMainPicturesLayout.addView(imgLeft)

        val lp2 = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        lp2.setMargins(0, 0, 50, 0)
        imgLeft.layoutParams = lp2

        val imgRight = ImageView(this)
        imgRight.maxWidth = 500
        imgRight.maxHeight = 500
        imgRight.adjustViewBounds = true
        imgRight.setImageResource(R.drawable.tshirt2)
        twoMainPicturesLayout.addView(imgRight)

        //layout and buttons itself
        val buttonsLayouts = ArrayList<LinearLayout>()
        val layoutParamsList = ArrayList<LinearLayout.LayoutParams>()
        val allButtonsOnPage = ArrayList<ImageButton>()

        val numOfRows = 4
        for (j in 0..<numOfRows) {
            buttonsLayouts.add(LinearLayout(this))
            buttonsLayouts[j].orientation = LinearLayout.HORIZONTAL
            buttonsLayouts[j].gravity = Gravity.CENTER
            layoutParamsList.add(
                LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
                )
            )
            layoutParamsList[j].setMargins(0, 0, 0, 25)        //margin to next row
            buttonsLayouts[j].layoutParams = layoutParamsList[j]
            picturesPlusButtonsLayoutMain.addView(buttonsLayouts[j])

            val numOfButtonsInARow = 5
            for (i in 0..<numOfButtonsInARow) {
                allButtonsOnPage.add(ImageButton(this))
                val index = numOfButtonsInARow * j + i
                allButtonsOnPage[index].adjustViewBounds = true
                allButtonsOnPage[index].maxWidth = 200
                allButtonsOnPage[index].maxHeight = 200
                allButtonsOnPage[index].setImageResource(R.drawable.tshirt2)
                buttonsLayouts[j].addView(allButtonsOnPage[index])

            }
        }
        allButtonsOnPage[17].visibility = View.INVISIBLE
//
//        allButtonsOnPage.add(ImageButton(this))
//        val lastButton = allButtonsOnPage[allButtonsOnPage.size-1]
//        lastButton.id = ("+id/btn" + "1").hashCode()
//        lastButton.maxWidth = 250
//        lastButton.maxHeight = 250
//        lastButton.adjustViewBounds = true
//        lastButton.setImageResource(R.drawable.tshirt2)
//        buttonsLayouts[buttonsLayouts.size-1].addView(lastButton)
//        val template = "+id/btn"
//        val searchId = template + "1"
//        findViewById<ImageButton>(searchId.hashCode()).setImageResource(R.drawable.ic_launcher_foreground)
//
//        allButtonsOnPage[10].setImageResource(R.drawable.ic_launcher_foreground)
//        allButtonsOnPage[10].visibility = View.INVISIBLE
    }
}