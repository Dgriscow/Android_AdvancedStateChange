package com.example.android_advancedstatechange

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var txtbox1:TextView
    lateinit var btnTxtBox1:Button

    lateinit var numtxtbox2:TextView
    lateinit var setnumtxtbox2:Button

    lateinit var entryBox:EditText
    lateinit var setEntryBox:Button

    lateinit var randomOutput:TextView
    lateinit var btnPushRandom:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)


        txtbox1 = findViewById(R.id.textView4)
        btnTxtBox1 = findViewById(R.id.button)

        numtxtbox2 = findViewById(R.id.textView3)
        setnumtxtbox2 = findViewById(R.id.button4)

        entryBox = findViewById(R.id.editTextText)
        setEntryBox = findViewById(R.id.button2)

        randomOutput = findViewById(R.id.textView2)
        btnPushRandom = findViewById(R.id.button3)


        //on click set my orientation
        btnTxtBox1.setOnClickListener {

            //for each orientation, set a unique text
            if (btnTxtBox1.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                //PHONE IS PORTRAIT
                txtbox1.text = "PHONE IS PORTRAIT"

            }else{
                txtbox1.text = "PHONE IS LANDSCAPE"
            }
        }

        //on click listender for set a number
        setnumtxtbox2.setOnClickListener {

            //for each orientation, set a unique text
            if (setnumtxtbox2.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                //PHONE IS PORTRAIT
                numtxtbox2.text = "1P"

            }else{
                numtxtbox2.text = "2L"
            }
        }


        //On click for edit text case
        setEntryBox.setOnClickListener {

            //set the entry box to the text
            entryBox.text = entryBox.text
            //do a toast of the data (to show change)
            val toast = Toast.makeText(this, "You typed ${entryBox.text}", Toast.LENGTH_SHORT) // in Activity
            toast.show()

        }

        //HIT RANDOM
        btnPushRandom.setOnClickListener {
            //generate a random number
            val randomNum = Random.nextInt(0, 250) //from 0 - 250, cause why not 250

            //set the text to it
            randomOutput.text = randomNum.toString()
        }

    }
    //Instance Methods
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved_orient_text", txtbox1.text.toString())
        outState.putString("saved_CoolInt_text", numtxtbox2.text.toString())
        outState.putString("saved_Custom_text", entryBox.text.toString())
        outState.putString("saved_Random_txt", randomOutput.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        txtbox1.text = savedInstanceState.getString("saved_orient_text")
        numtxtbox2.text = savedInstanceState.getString("saved_CoolInt_text")
        entryBox.setText(savedInstanceState.getString("saved_Custom_text"))
        randomOutput.setText(savedInstanceState.getString("saved_Random_txt").toString())
    }
}