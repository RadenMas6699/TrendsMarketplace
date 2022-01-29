package com.radenmas.trendsmarketplace.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.radenmas.trendsmarketplace.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test);

//        Document document = Jsoup.connect("https://shopee.co.id/Pakaian-Pria-cat.11042849").timeout(6000).get();
//        Elements body = document.select("div.row shopee-search-item-result__items");
//        Toast.makeText(this, "" + body.select("div.col-xs-2-4 shopee-search-item-result__item").size(), Toast.LENGTH_SHORT).show();

    }
}