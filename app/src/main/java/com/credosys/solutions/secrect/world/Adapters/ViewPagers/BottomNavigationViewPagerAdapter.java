package com.credosys.solutions.secrect.world.Adapters.ViewPagers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.credosys.solutions.secrect.world.fragments.BottomNaviagion.ExploreFragment;
import com.credosys.solutions.secrect.world.fragments.BottomNaviagion.HomeFragement;
import com.credosys.solutions.secrect.world.fragments.BottomNaviagion.MoreFragment;
import com.credosys.solutions.secrect.world.fragments.BottomNaviagion.MyDiaryFragment;
import com.credosys.solutions.secrect.world.fragments.BottomNaviagion.RequestFragment;

/**
 * Created by win7 on 21-Dec-17.
 */

public class BottomNavigationViewPagerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 5;
    public BottomNavigationViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    private String titles[]={"HOME","EXPLORE","","REQUEST","DIARY"};
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
                return ExploreFragment.newInstance();
            case 2: // Fragment # 1 - This will show SecondFragment
                return MoreFragment.newInstance();
            case 3: // Fragment # 1 - This will show SecondFragment
                return RequestFragment.newInstance();
            case 4: // Fragment # 1 - This will show SecondFragment
                return MyDiaryFragment.newInstance();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return titles[position];
//    }

}
