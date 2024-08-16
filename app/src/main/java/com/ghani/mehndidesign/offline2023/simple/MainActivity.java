package com.ghani.mehndidesign.offline2023.simple;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.ghani.mehndidesign.offline2023.simple.Adapter.GridViewAdapter;
import com.ghani.mehndidesign.offline2023.simple.Model.GridModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    GridViewAdapter adapter;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        navigationView = findViewById(R.id.nav_menu);
        drawerLayout = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.setToolbarNavigationClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_more) {
                final String devName = "App Developers"; // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:" + devName)));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/search?q=pub:" + devName)));
                }
                drawerLayout.closeDrawer(GravityCompat.START);

            } else if (id == R.id.nav_rate) {

                app_rating();
                drawerLayout.closeDrawer(GravityCompat.START);

            } else if (id == R.id.nav_share) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Mehndi Designs 2023");
                intent.putExtra(Intent.EXTRA_TEXT, "Hey check out this amazing app");
                startActivity(Intent.createChooser(intent, "choose one"));
                drawerLayout.closeDrawer(GravityCompat.START);

            } else if (id == R.id.feedBack) {

                sendFeedBack();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
            return true;
        });

        gridView = findViewById(R.id.gridView);
        ArrayList<GridModel> gridList = new ArrayList<>();

        gridList.add(new GridModel("Trending 2023", R.drawable.trending));
        gridList.add(new GridModel("New Henna 2023", R.drawable.henna));
        gridList.add(new GridModel("Bridal Designs", R.drawable.bridal));
        gridList.add(new GridModel("Eid Designs", R.drawable.eid));
        gridList.add(new GridModel("Arabic Designs", R.drawable.arabic));
        gridList.add(new GridModel("Foot Designs", R.drawable.foot));
        gridList.add(new GridModel("Front Hand Designs", R.drawable.fhand));
        gridList.add(new GridModel("Back Hand Designs", R.drawable.test));
        gridList.add(new GridModel("Finger Designs", R.drawable.finger));
        gridList.add(new GridModel("Glitter Art", R.drawable.glit));
        gridList.add(new GridModel("Jewelery Art", R.drawable.jew));

        adapter = new GridViewAdapter(MainActivity.this, gridList);
        gridView.setAdapter(adapter);

        onItemClicked();
    }


    private void onItemClicked() {
        gridView.setOnItemClickListener((parent, view, position, id) -> {

            if (position == 0) {

                Intent i = new Intent(MainActivity.this, Trending.class);
                startActivity(i);

            } else if (position == 1) {


                Intent henna = new Intent(MainActivity.this, Henna.class);
                startActivity(henna);


            } else if (position == 2) {

                Intent bridal = new Intent(MainActivity.this, Bridal.class);
                startActivity(bridal);


            } else if (position == 3) {

                Intent eid = new Intent(MainActivity.this, Eid.class);
                startActivity(eid);

            } else if (position == 4) {

                Intent arabic = new Intent(MainActivity.this, Arabic.class);
                startActivity(arabic);

            } else if (position == 5) {

                Intent foot = new Intent(MainActivity.this, Foot.class);
                startActivity(foot);

            } else if (position == 6) {

                Intent fhand = new Intent(MainActivity.this, Fhand.class);
                startActivity(fhand);

            } else if (position == 7) {

                Intent bhand = new Intent(MainActivity.this, Bhand.class);
                startActivity(bhand);

            } else if (position == 8) {

                Intent finger = new Intent(MainActivity.this, Finger.class);
                startActivity(finger);

            } else if (position == 9) {

                Intent glitter = new Intent(MainActivity.this, Glitter.class);
                startActivity(glitter);

            } else if (position == 10) {

                Intent jewelery = new Intent(MainActivity.this, Jewelery.class);
                startActivity(jewelery);
            }
        });
    }

    public void app_rating() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Rate Us:");
        alert.setMessage("If you enjoy using This App, please take a moment to rate it. Thanks for your support!");
        alert.setPositiveButton("Yes", (dialog, which) -> {

            Uri uri = Uri.parse("market://details?id=" + getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id="
                                + getPackageName())));
            }

            dialog.dismiss();
            finish();
        });

        alert.setNegativeButton("No", (dialog, which) -> {
            dialog.dismiss();
            finish();
        });
        alert.create();
        alert.show();
        alert.setCancelable(false);
    }

    public void sendFeedBack() {
        Intent Email = new Intent(Intent.ACTION_SEND);
        Email.setType("text/email");
        Email.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@gmail.com"});
        Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        Email.putExtra(Intent.EXTRA_TEXT, "Dear ...,");
        startActivity(Intent.createChooser(Email, "Send Feedback:"));
    }

}