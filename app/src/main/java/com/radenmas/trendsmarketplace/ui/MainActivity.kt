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

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        setContentView(b.root)

        initView()
        onClick()
    }

    private fun onClick() {
        // fungsi untuk membuka info aplikasi
        b.imgAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        // fungsi untuk tombol logout
        b.imgLogout.setOnClickListener {
            dialogLogout()
        }

        // fungsi untuk membuka menu riset data
        b.rlRisetData.setOnClickListener {
            startActivity(Intent(this, RisetDataActivity::class.java))
        }

        // fungsi untuk membuka menu tokopedia
        b.rlTokopedia.setOnClickListener {
            startActivity(Intent(this, TokopediaActivity::class.java))
        }

        // fungsi untuk membuka menu shopee
        b.rlShopee.setOnClickListener {
            startActivity(Intent(this, ShopeeActivity::class.java))
        }

        // fungsi untuk membuka menu blibli
        b.rlBlibli.setOnClickListener {
            startActivity(Intent(this, BlibliActivity::class.java))
        }

        // fungsi untuk membuka menu panduan aplikasi
        b.rlGuide.setOnClickListener {
            startActivity(
                Intent(this, GuideActivity::class.java)
            )
        }
    }

    private fun initView() {

    }

    private fun dialogLogout() {
        // tampilan popup ketika akan keluar
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