package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.credosys.solutions.secrete.world.Adapters.ViewPagers.CustomPagerAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by credosys on 24/2/18.
 */

public class WhereEatFragment extends MainFragment {
    Context context;
    public static WhereEatFragment newInstance() {

        Bundle args = new Bundle();

        WhereEatFragment fragment = new WhereEatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity)getActivity()).showBackButton(true);
        ((MainActivity)getActivity()).setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);

        context=getActivity();
        View v=inflater.inflate(R.layout.fragment_common_content,container,false);
        ViewStub viewStub=v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_where_eat);
        View view=viewStub.inflate();
        ViewPager mViewPager=view.findViewById(R.id.pager);

        view.findViewById(R.id.btn_eat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).setFragments(22);
            }
        });
        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(getActivity());
        mViewPager.setAdapter(mCustomPagerAdapter);
        return v;
    }
}
