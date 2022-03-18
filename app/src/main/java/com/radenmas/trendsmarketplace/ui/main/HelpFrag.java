package com.radenmas.trendsmarketplace.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.databinding.FragHelpBinding;
import com.radenmas.trendsmarketplace.ui.main.HomeFrag;

public class HelpFrag extends Fragment {
    private FragHelpBinding b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragHelpBinding.inflate(inflater,container,false);
        View v = b.getRoot();
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        onClick();

        return v;
    }

    private void onClick() {
        b.imgBack.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentMain, new HomeFrag()).commit();
        });
    }
}
