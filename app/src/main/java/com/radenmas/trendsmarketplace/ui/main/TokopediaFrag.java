package com.radenmas.trendsmarketplace.ui.main;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.base.BaseFragment;
import com.radenmas.trendsmarketplace.network.Config;

public class TokopediaFrag extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.frag_tokopedia;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void myCodeHere(View view) {

        ImageView imgBack = view.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view1 -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new HomeFrag()).commit());

        WebView webView = view.findViewById(R.id.webViewTokopedia);

        WebSettings settings = webView.getSettings();
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

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(Config.URL_TOKOPEDIA);
    }
}
