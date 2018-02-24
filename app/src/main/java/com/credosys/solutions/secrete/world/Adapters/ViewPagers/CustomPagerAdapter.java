package com.credosys.solutions.secrete.world.Adapters.ViewPagers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.credosys.solutions.secrete.world.R;

/**
 * Created by credosys on 24/2/18.
 */

public class CustomPagerAdapter extends PagerAdapter {
    private int[] mResources = {
            R.drawable.vadapav,
            R.drawable.savpuri,
            R.drawable.img_sabudana,
    };
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.single_pager_img_slider, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_slider);
        imageView.setImageResource(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position,@NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}