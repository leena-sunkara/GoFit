package com.masai.gofit.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai.gofit.R
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        backArrow.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnUpdate.setOnClickListener {
            val newPassword = newPassword.text.toString()
            // Update Password
            startActivity(Intent(this, PasswordUpdatedActivity::class.java))
        }
    }
}