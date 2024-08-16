package com.ghani.mehndidesign.offline2023.simple;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.ghani.mehndidesign.offline2023.simple.Adapter.EidAdapter;
import com.ghani.mehndidesign.offline2023.simple.Adapter.EidPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class EidDetail extends AppCompatActivity {

    ViewPager viewPager;
    EidPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eid_detail);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_eid_det);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.eid_pager);

        ArrayList<Bitmap> images = new ArrayList<>(EidAdapter.imgArray);

        adapter = new EidPagerAdapter(EidDetail.this, images);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("pos"))
        {
            int position = getIntent().getExtras().getInt("pos");
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(position);
        }

        toolbar.setNavigationOnClickListener(v -> {

            EidDetail.this.finish();
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                EidDetail.this.finish();
            }
        });

    }

}