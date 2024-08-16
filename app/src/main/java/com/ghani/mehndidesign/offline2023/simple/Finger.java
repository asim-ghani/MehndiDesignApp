package com.ghani.mehndidesign.offline2023.simple;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.ghani.mehndidesign.offline2023.simple.Adapter.FingerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Finger extends AppCompatActivity {

    private AssetManager assetManager;
    ArrayList<Bitmap> bitmapList;
    FingerAdapter adapter;
    private static final String TAG = "Finger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_finger);
        setSupportActionBar(toolbar);


        GridView gridView = findViewById(R.id.finger_grid);

        assetManager = getAssets();

        bitmapList = new ArrayList<>();

        try {

            listAllImages();

        }catch (Exception e){

            e.printStackTrace();
        }

        try {

            adapter = new FingerAdapter(Finger.this, bitmapList);
            gridView.setAdapter(adapter);
        }catch (Exception e){

            e.printStackTrace();
        }

        toolbar.setNavigationOnClickListener(v -> Finger.this.finish());

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Finger.this.finish();
            }
        });
    }

    public void listAllImages() {

        Bitmap bitmap;

        try {

            String[] imgPath = assetManager.list("fing");
            if (imgPath != null) {
                for (String s : imgPath) {

                    InputStream is = assetManager.open("fing/" + s);
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