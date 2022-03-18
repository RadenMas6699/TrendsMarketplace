package com.radenmas.trendsmarketplace.ui.main;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.base.BaseFragment;
import com.radenmas.trendsmarketplace.network.Config;

public class ShopeeFrag extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.frag_shopee;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void myCodeHere(View view) {

        ImageView imgBack = view.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view1 -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new HomeFrag()).commit());

        WebView webViewShopee = view.findViewById(R.id.webViewShopee);
        webViewShopee.loadUrl(Config.URL_SHOPEE);
        webViewShopee.getSettings().setJavaScriptEnabled(true);
    }
}
