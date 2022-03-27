package com.radenmas.trendsmarketplace.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.radenmas.trendsmarketplace.databinding.ActivityGuideBinding;

/**
 * Created by RadenMas on 28/03/2022.
 */
public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGuideBinding b = ActivityGuideBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(v);

        b.imgBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }
}
