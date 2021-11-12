package com.masai.gofit.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai.gofit.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        CoroutineScope(Dispatchers.IO).launch {
            delayActivity()
        }
    }

    private suspend fun delayActivity() {
        delay(2000)
        startActivity(Intent(this, FeaturesActivity::class.java))
        finish()
    }
}