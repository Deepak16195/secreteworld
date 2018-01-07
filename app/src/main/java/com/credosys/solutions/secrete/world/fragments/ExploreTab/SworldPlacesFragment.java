package com.credosys.solutions.secrete.world.fragments.ExploreTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.R;

/**
 * Created by win7 on 26-Dec-17.
 */

public class SworldPlacesFragment extends Fragment {
    public static SworldPlacesFragment newInstance() {
        SworldPlacesFragment fragmentFirst = new SworldPlacesFragment();
//        Bundle args = new Bundle();
//        args.putInt("someInt", page);
//        args.putString("someTitle", title);
//        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }
    public SworldPlacesFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_sworld_places, container, false);
        return v;
    }
}
