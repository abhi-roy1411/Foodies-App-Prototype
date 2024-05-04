package com.example.foodies.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.foodies.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var appName: TextView
    lateinit var mobileNumber: EditText
    lateinit var appPassword: EditText
    lateinit var loginButton: Button
    lateinit var forgotPassword: TextView
    lateinit var registerHere: TextView

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Log in"

        appName = findViewById(R.id.appName)
        mobileNumber = findViewById(R.id.mobileNumber)
        appPassword = findViewById(R.id.appPassword)
        loginButton = findViewById(R.id.loginButton)
        forgotPassword = findViewById(R.id.forgotPassword)
        registerHere = findViewById(R.id.registerHere)

        loginButton.setOnClickListener{
            val intent =  Intent(this@MainActivity, NewActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onClick(v: View?) {

    }

}