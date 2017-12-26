package com.credosys.solutions.secrect.world.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.credosys.solutions.secrect.world.fragments.GooglePlacesFragment;
import com.credosys.solutions.secrect.world.fragments.SworldPlacesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 26-Dec-17.
 */

public class ExploreViewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private static final int num=2;
    public ExploreViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return GooglePlacesFragment.newInstance();
            case 1:
                return SworldPlacesFragment.newInstance();
            default:
                return null;
        }
//        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return num;
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

}
