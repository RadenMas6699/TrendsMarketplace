package com.radenmas.trendsmarketplace.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.radenmas.trendsmarketplace.databinding.ActMainBinding;
import com.radenmas.trendsmarketplace.databinding.ActivityTokopediaBinding;
import com.radenmas.trendsmarketplace.network.Config;

/**
 * Created by RadenMas on 28/03/2022.
 */
public class TokopediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTokopediaBinding b = ActivityTokopediaBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(v);

        b.imgBack.setOnClickListener(view -> {
            onBackPressed();
        });

        WebSettings settings = b.webViewTokopedia.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setAppCacheEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.setSafeBrowsingEnabled(true);
        }

        b.webViewTokopedia.setWebViewClient(new WebViewClient());
        b.webViewTokopedia.setWebChromeClient(new WebChromeClient());
        b.webViewTokopedia.loadUrl(Config.URL_TOKOPEDIA);
    }
}
