package com.credosys.solutions.secrete.world.Adapters.ViewPagers;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.credosys.solutions.secrete.world.fragments.ExploreTab.SworldPlacesFragment;
import com.credosys.solutions.secrete.world.fragments.RecommendedPlacesTab.PlacesFragment;
import com.credosys.solutions.secrete.world.fragments.RecommendedPlacesTab.SuggestFragment;

/**
 * Created by credosys on 22/2/18.
 */

public class RecommendedPlacesAdaper extends FragmentStatePagerAdapter {

    public RecommendedPlacesAdaper(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return PlacesFragment.newInstance();
            case 1:
                return SuggestFragment.newInstance();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return 2;
    }
}
