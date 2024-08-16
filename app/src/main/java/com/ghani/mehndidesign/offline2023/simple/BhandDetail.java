package com.ghani.mehndidesign.offline2023.simple;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.ghani.mehndidesign.offline2023.simple.Adapter.BhandAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.BhandPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class BhandDetail extends AppCompatActivity {

    ViewPager viewPager;
    BhandPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhand_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_bhand_det);
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.bhand_pager);

        ArrayList<Bitmap> images = new ArrayList<>(BhandAdapter.imgArray);

        adapter = new BhandPagerAdapter(BhandDetail.this, images);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("pos"))
        {
            int position = extras.getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }


        toolbar.setNavigationOnClickListener(v -> {

            BhandDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                BhandDetail.this.finish();
            }
        });
    }
}