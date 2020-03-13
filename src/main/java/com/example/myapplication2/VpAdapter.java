package com.example.myapplication2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

public class VpAdapter extends PagerAdapter {
    Context context;
    List<User.ResultsBean> beans;

    public VpAdapter(Context context, List<User.ResultsBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = View.inflate(context, R.layout.itemthree, null);
        PhotoView img = inflate.findViewById(R.id.img);
        Glide.with(context).load(beans.get(position).getUrl()).into(img);
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}
