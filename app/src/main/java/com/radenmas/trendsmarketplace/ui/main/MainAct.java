package com.radenmas.trendsmarketplace.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.databinding.ActMainBinding;

public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActMainBinding b = ActMainBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        setContentView(v);

        getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new HomeFrag()).commit();

    }
}