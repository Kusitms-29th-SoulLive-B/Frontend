package com.example.soullive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.soullive.verify_result_go.VerifyResultActivity1
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val backExecutor: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
        val mainExecutor: Executor = ContextCompat.getMainExecutor(this)
        backExecutor.schedule({
            mainExecutor.execute{
                //startActivity(Intent(applicationContext, LogInActivity::class.java))
                //startActivity(Intent(applicationContext, MainActivity::class.java))
                startActivity(Intent(applicationContext, VerifyResultActivity1::class.java))
                finish()
            }
        }, 2, TimeUnit.SECONDS)
    }
}