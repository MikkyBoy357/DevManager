package com.mikkyboy.devmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // App Actions
    private val TAG = "DevManager"
    private var KEY = ""
    private var NAME = ""

    var developersList = Constants.getDevelopers()
    val adapter = DeveloperAdapter(developersList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Logging for troubleshooting purposes
        logIntent(intent)

        // RecyclerView
        val rvDevelopers: RecyclerView = findViewById<View>(R.id.rvDevelopers) as RecyclerView

        rvDevelopers.adapter = adapter
        rvDevelopers.layoutManager = LinearLayoutManager(this)

        val icAdd: ImageView = findViewById(R.id.ic_add)

        val btnAddDev: Button = findViewById(R.id.btnAddDev)
        val etDev: EditText = findViewById(R.id.etDev)
        icAdd.setOnClickListener {
            println("EDIT SCREEN")
            val intent: Intent = Intent(this, EditActivity::class.java)
            intent.putExtra("isEdit", true)
            intent.putExtra("devId", 1)
            startActivity(intent)
        }

        btnAddDev.setOnClickListener {
            if (etDev.text.isNotEmpty()) {
                val newDev: Developer = Developer(
                    developersList.size + 1,
                    etDev.text.toString(),
                    "Mobile",
                    "2 Years",
                    "Android, Flutter, Dart, Kotlin",
                )
                developersList.add(newDev)
                adapter.notifyItemInserted(developersList.size - 1)
                etDev.text.clear()
            } else {
                println("Empty Field")
            }
        }

        // GET_THING
        println("INTENT => $KEY")
        if (KEY == "q") {
            println("GET_THING")

            val result = developersList.singleOrNull {
                println("DEV SEARCH")
                println("NAME => $NAME")
                println("KEYWORD => ${it.codeName}")
                it.codeName.lowercase() == NAME.lowercase()
            }

            if (result != null) {
                println("FOUND")
                println("DevId => ${result.id}")

                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("devId", result.id)
                startActivity(intent)
            } else {
                println("NOT FOUND")

                val intent = Intent(this, NotFoundActivity::class.java)
                startActivity(intent)
            }


        } else if (KEY == "feature") {
            println("OPEN_APP")
        } else {
            println("NEUTRAL_INTENT")
        }

//        val editButton = findViewById<View>(R.id.btn_edit)
//        val detailsButton = findViewById<View>(R.id.btn_details)

//        editButton.setOnClickListener {
//            println("Edit Screen")
//            val intent: Intent = Intent(this, EditActivity::class.java)
//            startActivity(intent)
//        }
//
//        detailsButton.setOnClickListener {
//            for (dev in developersList) {
//                println(dev.codeName)
//            }
//            println("Details Screen")
//            val intent: Intent = Intent(this, DetailsActivity::class.java)
//            startActivity(intent)
//        }
    }

    fun logIntent(intent: Intent) {
        val bundle: Bundle = intent.extras ?: return

        Log.d(TAG, "======= logIntent ========= %s")
        Log.d(TAG, "Logging intent data start")

        bundle.keySet().forEach { key ->
            Log.d("YO", "[$key=${bundle.get(key)}]")
            KEY = bundle.keySet().first()
            NAME = "${bundle.get(bundle.keySet().first())}"
            println("LOL => $KEY")
            println("LOL => $NAME")
        }

        Log.d(TAG, "Logging intent data complete")
    }


}