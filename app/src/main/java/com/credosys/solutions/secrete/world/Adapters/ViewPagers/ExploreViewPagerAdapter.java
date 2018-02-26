package com.credosys.solutions.secrete.world.Adapters.ViewPagers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.credosys.solutions.secrete.world.fragments.ExploreTab.GooglePlacesFragment;
import com.credosys.solutions.secrete.world.fragments.ExploreTab.SworldPlacesFragment;

/**
 * Created by win7 on 26-Dec-17.
 */

public class ExploreViewPagerAdapter extends FragmentStatePagerAdapter {
//    private final List<Fragment> mFragmentList = new ArrayList<>();
//    private final List<String> mFragmentTitleList = new ArrayList<>();
    private static final int num=2;
    private String[] txtTitle={"GOOGLE PLACES","SWORLD PLACES"};
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

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return txtTitle[position];
//    }

    @Override
    public int getCount() {
        return num;
    }

//    public void addFragment(Fragment fragment, String title) {
//        mFragmentList.add(fragment);
//        mFragmentTitleList.add(title);
//    }

}
