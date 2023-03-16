package com.victorrocha.activitiesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var activityAdapter: ActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityAdapter = ActivityAdapter(mutableListOf())

        rvActivityItems.adapter = activityAdapter
        rvActivityItems.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val activityTitle = etActivityTitle.text.toString()
            if (activityTitle.isNotEmpty()) {
                val activity = Activity(activityTitle)
                activityAdapter.addActivity(activity)
                etActivityTitle.text.clear()
            }
        }
        btnClearDone.setOnClickListener {
            activityAdapter.deleteDoneTodos()
        }

        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            val login = Intent(this, LoginActivity::class.java)
            startActivity(login)
            finish()
        }
    }
}