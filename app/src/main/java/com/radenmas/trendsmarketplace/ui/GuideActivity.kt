package com.radenmas.trendsmarketplace.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.radenmas.trendsmarketplace.databinding.ActivityGuideBinding

/**
 * Created by RadenMas on 28/03/2022.
 */
class GuideActivity : AppCompatActivity() {

    private lateinit var b: ActivityGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityGuideBinding.inflate(layoutInflater)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        setContentView(b.root)

        initView()
        onClick()
    }

    private fun onClick() {
        // fungsi untuk kembali
        b.imgBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initView() {

    }
}