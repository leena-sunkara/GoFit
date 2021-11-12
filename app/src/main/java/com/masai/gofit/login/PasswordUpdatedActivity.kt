package com.masai.gofit.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai.gofit.R
import kotlinx.android.synthetic.main.activity_password_updated.*

class PasswordUpdatedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_updated)
        login_after_password_update.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}