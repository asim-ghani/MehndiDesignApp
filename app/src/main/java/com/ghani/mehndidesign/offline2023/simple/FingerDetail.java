package com.ghani.mehndidesign.offline2023.simple;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ghani.mehndidesign.offline2023.simple.Adapter.FingerAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.FingerPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class FingerDetail extends AppCompatActivity {

    ViewPager viewPager;
    FingerPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_finger_det);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.finger_pager);

        ArrayList<Bitmap> images = new ArrayList<>(FingerAdapter.imgArray);

        adapter = new FingerPagerAdapter(FingerDetail.this, images);

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.containsKey("pos"))
        {
            int position = extras.getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }

        toolbar.setNavigationOnClickListener(v -> {

            FingerDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                FingerDetail.this.finish();
            }
        });

    }


}