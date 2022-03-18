package com.radenmas.trendsmarketplace.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.adapter.ProductAdapter;
import com.radenmas.trendsmarketplace.model.ProductModel;
import com.radenmas.trendsmarketplace.network.Config;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class TestAct extends AppCompatActivity {

    private RecyclerView recycler;
    private ProductAdapter adapter;
    private ArrayList<ProductModel> productModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.act_test);

        recycler = findViewById(R.id.recycler);

        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductAdapter(productModels, this);
        recycler.setAdapter(adapter);

        Content content = new Content();
        content.execute();
    }


    private class Content extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String url = Config.BLIBLI;
                Document doc = Jsoup.connect(url).get();

                Elements data = doc.select("div.trending__content");
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    String imgUrl = data.select("trending__item-preview")
                            .select("img")
                            .eq(i)
                            .attr("src");

                    String title = data.select("span.trending__item-name")
                            .select("span")
                            .eq(i)
                            .text();

//                    String desc = data.select("div.css-1ksb19c")
//                            .eq(i)
//                            .text();
//
//                    String urll = data.select("div.css-zimbi")
//                            .select("a")
//                            .eq(i)
//                            .attr("href");
                    productModels.add(new ProductModel(title, title, imgUrl, title));

                }
                Log.e("TITLE", String.valueOf(data));

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }


    /*
    private class Content extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String url = "https://www.cinemaqatar.com";
                Document doc = Jsoup.connect(url).get();

                Elements data = doc.select("span.thumbnail");
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    String imgUrl = data.select("span.thumbnail")
                            .select("img")
                            .eq(i)
                            .attr("src");

                    String title = data.select("h4.gridminfotitle")
                            .select("span")
                            .eq(i)
                            .text();

                    String desc = data.select("p.gridminfo")
                            .eq(i)
                            .text();

                    String urll = data.select("a.btnmain")
                            .select("a")
                            .eq(i)
                            .attr("href");
                    productModels.add(new ProductModel(urll, desc, imgUrl, urll));
                    Log.d("TITLE", imgUrl);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
     */

}