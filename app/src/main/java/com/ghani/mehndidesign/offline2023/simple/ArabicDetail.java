package com.ghani.mehndidesign.offline2023.simple;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ghani.mehndidesign.offline2023.simple.Adapter.ArabicAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.ArabicPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class ArabicDetail extends AppCompatActivity {

    ViewPager viewPager;
    ArabicPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_arabic_det);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> {

            ArabicDetail.this.finish();
        });

        viewPager = findViewById(R.id.arabic_pager);

        ArrayList<Bitmap> images = new ArrayList<>(ArabicAdapter.imgArray);

        adapter = new ArabicPagerAdapter(ArabicDetail.this, images);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("pos"))
        {
            int position = extras.getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                ArabicDetail.this.finish();
            }
        });
    }
}