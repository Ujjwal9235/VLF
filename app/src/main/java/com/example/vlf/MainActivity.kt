package com.example.vlf

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var splashProgress: ProgressBar? = null
    var SPLASH_TIME = 3000 //This is 3 seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This is additional feature, used to run a progress bar
//        splashProgress = findViewById(R.id.splashProgress)
//        playProgress()

        //Code to start timer and take action after the timer ends
        Handler(mainLooper).postDelayed({ //Do any action here. Now we are moving to next page
            val mySuperIntent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(mySuperIntent)

            //This 'finish()' is for exiting the app when back button pressed from Home page which is ActivityHome
            finish()
        }, SPLASH_TIME.toLong())
    }

    //Method to run progress bar for 5 seconds
    private fun playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
            .setDuration(5000)
            .start()
    }
}


