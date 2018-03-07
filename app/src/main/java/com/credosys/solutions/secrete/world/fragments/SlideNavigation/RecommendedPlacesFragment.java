package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Adapters.ViewPagers.RecommendedPlacesAdaper;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by credosys on 22/2/18.
 */

public class RecommendedPlacesFragment extends MainFragment implements TabLayout.OnTabSelectedListener {
    String[] tabText = {"PLACES", "WANT TO SUGGEST?"};
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static RecommendedPlacesFragment newInstance() {

        Bundle args = new Bundle();

        RecommendedPlacesFragment fragment = new RecommendedPlacesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainApp.setActionBarTitle("MUMBAI");
        mainApp.setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY, false, false, false);
        mainApp.showBackButton(false);
        View v = inflater.inflate(R.layout.fragment_common_content, container, false);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "avenirltstd_light.otf");
        ViewStub viewStub = v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_recommended_places);
        View inflated = viewStub.inflate();
        TabLayout tabLayout = inflated.findViewById(R.id.fragment_tabs);

        ViewPager viewPager = inflated.findViewById(R.id.frg_rec_places_view_pager);
        RecommendedPlacesAdaper recommendedPlacesAdaper = new RecommendedPlacesAdaper(getChildFragmentManager());
        viewPager.setAdapter(recommendedPlacesAdaper);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(this);
        for (int i = 0; i < 2; i++) {
            tabLayout.getTabAt(i).setCustomView(R.layout.single_tabs);
            TextView tv = (TextView) tabLayout.getTabAt(i).getCustomView();
            tv.setTypeface(font);
            tv.setText(tabText[i]);
        }
        ((TextView)tabLayout.getTabAt(0).getCustomView()).setTextColor(Color.WHITE);
        return v;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
       TextView text=(TextView) tab.getCustomView();
       text.setTextColor(Color.WHITE);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        TextView text=(TextView) tab.getCustomView();
        text.setTextColor(getActivity().getResources().getColor(R.color.tab_layout_text));
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
