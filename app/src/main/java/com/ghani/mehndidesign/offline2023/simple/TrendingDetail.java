package com.ghani.mehndidesign.offline2023.simple;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.ghani.mehndidesign.offline2023.simple.Adapter.TrendingAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.ViewPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;


public class TrendingDetail extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_trend_det);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.img_pager);

        ArrayList<Bitmap> images = new ArrayList<>(TrendingAdapter.imgArray);


        adapter = new ViewPagerAdapter(TrendingDetail.this, images);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey("pos"))
        {
            int position = bundle.getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }

        toolbar.setNavigationOnClickListener(v -> {

            TrendingDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                TrendingDetail.this.finish();
            }
        });

    }

}