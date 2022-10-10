package com.radenmas.trendsmarketplace.ui.riset

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.radenmas.trendsmarketplace.databinding.ActivityDataRisetBinding

/**
 * Created by RadenMas on 28/03/2022.
 */
class RisetDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataRisetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataRisetBinding.inflate(layoutInflater)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        setContentView(binding.root)

        initView()
        onClick()
    }

    private fun onClick() {
        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initView() {

    }
}