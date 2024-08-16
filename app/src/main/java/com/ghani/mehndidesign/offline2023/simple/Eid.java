package com.ghani.mehndidesign.offline2023.simple;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import com.ghani.mehndidesign.offline2023.simple.Adapter.EidAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Eid extends AppCompatActivity {

    private AssetManager assetManager;
    ArrayList<Bitmap> bitmapList;
    EidAdapter adapter;
    private static final String TAG = "Eid";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eid);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_eid);
        setSupportActionBar(toolbar);

        GridView gridView = findViewById(R.id.eid_grid);

        assetManager = getAssets();

        bitmapList = new ArrayList<>();

        try {

            listAllImages();

        }catch (Exception e){

            e.printStackTrace();
        }

        try {

            adapter = new EidAdapter(Eid.this, bitmapList);
            gridView.setAdapter(adapter);
        }catch (Exception e){

            e.printStackTrace();
        }

        toolbar.setNavigationOnClickListener(v -> {

            Eid.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                Eid.this.finish();
            }
        });
    }

    public void listAllImages() {

        Bitmap bitmap;

        try {

            String[] imgPath = assetManager.list("eid");
            if (imgPath != null) {
                for (String s : imgPath) {

                    InputStream is = assetManager.open("eid/" + s);
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