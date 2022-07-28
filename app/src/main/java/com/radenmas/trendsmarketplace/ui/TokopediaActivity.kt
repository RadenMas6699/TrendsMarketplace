package com.radenmas.trendsmarketplace.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.radenmas.trendsmarketplace.databinding.ActivityTokopediaBinding
import com.radenmas.trendsmarketplace.network.Config

/**
 * Created by RadenMas on 28/03/2022.
 */
class TokopediaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTokopediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTokopediaBinding.inflate(layoutInflater)
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
        binding.etSearchTokopedia.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                /*
                 https://www.tokopedia.com/find/batik-pria-terlaris
                  */

                val textSearch = binding.etSearchTokopedia.text.toString().trim()
                val replaceWith = textSearch.replace(" ", "-")
                binding.etSearchTokopedia.clearFocus()
                binding.webViewTokopedia.loadUrl("https://www.tokopedia.com/find/$replaceWith-terlaris")
            }
            true
        }
    }

    private fun initView() {
        val settings = binding.webViewTokopedia.settings
        settings.javaScriptEnabled = true
        settings.databaseEnabled = true
        settings.userAgentString =
            "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36"
        settings.domStorageEnabled = true
        settings.setGeolocationEnabled(true)
        settings.loadsImagesAutomatically = true
        settings.setAppCacheEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true
        }
        binding.webViewTokopedia.webViewClient = WebViewClient()
        binding.webViewTokopedia.webChromeClient = WebChromeClient()
        binding.webViewTokopedia.loadUrl(Config.URL_TOKOPEDIA)


    }
}