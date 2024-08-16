package com.ghani.mehndidesign.offline2023.simple.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.ghani.mehndidesign.offline2023.simple.R;
import com.ghani.mehndidesign.offline2023.simple.TouchViewPagerIMageView;

import java.util.ArrayList;
import java.util.Objects;

public class EidPagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<Bitmap> images = new ArrayList<Bitmap>();
    LayoutInflater inflater;

    public EidPagerAdapter(Context context, ArrayList<Bitmap> images) {
        this.context = context;
        this.images = images;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((RelativeLayout) object);
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, final int position){

        TouchViewPagerIMageView iMageView;

        View view = inflater.inflate(R.layout.image_view, container, false);

        iMageView = view.findViewById(R.id.imgView);
        iMageView.setImageBitmap(images.get(position));

        Objects.requireNonNull(container).addView(view);

        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
