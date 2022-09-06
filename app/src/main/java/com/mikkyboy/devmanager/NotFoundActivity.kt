package com.mikkyboy.devmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NotFoundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_found)

        val btn404Back = findViewById<View>(R.id.btn_404_back)

        btn404Back.setOnClickListener {
            finish()
        }
    }
}