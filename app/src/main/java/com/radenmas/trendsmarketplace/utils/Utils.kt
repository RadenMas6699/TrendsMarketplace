/*
 * Created by RadenMas on 21/3/2022.
 * Copyright (c) 2022.
 */

package com.radenmas.trendsmarketplace.utils

import android.app.Dialog
import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.radenmas.trendsmarketplace.R

/**
 * Created by RadenMas on 21/03/2022.
 */
object Utils {
    private lateinit var progress: Dialog

    fun showLoading(context: Context) {
        progress = Dialog(context)
        progress.setContentView(R.layout.dialog_progress)
        progress.window!!.setBackgroundDrawableResource(R.drawable.bg_progress)
        progress.show()
    }

    fun dismissLoading() {
        progress.dismiss()
    }

    fun formatComma1(value: Float): String {
        return "%.1f".format(value)
    }

    fun formatNumber(value: Int): String {
        return String.format("%,d", value)
    }

    fun formatRupiah(value: Int): String {
        val number: String =
            String.format("%,d", value)
        return "Rp$number"
    }

    fun snack(view: View, msg: String) {
        Snackbar.make(
            view,
            msg,
            Snackbar.LENGTH_LONG
        ).show()
    }
}