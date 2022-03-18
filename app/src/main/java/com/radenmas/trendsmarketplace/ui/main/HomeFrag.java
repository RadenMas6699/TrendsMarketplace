package com.radenmas.trendsmarketplace.ui.main;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.databinding.FragHomeBinding;

public class HomeFrag extends Fragment {
    private FragHomeBinding b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragHomeBinding.inflate(inflater,container,false);
        View v = b.getRoot();
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        onClick();

        return v;
    }

    private void onClick() {
        b.imgHelp.setOnClickListener(view -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new HelpFrag()).commit();
        });

        b.imgLogout.setOnClickListener(view -> {
            dialogLogout();
        });

        b.cardRisetData.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Riset Data", Toast.LENGTH_SHORT).show();
        });

        b.cardTokopedia.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Tokopedia", Toast.LENGTH_SHORT).show();
        });

        b.cardShopee.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Shopee", Toast.LENGTH_SHORT).show();
        });

        b.cardBlibli.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Blibli", Toast.LENGTH_SHORT).show();
        });
    }

    private void dialogLogout(){
        Dialog dialog = new Dialog(getContext(), R.style.DialogStyle);
        dialog.setContentView(R.layout.dialog_logout);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog);

        MaterialButton btnYes = dialog.findViewById(R.id.btnYes);
        MaterialButton btnNo = dialog.findViewById(R.id.btnNo);

        btnYes.setOnClickListener(view1 -> {
            getActivity().finish();
        });
        btnNo.setOnClickListener(view1 -> {
            dialog.dismiss();
        });

        dialog.show();
    }
}
