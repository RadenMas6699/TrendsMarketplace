package com.radenmas.trendsmarketplace.ui.main;

import android.view.View;
import android.webkit.WebView;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.base.BaseFragment;
import com.radenmas.trendsmarketplace.network.Config;

public class TokopediaFrag extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.frag_tokopedia;
    }

    @Override
    protected void myCodeHere(View view) {
        WebView webViewTokopedia = view.findViewById(R.id.webViewTokopedia);
//        webViewTokopedia.loadUrl("https://www.tokopedia.com/p/fashion-pria/jeans-denim-pria/kemeja-denim-pria?ob=5&page=1");
//        webViewTokopedia.loadUrl("https://tokopedia.link/BliGvAAD9mb");
//        webViewTokopedia.getSettings().setLoadsImagesAutomatically(true);
//        webViewTokopedia.getSettings().setJavaScriptEnabled(true);
//        webViewTokopedia.getSettings().setDomStorageEnabled(true);

        webViewTokopedia.loadUrl(Config.URL_TOKOPEDIA);
        webViewTokopedia.getSettings().setJavaScriptEnabled(true);
    }
}
