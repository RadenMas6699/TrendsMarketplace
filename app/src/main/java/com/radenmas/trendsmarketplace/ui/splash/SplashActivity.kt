package com.radenmas.trendsmarketplace.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.radenmas.trendsmarketplace.databinding.ActivitySplashBinding
import com.radenmas.trendsmarketplace.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        setContentView(binding.root)

        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
//            startActivity(Intent(this, BlibliActivity::class.java))
//            startActivity(Intent(this, ShopeeActivity::class.java))
//            startActivity(Intent(this, TokopediaActivityKotlin::class.java))
            finish()
        }, 1000)
    }
}