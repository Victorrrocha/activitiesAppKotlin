package com.victorrocha.activitiesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val homePage = Intent(this, MainActivity::class.java)
            startActivity(homePage)
            finish()
        }

        val btnGoToRegister = findViewById<Button>(R.id.btnGoToRegister)
        btnGoToRegister.setOnClickListener {
            val register = Intent(this, RegisterActivity::class.java)
            startActivity(register)
            finish()
        }
    }
}