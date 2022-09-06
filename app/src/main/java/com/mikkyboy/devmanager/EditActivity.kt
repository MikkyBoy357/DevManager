package com.mikkyboy.devmanager

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class EditActivity : AppCompatActivity() {
    private var mDevelopersList: ArrayList<Developer> = ArrayList<Developer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val isEdit = intent.getBooleanExtra("isEdit", false)
        val devId = intent.getIntExtra("devId", -1)

        mDevelopersList = Constants.getDevelopers()

        val icBack: ImageView = findViewById<View>(R.id.ic_edit_back) as ImageView
        val editCodeName: EditText = findViewById(R.id.edit_code_name)
        val editStack: EditText = findViewById(R.id.edit_stack)
        val editExperience: EditText = findViewById(R.id.edit_experience)
        val editTools: EditText = findViewById(R.id.edit_tools)
        val btnSave: Button = findViewById<View>(R.id.btn_save) as Button

        if (isEdit) {
            val currentDev = getDevDetails(devId)
            editCodeName.append(currentDev.codeName)
            editStack.append(currentDev.stack)
            editExperience.append(currentDev.experience)
            editTools.append(currentDev.tools)
        } else {
            editCodeName.text.clear()
            editStack.text.clear()
            editExperience.text.clear()
            editTools.text.clear()
        }
        icBack.setOnClickListener {
            println("Back")
            println(devId.toString())
            finish()
        }

        btnSave.setOnClickListener {
            if (editCodeName.text.isNotEmpty() && editStack.text.isNotEmpty() && editExperience.text.isNotEmpty() && editTools.text.isNotEmpty()) {
                if (isEdit) {
                    println("EDIT!")
                    editDetails(
                        devId = devId,
                        codeName = editCodeName.text.toString(),
                        stack = editStack.text.toString(),
                        experience = editExperience.text.toString(),
                        tools = editTools.text.toString(),
                    )
                } else {
                    println("SAVE!")
                }
                finish()
            } else {
                Toast.makeText(this, "INVALID FIELDS", Toast.LENGTH_LONG).show()
                println("INVALID FIELDS!")
            }
        }
    }

    private fun editDetails(
        devId: Int,
        codeName: String,
        stack: String,
        experience: String,
        tools: String,
    ) {
        mDevelopersList[devId - 1].codeName = codeName
        mDevelopersList[devId - 1].stack = stack
        mDevelopersList[devId - 1].experience = experience
        mDevelopersList[devId - 1].tools = tools

        MainActivity().developersList[devId - 1].tools = tools
        MainActivity().developersList[devId - 1].stack = stack
        MainActivity().developersList[devId - 1].experience = experience
        MainActivity().developersList[devId - 1].tools = tools
        MainActivity().adapter.notifyItemInserted(devId - 1)
    }

    private fun getDevDetails(devId: Int): Developer {
        var devs: ArrayList<Developer> = Constants.getDevelopers()
        return Developer(
            devId,
            devs[devId - 1].codeName,
            devs[devId - 1].stack,
            devs[devId - 1].experience,
            devs[devId - 1].tools,
        )
    }
}

