package com.mikkyboy.devmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    private var mDevelopersList: ArrayList<Developer> = ArrayList<Developer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val devId = intent.getIntExtra("devId", -1)

        mDevelopersList = Constants.getDevelopers()

        val icBack: ImageView = findViewById<View>(R.id.ic_details_back) as ImageView
        val tvDetailCodeName = findViewById<View>(R.id.tv_detail_code_name) as TextView
        val tvDetailStack = findViewById<View>(R.id.tv_detail_stack) as TextView
        val tvDetailExperience = findViewById<View>(R.id.tv_detail_experience) as TextView
        val tvDetailTools = findViewById<View>(R.id.tv_detail_tools) as TextView

        tvDetailCodeName.text = mDevelopersList[devId - 1].codeName
        tvDetailStack.text = mDevelopersList[devId - 1].stack
        tvDetailExperience.text = mDevelopersList[devId - 1].experience
        tvDetailTools.text = mDevelopersList[devId - 1].tools

        icBack.setOnClickListener {
            println("Back")
            finish()
        }
    }
}