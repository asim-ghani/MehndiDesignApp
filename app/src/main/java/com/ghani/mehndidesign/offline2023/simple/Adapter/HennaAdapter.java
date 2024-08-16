package com.ghani.mehndidesign.offline2023.simple.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ghani.mehndidesign.offline2023.simple.HennaDetail;
import com.ghani.mehndidesign.offline2023.simple.R;
import com.ghani.mehndidesign.offline2023.simple.TrendingDetail;

import java.util.ArrayList;

public class HennaAdapter extends BaseAdapter {

    Context context;
    public static ArrayList<Bitmap> imgArray;

    public HennaAdapter(Context context, ArrayList<Bitmap> imgArray) {
        this.context = context;
        HennaAdapter.imgArray = imgArray;
    }

    @Override
    public int getCount() {
        return imgArray.size();
    }

    @Override
    public Object getItem(int position) {
        return imgArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public boolean isEnabled(int i){
        return true;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        gridView = new View(context);

        gridView = inflater.inflate(R.layout.trending_view, null);


        ImageView imageView = gridView.findViewById(R.id.trending_img);
        imageView.setImageBitmap(imgArray.get(position));

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(350,500));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    int pos = position;

                    Intent intent = new Intent(context, HennaDetail.class);
                    intent.putExtra("pos", pos);
                    context.startActivity(intent);
                }catch (Exception e){

                    e.printStackTrace();
                }

            }
        });
        return gridView;
    }
}
