package com.credosys.solutions.secrete.world.Adapters.ViewPagers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.Pojos.App.MapModal;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by credosys on 17/3/18.
 */

public class MapPagerAdapter extends PagerAdapter {
    private Context context;
    private List<MapModal> list;
    public MapPagerAdapter(Context context, List<MapModal> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.single_map, container, false);
        container.addView(layout);
        return layout;
    }
}
