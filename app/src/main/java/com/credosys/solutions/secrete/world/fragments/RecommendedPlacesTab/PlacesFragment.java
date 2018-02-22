package com.credosys.solutions.secrete.world.fragments.RecommendedPlacesTab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.R;

/**
 * Created by credosys on 22/2/18.
 */

public class PlacesFragment extends Fragment {
    public static PlacesFragment newInstance() {

        Bundle args = new Bundle();

        PlacesFragment fragment = new PlacesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_places,container,false);
       return v;
    }
}
