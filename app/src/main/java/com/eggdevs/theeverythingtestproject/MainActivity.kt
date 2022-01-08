package com.eggdevs.theeverythingtestproject

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn).setOnClickListener {
            sendSomething()
        }
    }

    private fun sendSomething() {

        val intent = Intent(Intent.ACTION_SEND)
        intent.apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "https://www.google.com a message to remember")
        }
        val myPendingIntent = PendingIntent.getBroadcast(
            this,
            100,
            Intent(this@MainActivity, MyBroadCastReceiver::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val chooser = Intent.createChooser(
            intent, "Ayush is sharing something....",
            myPendingIntent.intentSender
        )

        startActivity(chooser)
    }
}