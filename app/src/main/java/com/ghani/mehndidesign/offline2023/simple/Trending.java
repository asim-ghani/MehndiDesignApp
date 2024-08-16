package com.ghani.mehndidesign.offline2023.simple;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.ghani.mehndidesign.offline2023.simple.Adapter.TrendingAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Trending extends AppCompatActivity {

    private AssetManager assetManager;
    ArrayList<Bitmap> bitmapList;
    TrendingAdapter adapter;
    private static final String TAG = "Trending";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_trend);
        setSupportActionBar(toolbar);

        GridView gridView = findViewById(R.id.trending_grid);

        assetManager = getAssets();

        bitmapList = new ArrayList<>();

        try {

            listAllImages();

        }catch (Exception e){

            e.printStackTrace();
        }

        try {

            adapter = new TrendingAdapter(Trending.this, bitmapList);
            gridView.setAdapter(adapter);
        }catch (Exception e){

            e.printStackTrace();
        }

        toolbar.setNavigationOnClickListener(v -> Trending.this.finish());

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Trending.this.finish();
            }
        });

    }

    public void listAllImages() {

        Bitmap bitmap;

        try {

            String[] imgPath = assetManager.list("trend");
            assert imgPath != null;
            for (String s : imgPath) {

                InputStream is = assetManager.open("trend/" + s);
                Log.d(TAG, s);
                bitmap = BitmapFactory.decodeStream(is);
                bitmapList.add(bitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}