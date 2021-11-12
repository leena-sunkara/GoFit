package com.masai.gofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        update.setOnClickListener {
            val newPassword = new_password.text.toString()
            startActivity(Intent(this, PasswordUpdatedActivity::class.java))
        }
    }
}