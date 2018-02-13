package com.credosys.solutions.secrete.world.fragments.BottomNaviagion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import  android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.Adapters.ViewPagers.ExploreViewPagerAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by win7 on 23-Dec-17.
 */

public class ExploreFragment extends MainFragment {


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
        Log.d("framgneexploreresume","called");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_explore,null,false);
        final TabLayout fragmentTab=v.findViewById(R.id.fragment_tabs);
        final ViewPager fragmentViewPager = v.findViewById(R.id.fragment_viewpager);

        ((MainActivity)getActivity()).setActionBarTitle("SECRETS AROUND YOU");
        ((MainActivity)getActivity()).setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);

            setupViewPager(fragmentViewPager);
            fragmentTab.setupWithViewPager(fragmentViewPager);
//            fragmentTab.setTabTextColors(R.color.grayColor,R.color.customBlue);
        fragmentTab.setTabTextColors(ContextCompat.getColor(getActivity(), R.color.customBlue),
                ContextCompat.getColor(getActivity(), R.color.grayColor));


//            final View headerView = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_explore_tabs, null, false);
//            LinearLayout linearLayoutOne = headerView.findViewById(R.id.ll_google_places);
//            LinearLayout linearLayout2 = headerView.findViewById(R.id.ll_sworld_places);

//            fragmentTab.getTabAt(0).setCustomView(linearLayoutOne);
//            Log.d("addFragmentCalled", "0");
//            fragmentTab.getTabAt(1).setCustomView(linearLayout2);
//            Log.d("addFragmentCalled", "1");



//            fragmentTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                @Override
//                public void onTabSelected(TabLayout.Tab tab) {
//
//                }
//
//                @Override
//                public void onTabUnselected(TabLayout.Tab tab) {
//
//                }
//
//                @Override
//                public void onTabReselected(TabLayout.Tab tab) {
//
//                }
//            });
//        final int pageMargin = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, 8, getResources() .getDisplayMetrics());
//        fragmentViewPager.setPageMargin(pageMargin);
        return v;
    }
    private void setupViewPager(ViewPager viewPager) {
        Log.d("ExploreFragment","setupViewPager");

        ExploreViewPagerAdapter adapter = new ExploreViewPagerAdapter(getChildFragmentManager());
//        adapter.addFragment(new GooglePlacesFragment(), "ONE");
//        adapter.addFragment(new SworldPlacesFragment(), "TWO");
        viewPager.setAdapter(adapter);
    }

}
