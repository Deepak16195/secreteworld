package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by Yogesh on 14-Feb-18.
 */

public class ProfileDeatailsFragment extends MainFragment {
    public static ProfileDeatailsFragment newInstance() {

        Bundle args = new Bundle();

        ProfileDeatailsFragment fragment = new ProfileDeatailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_profile_details,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("DETAILS");
        ((MainActivity)getActivity()).showBackButton(true);
        ((MainActivity)getActivity()).setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);

        return v;
    }
}
