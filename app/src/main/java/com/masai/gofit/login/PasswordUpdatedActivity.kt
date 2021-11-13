package com.masai.gofit.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai.gofit.R
import kotlinx.android.synthetic.main.activity_password_updated.*
import kotlinx.android.synthetic.main.activity_password_updated.backArrow

class PasswordUpdatedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_updated)

        backArrow.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnLoginPasswordUpdated.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}