package com.radenmas.trendsmarketplace.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.radenmas.trendsmarketplace.R
import com.radenmas.trendsmarketplace.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var b: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAboutBinding.inflate(layoutInflater)
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
        val versionName = packageManager.getPackageInfo(packageName, 0).versionName
        b.tvAppVersion.text = resources.getString(R.string.app_version, versionName)
    }
}