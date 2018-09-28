package jp.ginyolith.androiduisandbox

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lottie = findViewById<LottieAnimationView>(R.id.lottie)

    }
}
