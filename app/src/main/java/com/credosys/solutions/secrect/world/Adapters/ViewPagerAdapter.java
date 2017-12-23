package com.credosys.solutions.secrect.world.Adapters;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.credosys.solutions.secrect.world.Pojos.Home;
import com.credosys.solutions.secrect.world.fragments.HomeFragement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 21-Dec-17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 5;
    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return HomeFragement.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return HomeFragement.newInstance(1, "Page # 2");
            case 2: // Fragment # 1 - This will show SecondFragment
                return HomeFragement.newInstance(2, "Page # 3");
            case 3: // Fragment # 1 - This will show SecondFragment
                return HomeFragement.newInstance(3, "Page # 4");
            case 4: // Fragment # 1 - This will show SecondFragment
                return HomeFragement.newInstance(4, "Page # 5");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}
