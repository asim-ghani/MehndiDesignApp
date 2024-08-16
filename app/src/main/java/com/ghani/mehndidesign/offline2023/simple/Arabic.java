package com.ghani.mehndidesign.offline2023.simple;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.ghani.mehndidesign.offline2023.simple.Adapter.ArabicAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Arabic extends AppCompatActivity {

    private AssetManager assetManager;
    ArrayList<Bitmap> bitmapList;
    ArabicAdapter adapter;
    private static final String TAG = "Eid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_arabic);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> {

            Arabic.this.finish();
        });

        GridView gridView = findViewById(R.id.arabic_grid);

        assetManager = getAssets();

        bitmapList = new ArrayList<>();


        try {

            listAllImages();

        }catch (Exception e){

            e.printStackTrace();
        }

        try {

            adapter = new ArabicAdapter(Arabic.this, bitmapList);
            gridView.setAdapter(adapter);
        }catch (Exception e){

            e.printStackTrace();
        }

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                Arabic.this.finish();
            }
        });
    }

    public void listAllImages() {

        Bitmap bitmap;

        try {

            String[] imgPath = assetManager.list("arabic");
            if (imgPath != null) {
                for (String s : imgPath) {

                    InputStream is = assetManager.open("arabic/" + s);
                    Log.d(TAG, s);
                    bitmap = BitmapFactory.decodeStream(is);
                    bitmapList.add(bitmap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}