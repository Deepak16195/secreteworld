package com.credosys.solutions.secrete.world.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.MapAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by credosys on 26/2/18.
 */

public class MapViewFragment extends MainFragment implements OnMapReadyCallback, View.OnClickListener {
    private GoogleMap mMap;
    RelativeLayout rlMap;
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static MapViewFragment newInstance() {

        Bundle args = new Bundle();

        MapViewFragment fragment = new MapViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map_view, container, false);
        ((MainActivity) getActivity()).setExpandableTitle(Gravity.NO_GRAVITY);
        ((MainActivity) getActivity()).setAppBarLayoutExpand(false, false);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        rlMap = v.findViewById(R.id.rl_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        rlMap.setOnClickListener(this);

        RecyclerView recyclerView = v.findViewById(R.id.rv_map);
        MapAdapter ma = new MapAdapter();
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(ma);


        return v;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rl_map:
                mainApp.onBackPressed();
                break;
        }

    }
}
