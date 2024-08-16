package com.ghani.mehndidesign.offline2023.simple;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.ghani.mehndidesign.offline2023.simple.Adapter.BhandAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Bhand extends AppCompatActivity {

    private AssetManager assetManager;
    ArrayList<Bitmap> bitmapList;
    BhandAdapter adapter;
    private static final String TAG = "Bhand";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhand);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_bhand);
        setSupportActionBar(toolbar);

        GridView gridView = findViewById(R.id.bhand_grid);

        assetManager = getAssets();

        bitmapList = new ArrayList<>();

        try {

            listAllImages();

        }catch (Exception e){

            e.printStackTrace();
        }

        try {

            adapter = new BhandAdapter(Bhand.this, bitmapList);
            gridView.setAdapter(adapter);
        }catch (Exception e){

            e.printStackTrace();
        }

        toolbar.setNavigationOnClickListener(v -> {

            Bhand.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                Bhand.this.finish();
            }
        });
    }

    public void listAllImages() {

        Bitmap bitmap;

        try {

            String[] imgPath = assetManager.list("bhand");
            if (imgPath != null) {
                for (String s : imgPath) {

                    InputStream is = assetManager.open("bhand/" + s);
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