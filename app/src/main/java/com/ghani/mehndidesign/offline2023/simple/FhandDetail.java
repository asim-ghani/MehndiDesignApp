package com.ghani.mehndidesign.offline2023.simple;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ghani.mehndidesign.offline2023.simple.Adapter.FhandAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.FhandPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class FhandDetail extends AppCompatActivity {

    ViewPager viewPager;
    FhandPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fhand_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_fhand_det);
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.fhand_pager);

        ArrayList<Bitmap> images = new ArrayList<>(FhandAdapter.imgArray);

        adapter = new FhandPagerAdapter(FhandDetail.this, images);

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.containsKey("pos"))
        {
            int position = getIntent().getExtras().getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }

        toolbar.setNavigationOnClickListener(v -> {

            FhandDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                FhandDetail.this.finish();
            }
        });
    }

}