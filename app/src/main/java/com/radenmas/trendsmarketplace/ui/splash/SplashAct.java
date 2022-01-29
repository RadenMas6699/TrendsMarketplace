package com.radenmas.trendsmarketplace.ui.splash;

import android.content.Intent;
import android.os.Handler;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.base.BaseActivity;
import com.radenmas.trendsmarketplace.ui.main.MainAct;

public class SplashAct extends BaseActivity {
    @Override
    protected int getLayoutResource() {
        return R.layout.act_splash;
    }

    @Override
    protected void myCodeHere() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), MainAct.class));
            finish();
        }, 1500);
    }
}
