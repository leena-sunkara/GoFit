package com.masai.gofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.splash_screen.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        CoroutineScope(Dispatchers.IO).launch {
            delayActivity()
        }
        logo_layout.setOnClickListener {
            startActivity(Intent(this, FeaturesActivity::class.java))
        }
    }

    private suspend fun delayActivity() {
        delay(3000)
        startActivity(Intent(this, FeaturesActivity::class.java))
    }
}