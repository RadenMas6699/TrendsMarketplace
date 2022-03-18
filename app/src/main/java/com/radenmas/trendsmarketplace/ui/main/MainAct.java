package com.radenmas.trendsmarketplace.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.databinding.ActMainBinding;

public class MainAct extends AppCompatActivity {
    private ActMainBinding b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActMainBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        setContentView(v);

        getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new HomeFrag()).commit();

    }


    //    @Override
//    protected int getLayoutResource() {
//        return R.layout.act_main;
//    }
//
//    @Override
//    protected void myCodeHere() {
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new HomeFrag()).commit();
//
//        BottomNavigationView navAdmin = findViewById(R.id.navBottom);
//        navAdmin.setOnNavigationItemSelectedListener(item -> {
//            Fragment selectedFragment = null;
//
//            switch (item.getItemId()) {
//                case R.id.navHome:
//                    selectedFragment = new HomeFrag();
//                    break;
//                case R.id.navTokopedia:
//                    selectedFragment = new TokopediaFrag();
//                    break;
//                case R.id.navShopee:
//                    selectedFragment = new ShopeeFrag();
//                    break;
//                case R.id.navBukalapak:
//                    selectedFragment = new BukalapakFrag();
//                    break;
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, selectedFragment).commit();
//            return true;
//        });
//    }
}