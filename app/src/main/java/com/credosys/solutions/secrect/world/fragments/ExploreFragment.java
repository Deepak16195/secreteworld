package com.credosys.solutions.secrect.world.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import  android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrect.world.R;

/**
 * Created by win7 on 23-Dec-17.
 */

public class ExploreFragment extends Fragment {

    public static Fragment getInstance() {
        return new ExploreFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_explore,null,false);
        return v;
    }
}
