package com.credosys.solutions.secrect.world.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrect.world.Adapters.NormalScroll.GoogleHorizontalAdapter;
import com.credosys.solutions.secrect.world.Pojos.ExploreGooglePlaces;
import com.credosys.solutions.secrect.world.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 26-Dec-17.
 */

public class GooglePlacesFragment extends Fragment {

    RecyclerView rvFamous;
    public static GooglePlacesFragment newInstance() {
        GooglePlacesFragment fragmentFirst = new GooglePlacesFragment();
//        Bundle args = new Bundle();
//        args.putInt("someInt", page);
//        args.putString("someTitle", title);
//        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }
    public GooglePlacesFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_google_places, container, false);
        rvFamous=v.findViewById(R.id.rv_famous);
        List<ExploreGooglePlaces> gplaces=new ArrayList<>();
        gplaces.add(new ExploreGooglePlaces("Amazing Views",3));
        gplaces.add(new ExploreGooglePlaces("Historical Sites",37));
        gplaces.add(new ExploreGooglePlaces("Others",0));
        gplaces.add(new ExploreGooglePlaces("Art, Muesums and Theaters",20));
        gplaces.add(new ExploreGooglePlaces("Typical Dishes & Food",0));
        gplaces.add(new ExploreGooglePlaces("Music World",0));
        GoogleHorizontalAdapter gha=new GoogleHorizontalAdapter(gplaces);
        rvFamous.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
        rvFamous.setAdapter(gha);
        return v;
    }
}
