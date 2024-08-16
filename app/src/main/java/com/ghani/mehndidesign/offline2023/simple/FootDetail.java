package com.ghani.mehndidesign.offline2023.simple;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ghani.mehndidesign.offline2023.simple.Adapter.FootAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.FootPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class FootDetail extends AppCompatActivity {

    ViewPager viewPager;
    FootPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_foot_det);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.foot_pager);

        ArrayList<Bitmap> images = new ArrayList<>(FootAdapter.imgArray);

        adapter = new FootPagerAdapter(FootDetail.this, images);

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.containsKey("pos"))
        {
            int position = getIntent().getExtras().getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }

        toolbar.setNavigationOnClickListener(v -> {

            FootDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                FootDetail.this.finish();
            }
        });

    }

}