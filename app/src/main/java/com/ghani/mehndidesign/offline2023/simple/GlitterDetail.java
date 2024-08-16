package com.ghani.mehndidesign.offline2023.simple;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ghani.mehndidesign.offline2023.simple.Adapter.GlitterAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.GlitterPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class GlitterDetail extends AppCompatActivity {

    ViewPager viewPager;
    GlitterPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glitter_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_glitter_det);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.glitter_pager);

        ArrayList<Bitmap> images = new ArrayList<>(GlitterAdapter.imgArray);

        adapter = new GlitterPagerAdapter(GlitterDetail.this, images);

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.containsKey("pos"))
        {
            int position = getIntent().getExtras().getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }

        toolbar.setNavigationOnClickListener(v -> {

            GlitterDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                GlitterDetail.this.finish();
            }
        });

    }

}