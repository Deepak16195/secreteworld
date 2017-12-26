package com.credosys.solutions.secrect.world.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import  android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.credosys.solutions.secrect.world.Adapters.ExploreViewPagerAdapter;
import com.credosys.solutions.secrect.world.MainActivity;
import com.credosys.solutions.secrect.world.R;

/**
 * Created by win7 on 23-Dec-17.
 */

public class ExploreFragment extends Fragment {

    public static Fragment newInstance() {
        return new ExploreFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("onResumeFragmentExplore","called");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_explore,null,false);
        final TabLayout fragmentTab=v.findViewById(R.id.fragment_tabs);
        final ViewPager fragmentViewPager = v.findViewById(R.id.fragment_viewpager);

        setupViewPager(fragmentViewPager);
        fragmentTab.setupWithViewPager(fragmentViewPager);

        View headerView = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_explore_tabs, null, false);
        LinearLayout linearLayoutOne = headerView.findViewById(R.id.ll_google_places);
        LinearLayout linearLayout2 = headerView.findViewById(R.id.ll_sworld_places);

        fragmentTab.getTabAt(0).setCustomView(linearLayoutOne);
        fragmentTab.getTabAt(1).setCustomView(linearLayout2);
        return v;
    }
    private void setupViewPager(ViewPager viewPager) {
        Log.d("ExploreFragment","setupViewPager");
        ExploreViewPagerAdapter adapter = new ExploreViewPagerAdapter(getActivity().getSupportFragmentManager());
//        adapter.addFragment(new GooglePlacesFragment(), "ONE");
//        adapter.addFragment(new SworldPlacesFragment(), "TWO");
        viewPager.setAdapter(adapter);
    }

}
