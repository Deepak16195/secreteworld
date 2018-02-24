package com.credosys.solutions.secrete.world.fragments.RecommendedPlacesTab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.HomeAdapter;
import com.credosys.solutions.secrete.world.Adapters.NormalScroll.PlacesAdapter;
import com.credosys.solutions.secrete.world.Pojos.App.HomeContentsPlaces;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by credosys on 22/2/18.
 */

public class PlacesFragment extends MainFragment {
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
        RecyclerView rvPlaces=v.findViewById(R.id.rv_places);

        List<HomeContentsPlaces> list= new ArrayList<>();
        list.add(new HomeContentsPlaces(R.drawable.vadapav,"SHIVAYAM SAGAR PALACE","N/7/12, Ganpati Niwas, Bangur Nagar, Link Road, Goregoan (West)","022 878778787","50",2.0f));
        list.add(new HomeContentsPlaces(R.drawable.vadapav,"RESTAURANT NAME","Address","022 88787454","50",4.0f));
        list.add(new HomeContentsPlaces(R.drawable.vadapav,"SHIVAYAM SAGAR PALACE","N/7/12, Ganpati Niwas, Bangur Nagar, Link Road, Goregoan (West)","022 878778787","50",2.0f));
        list.add(new HomeContentsPlaces(R.drawable.vadapav,"RESTAURANT NAME","Address","022 88787454","50",4.0f));
        list.add(new HomeContentsPlaces(R.drawable.vadapav,"SHIVAYAM SAGAR PALACE","N/7/12, Ganpati Niwas, Bangur Nagar, Link Road, Goregoan (West)","022 878778787","50",2.0f));
        list.add(new HomeContentsPlaces(R.drawable.vadapav,"RESTAURANT NAME","Address","022 88787454","50",4.0f));

        PlacesAdapter homeAdapter=new PlacesAdapter(list);
        rvPlaces.setAdapter(homeAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rvPlaces.setLayoutManager(staggeredGridLayoutManager);
        rvPlaces.setNestedScrollingEnabled(false);
       return v;
    }
}
