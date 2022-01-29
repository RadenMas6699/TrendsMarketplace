package com.radenmas.trendsmarketplace.ui.main;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.base.BaseFragment;
import com.radenmas.trendsmarketplace.ui.help.HelpAct;

public class HomeFrag extends BaseFragment {
    private ImageView imgHelp, imgLogout;

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_home;
    }

    @Override
    protected void myCodeHere(View view) {
        initView(view);
        onClick();
    }

    private void onClick() {
        imgHelp.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), HelpAct.class));
        });

        imgLogout.setOnClickListener(view -> {
            Dialog dialog = new Dialog(getContext(), R.style.DialogStyle);
            dialog.setContentView(R.layout.dialog_logout);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_dialog);

            MaterialButton btnYes = dialog.findViewById(R.id.btnYes);
            MaterialButton btnNo = dialog.findViewById(R.id.btnNo);

            btnYes.setOnClickListener(view1 -> {

            });
            btnNo.setOnClickListener(view1 -> {
                dialog.dismiss();
            });

            dialog.show();
        });
    }

    private void initView(View view) {
        imgHelp = view.findViewById(R.id.imgHelp);
        imgLogout = view.findViewById(R.id.imgLogout);
    }
}
