package com.ghani.mehndidesign.offline2023.simple.Adapter;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ghani.mehndidesign.offline2023.simple.Arabic;
import com.ghani.mehndidesign.offline2023.simple.Bhand;
import com.ghani.mehndidesign.offline2023.simple.Bridal;
import com.ghani.mehndidesign.offline2023.simple.Eid;
import com.ghani.mehndidesign.offline2023.simple.Fhand;
import com.ghani.mehndidesign.offline2023.simple.Finger;
import com.ghani.mehndidesign.offline2023.simple.Foot;
import com.ghani.mehndidesign.offline2023.simple.Glitter;
import com.ghani.mehndidesign.offline2023.simple.Henna;
import com.ghani.mehndidesign.offline2023.simple.Jewelery;
import com.ghani.mehndidesign.offline2023.simple.Model.GridModel;
import com.ghani.mehndidesign.offline2023.simple.R;
import com.ghani.mehndidesign.offline2023.simple.Trending;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GridViewAdapter extends ArrayAdapter<GridModel> {


    public GridViewAdapter(@NonNull Context context, ArrayList<GridModel> gridModelArrayList){
        super(context, 0, gridModelArrayList);
    }
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_view, parent, false);

        }

        GridModel model = getItem(position);
        TextView name = listItemView.findViewById(R.id.txt_grid);
        ImageView image = listItemView.findViewById(R.id.img_grid);
        LinearLayout cardImg = listItemView.findViewById(R.id.card_images);


        name.setText(model.getCate_name());
        image.setImageResource(model.getCate_img());

        /*cardImg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("HandlerLeak")
            @Override
            public void onClick(View v) {

                if (position == 0){

                    Intent i = new Intent(getContext(), Trending.class);
                    getContext().startActivity(i);
                } else if (position == 1) {

                    Intent henna = new Intent(getContext(), Henna.class);
                    getContext().startActivity(henna);
                } else if (position == 2) {
                    ProgressDialog dialog = new ProgressDialog(getContext());
                    dialog.setMessage("Loading Images.....");
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setIndeterminate(true);
                    dialog.setCancelable(false);
                    dialog.show();
                    Intent bridal = new Intent(getContext(), Bridal.class);
                    getContext().startActivity(bridal);

                    Runnable progressRun = new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    };
                    Handler dismiss = new Handler();
                    dismiss.postDelayed(progressRun, 500);



                } else if (position == 3) {

                    Intent eid = new Intent(getContext(), Eid.class);
                    getContext().startActivity(eid);
                } else if (position == 4) {

                    Intent arabic = new Intent(getContext(), Arabic.class);
                    getContext().startActivity(arabic);
                } else if (position == 5) {
                    Intent foot = new Intent(getContext(), Foot.class);
                    getContext().startActivity(foot);
                } else if (position == 6) {
                    Intent fhand = new Intent(getContext(), Fhand.class);
                    getContext().startActivity(fhand);
                } else if (position == 7) {
                    Intent bhand = new Intent(getContext(), Bhand.class);
                    getContext().startActivity(bhand);
                } else if (position == 8) {
                    Intent finger = new Intent(getContext(), Finger.class);
                    getContext().startActivity(finger);
                } else if (position == 9) {
                    Intent glitter = new Intent(getContext(), Glitter.class);
                    getContext().startActivity(glitter);
                } else if (position == 10) {
                    Intent jewelery = new Intent(getContext(), Jewelery.class);
                    getContext().startActivity(jewelery);
                }
            }
        });*/

        return listItemView;
    }
}
