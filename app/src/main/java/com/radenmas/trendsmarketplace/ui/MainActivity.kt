package com.radenmas.trendsmarketplace.ui

import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.radenmas.trendsmarketplace.R
import com.radenmas.trendsmarketplace.databinding.ActivityMainBinding

/**
 * Created by RadenMas on 28/03/2022.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        setContentView(binding.root)

        initView()
        onClick()
    }

    private fun onClick() {
        binding.imgAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        binding.imgLogout.setOnClickListener {
            dialogLogout()
        }
        binding.rlRisetData.setOnClickListener {
            startActivity(Intent(this, RisetDataActivity::class.java))
        }
        binding.rlTokopedia.setOnClickListener {
            startActivity(Intent(this, TokopediaActivity::class.java))
        }
        binding.rlShopee.setOnClickListener {
            startActivity(Intent(this, ShopeeActivity::class.java))
        }
        binding.rlBlibli.setOnClickListener {
            startActivity(Intent(this, BlibliActivity::class.java))
        }
        binding.rlGuide.setOnClickListener {
            startActivity(
                Intent(this, GuideActivity::class.java)
            )
        }
    }

    private fun initView() {

    }

    private fun dialogLogout() {
        val dialog = Dialog(this, R.style.DialogStyle)
        dialog.setContentView(R.layout.dialog_logout)
        dialog.window!!.setBackgroundDrawableResource(R.drawable.bg_dialog)
        val btnYes = dialog.findViewById<MaterialButton>(R.id.btnYes)
        val btnNo = dialog.findViewById<MaterialButton>(R.id.btnNo)
        btnYes.setOnClickListener {
            finish()
        }
        btnNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}