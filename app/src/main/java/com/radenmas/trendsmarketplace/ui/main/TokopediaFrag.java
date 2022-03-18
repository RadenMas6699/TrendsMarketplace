package com.radenmas.trendsmarketplace.ui.main;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebView;
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

        WebView webViewTokopedia = view.findViewById(R.id.webViewTokopedia);
        webViewTokopedia.loadUrl(Config.URL_TOKOPEDIA);
        webViewTokopedia.getSettings().setJavaScriptEnabled(true);
    }
}
