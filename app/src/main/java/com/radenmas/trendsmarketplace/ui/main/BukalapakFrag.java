package com.radenmas.trendsmarketplace.ui.main;

import android.view.View;
import android.webkit.WebView;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.base.BaseFragment;

public class BukalapakFrag extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.frag_bukalapak;
    }

    @Override
    protected void myCodeHere(View view) {
        WebView webViewBukalapak = view.findViewById(R.id.webViewBukalapak);
        webViewBukalapak.loadUrl("https://www.bukalapak.com/c/fashion-pria/kemeja?");
        webViewBukalapak.getSettings().setLoadsImagesAutomatically(true);
        webViewBukalapak.getSettings().setJavaScriptEnabled(true);
        webViewBukalapak.getSettings().setDomStorageEnabled(true);
    }
}
