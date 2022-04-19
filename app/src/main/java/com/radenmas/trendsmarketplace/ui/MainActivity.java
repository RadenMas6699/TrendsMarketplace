package com.radenmas.trendsmarketplace.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.databinding.ActivityMainBinding;

/**
 * Created by RadenMas on 28/03/2022.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(v);

        onClick();
    }

    private void onClick() {
        b.imgAbout.setOnClickListener(view -> {
            startActivity(new Intent(this, AboutActivity.class));
        });
        b.imgLogout.setOnClickListener(view -> {
            dialogLogout();
        });
        b.rlRisetData.setOnClickListener(view -> {
            startActivity(new Intent(this, RisetDataActivity.class));
        });
        b.rlTokopedia.setOnClickListener(view -> {
            startActivity(new Intent(this, TokopediaActivity.class));
        });
        b.rlShopee.setOnClickListener(view -> {
            startActivity(new Intent(this, ShopeeActivity.class));
        });
        b.rlBlibli.setOnClickListener(view -> {
            startActivity(new Intent(this, BlibliActivity.class));
        });
        b.rlGuide.setOnClickListener(view -> {
            startActivity(new Intent(this, GuideActivity.class));
        });
    }

    private void dialogLogout() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.dialog_logout);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog);

        MaterialButton btnYes = dialog.findViewById(R.id.btnYes);
        MaterialButton btnNo = dialog.findViewById(R.id.btnNo);

        btnYes.setOnClickListener(view1 -> {
            finish();
        });
        btnNo.setOnClickListener(view1 -> {
            dialog.dismiss();
        });

        dialog.show();
    }
}
