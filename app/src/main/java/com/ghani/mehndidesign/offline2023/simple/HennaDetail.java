package com.ghani.mehndidesign.offline2023.simple;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.ghani.mehndidesign.offline2023.simple.Adapter.HennaAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.HennaPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class HennaDetail extends AppCompatActivity {

    ViewPager viewPager;
    HennaPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_henna_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_henna_det);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.henna_pager);

        ArrayList<Bitmap> images = new ArrayList<>(HennaAdapter.imgArray);

        adapter = new HennaPagerAdapter(HennaDetail.this, images);

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.containsKey("pos"))
        {
            int position = getIntent().getExtras().getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }

        toolbar.setNavigationOnClickListener(v -> {

            HennaDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                HennaDetail.this.finish();
            }
        });

    }

}