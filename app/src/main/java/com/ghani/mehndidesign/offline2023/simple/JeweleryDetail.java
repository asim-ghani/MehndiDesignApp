package com.ghani.mehndidesign.offline2023.simple;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ghani.mehndidesign.offline2023.simple.Adapter.JeweleryAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.JeweleryPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class JeweleryDetail extends AppCompatActivity {

    ViewPager viewPager;
    JeweleryPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewelery_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_jew_det);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.jewelery_pager);

        ArrayList<Bitmap> images = new ArrayList<>(JeweleryAdapter.imgArray);

        adapter = new JeweleryPagerAdapter(JeweleryDetail.this, images);

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.containsKey("pos"))
        {
            int position = getIntent().getExtras().getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }

        toolbar.setNavigationOnClickListener(v -> {

            JeweleryDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                JeweleryDetail.this.finish();
            }
        });

    }

}