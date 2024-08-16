package com.ghani.mehndidesign.offline2023.simple;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.ghani.mehndidesign.offline2023.simple.Adapter.BridalAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.BridalPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class BridalDetail extends AppCompatActivity {

    ViewPager viewPager;
    BridalPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridal_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_bridal_det);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.bridal_pager);

        ArrayList<Bitmap> images = new ArrayList<>(BridalAdapter.imgArray);

        adapter = new BridalPagerAdapter(BridalDetail.this, images);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("pos"))
        {
            int position = extras.getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }


        toolbar.setNavigationOnClickListener(v -> {

            BridalDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                BridalDetail.this.finish();
            }
        });
    }
}