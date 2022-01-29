package com.radenmas.trendsmarketplace.ui.main;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.base.BaseActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainAct extends BaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.act_main;
    }

    @Override
    protected void myCodeHere() {






        getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new HomeFrag()).commit();

        BottomNavigationView navAdmin = findViewById(R.id.navBottom);
        navAdmin.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navHome:
                    selectedFragment = new HomeFrag();
                    break;
                case R.id.navTokopedia:
                    selectedFragment = new TokopediaFrag();
                    break;
                case R.id.navShopee:
                    selectedFragment = new ShopeeFrag();
                    break;
                case R.id.navBukalapak:
                    selectedFragment = new BukalapakFrag();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, selectedFragment).commit();
            return true;
        });
    }
}