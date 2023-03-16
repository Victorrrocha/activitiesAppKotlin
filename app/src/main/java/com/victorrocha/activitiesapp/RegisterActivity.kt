package com.victorrocha.activitiesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            val homePage = Intent(this, MainActivity::class.java)
            startActivity(homePage)
            finish()
        }

        val btnGoToLogin = findViewById<Button>(R.id.btnGotoLogin)
        btnGoToLogin.setOnClickListener {
            val login = Intent(this, RegisterActivity::class.java)
            startActivity(login)
            finish()
        }
    }
}