package com.radenmas.trendsmarketplace.ui.main;

import android.view.View;
import android.webkit.WebView;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.base.BaseFragment;

public class ShopeeFrag extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.frag_shopee;
    }

    @Override
    protected void myCodeHere(View view) {
        WebView webViewShopee = view.findViewById(R.id.webViewShopee);
        webViewShopee.loadUrl("https://shopee.co.id/Pakaian-Pria-cat.11042849?page=0&sortBy=pop");
        webViewShopee.getSettings().setLoadsImagesAutomatically(true);
        webViewShopee.getSettings().setJavaScriptEnabled(true);
        webViewShopee.getSettings().setDomStorageEnabled(true);
    }
}
