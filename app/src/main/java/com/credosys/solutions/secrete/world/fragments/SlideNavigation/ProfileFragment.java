package com.credosys.solutions.secrete.world.fragments.SlideNavigation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;

/**
 * Created by win7 on 02-Jan-18.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener{
    LinearLayout LlWall;
    NestedScrollView profileNestedScrollView;
     public static ProfileFragment newInstance() {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_profile,null,false);
        profileNestedScrollView = v.findViewById(R.id.profile_NestedScrollView);
        profileNestedScrollView.setNestedScrollingEnabled(false);
        ((MainActivity)getActivity()).setExpandableTitle(Gravity.NO_GRAVITY);
        ((MainActivity)getActivity()).showBackButton(false);
        ((MainActivity)getActivity()).setAppBarLayoutExpand(false,false);
        ((MainActivity)getActivity()).setCollpsingImage(R.drawable.topbg);

        LlWall=v.findViewById(R.id.ll_wall);
        LlWall.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ll_wall) {
            ((MainActivity)getActivity()).setWall();
        }
    }
}
